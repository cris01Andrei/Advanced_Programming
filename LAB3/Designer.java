public class Designer extends Person {
    String type;

    public Designer(String ID, String name, String type) {
        super(ID, name);
        this.type = type;
    }

    @Override
    public String toString() {
        return "Designer " + this.name;
    }
}