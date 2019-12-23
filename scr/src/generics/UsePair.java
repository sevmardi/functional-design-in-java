package generics;

import java.time.LocalDate;

public class UsePair {
    Pair<String> p = new Pair("Fre", LocalDate.now());
    String left = p.getLeft();

}
