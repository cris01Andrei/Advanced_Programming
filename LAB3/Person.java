import java.util.Map;
import java.util.HashMap;

public class Person implements Profile, Comparable<Person> {
    String ID, name;

    Map<Person, String> selection = new HashMap<>();
    Map<Company, String> select = new HashMap<>();

    public Person(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public void Knowing(Person p, String context) {
        selection.put(p, context);
    }

    public void Having(Company c, String function) {
        select.put(c, function);
    }

    @Override
    public String toString() {
        return "Persoana " + myName();
    }

    @Override
    public int compareTo(Person temp) {
        return name.compareTo(temp.name);
    }

    @Override
    public String myID() {
        return this.ID;
    }

    @Override
    public String myName() {
        return this.name;
    }
}