package cocoa.week5.project;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Recipe {
    public void checkRecipe(ArrayList<JLabel> ingredients) {
//ingredients

    }

    public static void main(String[] args) {

        HashMap<String, ArrayList<String>> menu = new HashMap<>();
        menu.put("아메리카노", new ArrayList<String>(List.of("물", "에스프레소샷")));
        menu.put("바닐라라떼", new ArrayList<String>(List.of("물", "에스프레소샷", "우유", "바닐라시럽")));

        System.out.println("menu.keySet() : " + menu.keySet());
        System.out.println("menu.get(\"바닐라라떼\") : " + menu.get("바닐라라떼"));

        for (String i : menu.keySet()) {
            System.out.println(i + "\t = \t" + menu.get(i));
        }

        ArrayList<String> list1 = new ArrayList<>(menu.get("바닐라라떼"));
        System.out.println(list1 + "     " + list1.size());
        list1.remove("물");
        System.out.println(list1 + "     " + list1.size());
    }
}
