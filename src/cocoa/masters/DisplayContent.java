package cocoa.masters;

import java.util.Arrays;
import java.util.List;

public class DisplayContent {
	void printMapAndInfo(List<String> stage, String[][] encrypt) {
		System.out.println("\n" + stage.get(0) + "\n");
		stage.stream()
			.takeWhile(s -> !s.contains("="))
			.filter(s -> !s.contains("Stage"))
			.forEach(System.out::println);
		System.out.println("\n가로크기 : " + encrypt[0].length);
		if (Arrays.asList(encrypt[encrypt.length - 1]).contains("4")) {
			System.out.println("세로크기 : " + (encrypt.length - 1));
		} else {
			System.out.println("세로크기 : " + (encrypt.length));
		}
		int[] objects = findObject(encrypt);
		int[] pCoordinate = findPlayer(encrypt);

		System.out.println("구멍의 수 : " + objects[0]);
		System.out.println("공의 수 : " + objects[1]);
		System.out.println("플레이어 위치 (" + (pCoordinate[0] + 1) + ", " + (pCoordinate[1] + 1) + ")");

	}

	void printMap(String[][] decrypt) {
		System.out.print("\n");
		for (String[] strings : decrypt) {
			for (int j = 0; j < decrypt[0].length; j++) {
				System.out.print(strings[j]);
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	int[] findObject(String[][] encrypt) {

		int count1 = 0;
		int count2 = 0;
		for (String[] strings : encrypt) {
			for (int j = 0; j < encrypt[0].length; j++) {
				if (strings[j].equals("1")) {
					count1++;
				}
				if (strings[j].equals("2")) {
					count2++;
				}
			}
		}
		return new int[] {count1, count2};
	}

	int[] findPlayer(String[][] encrypt) {

		int[] coordP = new int[] {0, 0};
		for (int i = 0; i < encrypt.length; i++) {
			for (int j = 0; j < encrypt[0].length; j++) {
				if (encrypt[i][j].equals("3") || encrypt[i][j].equals("5")) {
					coordP[0] = i;
					coordP[1] = j;
					return coordP; /* P 찾았으면 바로 빠져나오기*/
				}
			}
		}
		return coordP;
	}
}

