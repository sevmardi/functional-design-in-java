package exam;

import java.util.ArrayList;
import java.util.List;

public class ListOfPersons {
    public static void main(String[] args) {
        List names = new ArrayList();
        names.add("Jon");

        List<Person> people = names.stream().map(Person::new).toArray(Person[]::new);

    }
}
