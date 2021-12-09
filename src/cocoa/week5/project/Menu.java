package cocoa.week5.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Menu {
    HashMap<String, ArrayList<String>> menu = new HashMap<>();
    ArrayList<String> toBeMade = new ArrayList<>();
    CheckRecipe recipe;

    public Menu() {

        createMenu("카페 라떼", "에스프레소샷,우유");
        createMenu("바닐라 라떼", "에스프레소샷,우유,바닐라시럽");
        createMenu("돌체 라떼", "에스프레소샷,우유,연유");
        createMenu("카페 모카", "에스프레소샷,우유,모카시럽");
        createMenu("카라멜 마끼아또", "에스프레소샷,우유,바닐라시럽,카라멜시럽");
        createMenu("자바칩 프라푸치노", "에스프레소샷,우유,모카시럽,자바칩,간얼음");
        createMenu("바닐라 프라푸치노", "우유,바닐라시럽,간얼음");
        createMenu("페레로로쉐 프라푸치노", "우유,모카시럽,헤이즐넛시럽,자바칩,간얼음");
        createMenu("하겐다즈 녹차 프라푸치노", "에스프레소샷,우유,그린티파우더,바닐라시럽,간얼음");
        createMenu("버터비어 프라푸치노", "우유,카라멜시럽,헤이즐넛시럽,바닐라시럽,간얼음");
        createMenu("슈렉 프라푸치노", "에스프레소샷,우유,그린티파우더,모카시럽,자바칩,간얼음");

        toBeMade.addAll(this.menu.keySet());
        setMenu();
    }

    public void createMenu(String drink, String ingredients) {
        ArrayList<String> ingredientList = new ArrayList<>(List.of(ingredients.trim().split("\\s*,\\s*")));
        menu.put(drink, ingredientList);
    }

    public void setMenu() {
        this.recipe = new CheckRecipe(menu, toBeMade);
    }

    public CheckRecipe getMenu() {
        return this.recipe;
    }
}
