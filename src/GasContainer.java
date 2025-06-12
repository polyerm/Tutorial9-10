class GasContainer extends Container implements Notifier {
    private double pressure;

    public GasContainer(double height, double depth, double tareWeight, double maxPayload, double pressure) {
        super("G", height, depth, tareWeight, maxPayload);
        this.pressure = pressure;
    }

    @Override
    public void loadCargo(double weight) throws OverfillException {
        if (weight > 0.9 * maxPayload) {
            notifyHazard("Too much gas weight loaded!");
            throw new OverfillException("Overfill: Allowed = " + 0.9 * maxPayload);
        }
        this.cargoWeight = weight;
    }

    @Override
    public void unloadCargo() {
        this.cargoWeight *= 0.05;
    }

    @Override
    public void notifyHazard(String message) {
        System.out.println("Hazard [" + serialNumber + "]: " + message);
    }
}
