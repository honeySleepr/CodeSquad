package cocoa.masters;

import java.util.Arrays;
import java.util.List;

public class ConvertMap {
    public String[][] encryptMap(List<String> stage, String[][] encrypt) {
        for (int i = 0; i < stage.size() - 1; i++) {
            String[] rows = stage.get(i + 1).split("");
            for (int j = 0; j < rows.length; j++) {

                switch (rows[j]) {
                    case "#":
                        encrypt[i][j] = "0";
                        break;
                    case "O":
                        encrypt[i][j] = "1";
                        break;
                    case "o":
                        encrypt[i][j] = "2";
                        break;
                    case "P":
                        encrypt[i][j] = "3";
                        break;
                    case "=":
                        encrypt[i][j] = "4";
                        break;
                    default:
                        break;
                }
            }
        }
        return encrypt;
    }
    public String[][] decryptMap(String[][] encrypt) {
        String[][] decrypt = new String[encrypt.length][encrypt[0].length];
        for (String[] s : decrypt) {
            Arrays.fill(s, "");
        }
        for (int i = 0; i < encrypt.length; i++) {
            for (int j = 0; j < encrypt[0].length; j++) {

                switch (encrypt[i][j]) {
                    case "0":
                        decrypt[i][j] = "#";
                        break;
                    case "1":
                        decrypt[i][j] = "O";
                        break;
                    case "2":
                        decrypt[i][j] = "o";
                        break;
                    case "3":
                        decrypt[i][j] = "P";
                        break;
                    default:
                        decrypt[i][j] = " ";
                        break;
                }
            }
        }
        return decrypt;
    }
}
