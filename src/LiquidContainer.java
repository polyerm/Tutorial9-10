class LiquidContainer extends Container implements Notifier {
    private boolean isHazardous;

    public LiquidContainer(double height, double depth, double tareWeight, double maxPayload, boolean isHazardous) {
        super("L", height, depth, tareWeight, maxPayload);
        this.isHazardous = isHazardous;
    }

    @Override
    public void loadCargo(double weight) throws OverfillException {
        double limit = isHazardous ? 0.5 * maxPayload : 0.9 * maxPayload;

        if (weight > limit) {
            notifyHazard("Attempted to load too much hazardous cargo!");
            throw new OverfillException("Overfill: Allowed = " + limit + " kg");
        }

        this.cargoWeight = weight;
    }

    @Override
    public void unloadCargo() {
        this.cargoWeight = 0;
    }

    @Override
    public void notifyHazard(String message) {
        System.out.println("Hazard [" + serialNumber + "]: " + message);
    }
}
