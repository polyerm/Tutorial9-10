class RefrigeratedContainer extends Container {
    private String productType;
    private double requiredTemp;
    private double currentTemp;

    public RefrigeratedContainer(double height, double depth, double tareWeight, double maxPayload, String productType, double requiredTemp, double currentTemp) {
        super("C", height, depth, tareWeight, maxPayload);
        this.productType = productType;
        this.requiredTemp = requiredTemp;
        this.currentTemp = currentTemp;
    }

    @Override
    public void loadCargo(double weight) throws OverfillException {
        if (!productType.equalsIgnoreCase("bananas")) {
            throw new IllegalArgumentException("Only bananas allowed in this container.");
        }
        if (currentTemp < requiredTemp) {
            throw new IllegalArgumentException("Temperature too low for product.");
        }
        if (weight > maxPayload) {
            throw new OverfillException("Overfill: Exceeds max payload.");
        }
        this.cargoWeight = weight;
    }

    @Override
    public void unloadCargo() {
        this.cargoWeight = 0;
    }
}
