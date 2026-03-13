import java.util.HashMap;
import java.util.Map;

public class Company implements Profile {
    String ID, name;
    String industry;
    Map<Profile, String> relationships = new HashMap<>();

    public Company(String ID, String name, String industry) {
        this.ID = ID;
        this.name = name;
        this.industry = industry;
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
        return "Companie " + name + " (Domeniu: " + industry + ") | Conexiuni: " + getImportance();
    }
}