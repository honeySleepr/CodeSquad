package cocoa.masters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CreateGame {
	List<String> stage1 = new ArrayList<>();
	List<String> stage2 = new ArrayList<>();
	String[][] encrypt1;
	String[][] encrypt2;

	CreateGame() {
		readConsole();
		chooseOption();
	}

	CreateGame(String[][] encrypt) {
		DisplayContent display = new DisplayContent();
		ConvertMap convertMap = new ConvertMap();
		display.printMap(convertMap.decryptMap(encrypt));
	}

	private void readConsole() {
		List<String> readConsole = new ArrayList<>();
		System.out.println("맵 입력 후 빈 줄에 Enter 입력");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		while (!readConsole.contains("")) {
			try {
				String st = input.readLine();
				readConsole.add(st);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		createMapInfo(readConsole);
	}

	private void createMapInfo(List<String> readConsole) {
		int breakLineIndex = 0;
		for (String s : readConsole) {
			if (s.contains("=")) {
				breakLineIndex = readConsole.indexOf(s);
			}
		}
		ConvertMap convertMap = new ConvertMap();
		this.stage1 = readConsole.subList(0, breakLineIndex + 1);
		this.stage2 = readConsole.subList(breakLineIndex + 1, readConsole.size() - 1);
		this.encrypt1 = convertMap.encryptMap(stage1, make2DArray(stage1));
		this.encrypt2 = convertMap.encryptMap(stage2, make2DArray(stage2));
	}

	private void chooseOption() {
		DisplayContent displayContent = new DisplayContent();
		String menu = checkInput();
		if (menu.equals("1")) {
			displayContent.printMapAndInfo(stage1, encrypt1);
			displayContent.printMapAndInfo(stage2, encrypt2);
		}
		if (menu.equals("2")) {
			ConvertMap convertMap = new ConvertMap();
			displayContent.printMap(convertMap.decryptMap(encrypt2));
			new Control(encrypt2);
		}
	}

	private String[][] make2DArray(List<String> stage) {

		int maxWidth = 0;
		int maxHeight = stage.size() - 1;
		for (int i = 1; i < stage.size(); i++) {
			if (maxWidth < stage.get(i).length()) {
				maxWidth = stage.get(i).length();
			}
		}
		String[][] encrypt = new String[maxHeight][maxWidth];

		for (String[] s : encrypt) {
			Arrays.fill(s, "");
		}
		return encrypt;
	}

	private String checkInput() {
		Scanner sc = new Scanner(System.in);
		String menu = "";
		while (!(menu.equals("1")) && !(menu.equals("2"))) {
			System.out.print("미션 단계를 입력하세요 [ 1 또는 2 ] \n> ");
			menu = sc.nextLine();
		}
		return menu;
	}
}
