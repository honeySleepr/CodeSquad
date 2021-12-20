package cocoa.masters;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConvertMap3 {
    private HashMap<String, String> encrypt = new HashMap<>();
    private HashMap<String, String> decrypt = new HashMap<>();

    ConvertMap3() {
         /* HashMap에 한번만 입력되도록 setMap() 을 만들어 써볼까*/
        encrypt.put("#","0");
        encrypt.put("O","1");
        encrypt.put("o","2");
        encrypt.put("P","3");
        encrypt.put("=","4");
        encrypt.put("0","6");
    }

    ConvertMap3(String[][] encrypt) {
        DisplayContent display = new DisplayContent();
        display.printMap(decryptMap3(encrypt));
    }

    public String[][] encryptMap3(List<String> stage) {

        String[][] encryptTemp = make2DArray3(stage);
        for (int i = 0; i < stage.size() - 1; i++) {
            String[] rows = stage.get(i + 1).split("");
            for (int j = 0; j < rows.length; j++) {
                /*HashMap으로 해보자*/
                switch (rows[j]) {
                    case "#":
                        encryptTemp[i][j] = "0";
                        break;
                    case "O":
                        encryptTemp[i][j] = "1";
                        break;
                    case "o":
                        encryptTemp[i][j] = "2";
                        break;
                    case "P":
                        encryptTemp[i][j] = "3";
                        break;
                    case "=":
                        encryptTemp[i][j] = "4";
                        break;
                    case "0":
                        encryptTemp[i][j] = "6";
                        break;
                    default:
                        break;
                }
            }
        }
        return encryptTemp;
    }

    public String[][] decryptMap3(String[][] encrypt) {
        String[][] decryptedMap = new String[encrypt.length][encrypt[0].length];
        for (String[] s : decryptedMap) {
            Arrays.fill(s, "");
        }
        for (int i = 0; i < encrypt.length; i++) {
            for (int j = 0; j < encrypt[0].length; j++) {

                switch (encrypt[i][j]) {
                    case "0":
                        decryptedMap[i][j] = "#";
                        break;
                    case "1":
                        decryptedMap[i][j] = "O";
                        break;
                    case "2":
                        decryptedMap[i][j] = "o";
                        break;
                    case "3":
                    case "5":
                        decryptedMap[i][j] = "P";
                        break;
                    case "6":
                        decryptedMap[i][j] = "0";
                        break;
                    default:
                        decryptedMap[i][j] = " ";
                        break;
                }
            }
        }
        return decryptedMap;
    }

    private String[][] make2DArray3(List<String> stage) {

        int maxWidth = 0;
        int maxHeight = stage.size() - 1;
        for (int i = 1; i < stage.size(); i++) {
            if (maxWidth < stage.get(i).length()) {
                maxWidth = stage.get(i).length();
            }
        }
        String[][] encrypt = new String[maxHeight][maxWidth - 1];  //make2DArray 와 다르다

        for (String[] s : encrypt) {
            Arrays.fill(s, "");
        }
        return encrypt;
    }
}
