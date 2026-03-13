public class Programmer extends Person {
    String language;

    public Programmer(String ID, String name, String birthDate, String language) {
        super(ID, name, birthDate);
        this.language = language;
    }

    @Override
    public String toString() {
        return "Programator " + name + " (Limbaj: " + language + ") | Conexiuni: " + getImportance();
    }
}