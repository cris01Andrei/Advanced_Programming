import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SocialNetwork {
    List<Profile> network = new ArrayList<>();

    public void addProfile(Profile profile) {
        network.add(profile);
    }

    public void printNetwork() {
        network.sort(Comparator.comparingInt(Profile::getImportance).reversed());

        for (Profile p : network) {
            System.out.println(p);
        }
    }
}