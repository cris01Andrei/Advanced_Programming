public class Main {
    public static void main(String[] args) {
        Company google = new Company("C1", "Google", "Tech");
        Company apple = new Company("C2", "Apple", "Hardware");

        Programmer ion = new Programmer("P1", "Ion", "20-05-1995", "Java");
        Designer ana = new Designer("P2", "Ana", "15-03-1998", "Figma");
        Programmer claudiu = new Programmer("P3", "Claudiu", "10-11-1992", "C++");

        ion.addRelationship(google, "Java Developer");
        ion.addRelationship(ana, "Colegi");
        ion.addRelationship(claudiu, "Prieteni");

        ana.addRelationship(google, "UX Designer");
        ana.addRelationship(ion, "Colegi");

        claudiu.addRelationship(apple, "C++ Developer");

        google.addRelationship(ion, "Angajat");
        google.addRelationship(ana, "Angajat");

        apple.addRelationship(claudiu, "Angajat");

        SocialNetwork sn = new SocialNetwork();
        sn.addProfile(google);
        sn.addProfile(apple);
        sn.addProfile(ion);
        sn.addProfile(ana);
        sn.addProfile(claudiu);

        System.out.println("******** Rețeaua Ordonată După Importanță (Descrescător) ********");
        sn.printNetwork();
    }
}