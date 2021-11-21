package cocoa.week3.ShellMission;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

//todo: 블로그에서 본걸 따라 쳐본건데 완성도 안됐고 이해도 안돼서 일단 패스..

//public class MakeShell {
//    private static class StreamGobbler implements Runnable {
//        private InputStream inputStream;
//        private Consumer<String> consumer;
//
//        public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
//            this.inputStream = inputStream;
//            this.consumer = consumer;
//        }
//
//        public void run() {
//            try {
//                new BufferedReader(new InputStreamReader(inputStream, "euc-kr")).lines()
//                        .forEach(consumer);
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static void main(String[] args) throws IOException, InterruptedException {
//        ProcessBuilder builder = new ProcessBuilder();
//
//        Scanner sc = new Scanner(System.in);
//        builder.command("cmd.exe", "/c", "dir");
////            builder.command(sc.next());
//
//        builder.directory(new File(System.getProperty("user.home")));
//        Process process = builder.start();
//        StreamGobbler streamGobbler =
//                new StreamGobbler(process.getInputStream(), System.out::println);
//        Executors.newSingleThreadExecutor().submit(streamGobbler);
//        int exitCode = process.waitFor();
//        assert exitCode == 0;
//    }
//}