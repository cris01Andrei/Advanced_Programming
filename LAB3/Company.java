public class Company implements Profile, Comparable<Company> {
    String ID, name;

    public Company(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    @Override
    public int compareTo(Company temp) {
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

    @Override
    public String toString() {
        return "Companie " + myName();
    }
}
