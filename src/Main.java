public class Main {
    public static void main(String[] args) {
        try {
            ContainerShip ship = new ContainerShip("Voyager", 20, 5, 50);

            LiquidContainer fuelTank = new LiquidContainer(200, 100, 1000, 10000, true);
            fuelTank.loadCargo(4000);

            GasContainer heliumTank = new GasContainer(150, 80, 800, 8000, 15);
            heliumTank.loadCargo(7000);

            RefrigeratedContainer bananaBox = new RefrigeratedContainer(160, 90, 900, 9000, "bananas", 2, 5);
            bananaBox.loadCargo(5000);

            ship.loadContainer(fuelTank);
            ship.loadContainer(heliumTank);
            ship.loadContainer(bananaBox);

            ship.printShipInfo();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
