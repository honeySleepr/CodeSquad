package cocoa.week5.project;

import javax.swing.*;
import java.util.*;

public class Recipe {
    ArrayList<String> selected = new ArrayList<>();
    final HashMap<String, ArrayList<String>> menu = new HashMap<>();

    public Recipe() {
        /*한번 menu에 입력되고 그 이후부턴 다시 입력될 필요가 없는데 어떻게 해야되지?*/
        menu.put("카페 라떼", new ArrayList<>(List.of("에스프레소샷", "우유")));
        menu.put("바닐라 라떼", new ArrayList<>(List.of("에스프레소샷", "우유", "바닐라시럽")));
        menu.put("돌체 라떼", new ArrayList<>(List.of("우유", "에스프레소샷", "연유")));
        menu.put("카페 모카", new ArrayList<>(List.of("에스프레소샷", "우유", "모카시럽")));
        menu.put("카라멜 마끼아또", new ArrayList<>(List.of("에스프레소샷", "우유", "바닐라시럽", "카라멜시럽")));
        menu.put("자바칩 프라푸치노", new ArrayList<>(List.of("에스프레소샷", "자바칩", "우유", "모카시럽", "간얼음")));
        menu.put("모카 프라푸치노", new ArrayList<>(List.of("에스프레소샷", "우유", "모카시럽", "간얼음")));
        menu.put("바닐라 프라푸치노", new ArrayList<>(List.of("바닐라시럽", "우유", "간얼음")));
        menu.put("페레로로쉐 프라푸치노", new ArrayList<>(List.of("우유", "모카시럽", "헤이즐넛시럽", "간얼음", "자바칩")));
        menu.put("하겐다즈 녹차 프라푸치노", new ArrayList<>(List.of("에스프레소샷", "우유", "그린티파우더", "바닐라시럽", "간얼음")));
        menu.put("버터비어 프라푸치노", new ArrayList<>(List.of("우유", "카라멜시럽", "헤이즐넛시럽", "바닐라시럽", "간얼음")));
        menu.put("슈렉 프라푸치노", new ArrayList<>(List.of("에스프레소샷", "우유", "그린티파우더", "모카시럽", "간얼음", "자바칩")));
    }

    public String checkRecipe(ArrayList<JLabel> ingredients) {
        String drink = null;
String drink2 = "";
        System.out.println("1 : "+drink+",  2: "+ drink2);
        for (JLabel j : ingredients) {
            selected.add(j.getText().trim());
        }
        Collections.sort(selected);

        for (String i : menu.keySet()) {
            Collections.sort(menu.get(i));
            if (selected.equals(menu.get(i))) {
                System.out.println(i);
                drink = i;
                break;
            }
        }
               return drink;
    }

    public void inputRecipe() {

//        System.out.println("menu.keySet() : " + menu.keySet());
//        System.out.println("menu.get(\"바닐라라떼\") : " + menu.get("바닐라라떼"));

        for (String i : menu.keySet()) {
            System.out.println(i + "\t = \t" + menu.get(i));
        }

        ArrayList<String> list1 = new ArrayList<>(menu.get("바닐라라떼"));
        System.out.println(list1 + "     " + list1.size());
        list1.remove("물");
        System.out.println(list1 + "     " + list1.size());
    }
}
