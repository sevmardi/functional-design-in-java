package exam;

public class Person {
    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
