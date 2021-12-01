package cocoa.week5.project;

import javax.swing.*;
import java.util.*;

public class CheckRecipe {
    ArrayList<String> selected = new ArrayList<>();
    HashMap<String, ArrayList<String>> menu;
    ArrayList<String> toBeMade;

    public CheckRecipe(HashMap<String, ArrayList<String>> menu, ArrayList<String> toBeMade) {
        this.menu = menu;
        this.toBeMade = toBeMade;
    }

    public String checkRecipe(ArrayList<JLabel> ingredients) {
        String drink = null;

        for (JLabel j : ingredients) {
            selected.add(j.getText().trim());
        }
        Collections.sort(selected);

        for (String i : menu.keySet()) {
            Collections.sort(menu.get(i));
            if (selected.equals(menu.get(i))) {

                this.toBeMade.remove(i);
                drink = i;
                break;
            }
        }
        selected.clear();
        return drink;
    }
}

