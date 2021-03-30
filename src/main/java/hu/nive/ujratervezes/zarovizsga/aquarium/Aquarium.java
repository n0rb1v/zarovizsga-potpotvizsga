package hu.nive.ujratervezes.zarovizsga.aquarium;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> fish = new ArrayList<>();


    public void addFish(Fish f) {
        fish.add(f);
    }

    public List<String> getStatus() {
        List<String> result = new ArrayList<>();
        for (Fish item : fish) {
            result.add(item.status());
        }
        return result;
    }

    public void removeFish() {
        List<Fish> del = new ArrayList<>();
        for (Fish item : fish) {
            if (item.getWeight() > 10) {
                del.add(item);
            }
        }
        fish.removeAll(del);
    }

    public void feed() {
        for (Fish item : fish) {
            item.feed();
        }

    }
}
