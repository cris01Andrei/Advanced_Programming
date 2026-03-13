import java.util.HashMap;
import java.util.Map;

public class Person implements Profile {
    String ID, name;
    String birthDate;
    Map<Profile, String> relationships = new HashMap<>();

    public Person(String ID, String name, String birthDate) {
        this.ID = ID;
        this.name = name;
        this.birthDate = birthDate;
    }

    public void addRelationship(Profile p, String context) {
        relationships.put(p, context);
    }

    @Override
    public int getImportance() {
        return relationships.size();
    }

    @Override
    public String myID() {
        return this.ID;
    }

    @Override
    public String myName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Persoana " + name + " (Născut: " + birthDate + ") | Conexiuni: " + getImportance();
    }
}