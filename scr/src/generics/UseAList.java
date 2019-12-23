package generics;

import java.util.ArrayList;
import java.util.List;

public class UseAList {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Majoed");
        for (String s : names) {
            System.out.println(s);
        }
    }
}
