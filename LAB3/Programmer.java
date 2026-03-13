public class Programmer extends Person {
    String language;

    public Programmer(String ID, String name, String language) {
        super(ID, name);
        this.language = language;
    }

    @Override
    public String toString() {
        return "Programator " + this.name;
    }
}