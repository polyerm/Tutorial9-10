    public abstract class Container {
    protected static int counter = 1;

    protected String serialNumber;
    protected double height;
    protected double depth;
    protected double tareWeight;
    protected double maxPayload;
    protected double cargoWeight = 0;

    public Container(String type, double height, double depth, double tareWeight, double maxPayload) {
        this.serialNumber = "KON-" + type + "-" + (counter++);
        this.height = height;
        this.depth = depth;
        this.tareWeight = tareWeight;
        this.maxPayload = maxPayload;
    }

    public abstract void loadCargo(double weight) throws OverfillException;
    public abstract void unloadCargo();

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getTotalWeight() {
        return tareWeight + cargoWeight;
    }

    @Override
    public String toString() {
        return serialNumber + ": " + getClass().getSimpleName() + " (Cargo=" + cargoWeight + "kg)";
    }
}
