package cocoa.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class txtFileTest {
    public static void main(String[] args) {
        try{File file = new File("members.txt");
        Scanner sc = new Scanner(file);
        System.out.println(sc.next().toCharArray());
                sc.close();}
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
