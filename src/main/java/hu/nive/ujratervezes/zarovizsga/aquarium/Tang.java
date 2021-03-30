package hu.nive.ujratervezes.zarovizsga.aquarium;

public class Tang extends Fish {
    public Tang(String name, int weight, String color) {
        super(name, weight, color);
        super.memoryLoss = true;
    }

    @Override
    public void feed() {
        super.weight++;
    }
}
