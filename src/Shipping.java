import java.util.*;

class ContainerShip {
    private String name;
    private double maxWeightTons;
    private int maxContainers;
    private double speedKnots;
    private List<Container> containers = new ArrayList<>();

    public ContainerShip(String name, double speedKnots, int maxContainers, double maxWeightTons) {
        this.name = name;
        this.speedKnots = speedKnots;
        this.maxContainers = maxContainers;
        this.maxWeightTons = maxWeightTons;
    }

    public boolean loadContainer(Container c) {
        if (containers.size() >= maxContainers || getTotalWeight() + c.getTotalWeight() > maxWeightTons * 1000) {
            return false;
        }
        containers.add(c);
        return true;
    }

    public boolean unloadContainer(String serial) {
        return containers.removeIf(c -> c.getSerialNumber().equals(serial));
    }

    public void printShipInfo() {
        System.out.println(name + " | Speed: " + speedKnots + " knots | Containers: " + containers.size());
        containers.forEach(System.out::println);
    }

    public double getTotalWeight() {
        return containers.stream().mapToDouble(Container::getTotalWeight).sum();
    }
}
