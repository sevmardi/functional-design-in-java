package exam;

import java.util.Arrays;

public class UseSuperIterable {
    public static void main(String[] args) {
        SuperIterable<String> sis = new SuperIterable<>(
                Arrays.asList("Fred", "Jim", "Sheila")
        );

        for (String s : sis) {
            System.out.println(" > " + s);
        }
    }
}
