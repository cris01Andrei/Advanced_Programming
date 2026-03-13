public class Designer extends Person {
    String designTool;

    public Designer(String ID, String name, String birthDate, String designTool) {
        super(ID, name, birthDate);
        this.designTool = designTool;
    }

    @Override
    public String toString() {
        return "Designer " + name + " (Soft: " + designTool + ") | Conexiuni: " + getImportance();
    }
}