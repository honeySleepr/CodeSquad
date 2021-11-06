package cocoa.day3;

class Test{
    int field1;
    String field2;

    public void method1() {
        System.out.println("자바 프로그래밍!!");
    }
}

public class Tcp{
    public static void main(String[] args) {
        Test myTest = new Test();
        myTest.method1();
    }
}