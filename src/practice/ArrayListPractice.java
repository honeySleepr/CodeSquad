package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListPractice {
    public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        arrList.add(30); //[30]
        arrList.add(40); //[30,40]
        arrList.add(10); //[30,40,10] : 맨 뒤에 순차적으로 추가
        arrList.add(1,20); // [30,20,40,10] : 인덱스(1)에 요소(20)를 추가

        arrList.get(3); // 10 : 인덱스(3)의 요소 반환

        arrList.set(2,44); // [30,20,44,10] : 인덱스(2)의 요소를 수정(44)

        arrList.size(); // 4 : ArrayList의 크기 반환

        arrList.remove((Integer) 44); // [30,20,10] . 인덱스 지정해서도 가능

        Collections.sort(arrList); // [10,20,30] : 오름차순 정렬

        arrList.sort(Collections.reverseOrder()); // [30,20,10] : 내림차순 정렬

        List<Integer> arrList2 = new ArrayList<>(List.of(10,20,30));// 이런식으로 생성 가능

        arrList.equals(arrList2); // false : 순서까지 일치해야 true
        arrList.contains(30); // true
        arrList.clear(); // [] : arrList 지움
    }
}
