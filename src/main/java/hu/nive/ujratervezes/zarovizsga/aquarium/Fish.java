package hu.nive.ujratervezes.zarovizsga.aquarium;

public abstract class Fish {
    private String name;
    protected int weight;
    private String color;
    protected boolean memoryLoss;

    public Fish(String name, int weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public String status() {
        return name + ", weight: " + weight + ", color: " + color + ", short term memory loss: " + memoryLoss;
    }

    public boolean hasMemoryLoss() {
        return memoryLoss;
    }

    abstract public void feed();
}
