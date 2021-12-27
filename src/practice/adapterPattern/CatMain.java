package practice.adapterPattern;

public class CatMain {
    public static void main(String[] args) {
        KoreanShortHair cat = new KoreanShortHair();

        System.out.println("고양이는");
        testCat(cat);

        /*원래는 cat 만 다뤘다가 이제 dog 로 확장*/

        Jindo dog = new Jindo();

        System.out.println("강아지는");
        /*testCat(dog);  이렇게 하려면 기존 메소드인 testCat을 바꿔줘야한다. OCP 위배!*/

        Cat dogAdapter = new DogAdapter(dog); /*중간 어댑터 역할을 하는 DogAdapter 활용*/
        testCat(dogAdapter);
    }


    public static void testCat(Cat cat) {
        cat.meow();
    }
}