package cocoa.week5.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Menu {
    HashMap<String, ArrayList<String>> menu = new HashMap<>();
    ArrayList<String> toBeMade = new ArrayList<>();
    CheckRecipe recipe;

    public Menu() {

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

        toBeMade.addAll(this.menu.keySet());
        setMenu();
    }

    public void setMenu() {
        this.recipe = new CheckRecipe(menu, toBeMade);

    }

    public CheckRecipe getMenu() {
        return this.recipe;
    }
}
