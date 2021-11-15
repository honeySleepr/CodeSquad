package cocoa.week3.ShellMission;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Shell {
    public static void main(String[] args) {
        Process p;
        try{
            List<String> commandList = new ArrayList<>();
            commandList.add("cmd");
            commandList.add("/c");
            commandList.add("dir");
            commandList.add("cd");
            ProcessBuilder pb = new ProcessBuilder();
            pb.command(commandList);
            p = pb.start();

            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        }
        catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }

}
