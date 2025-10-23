class HybridCar extends Car {
    private int batteryLevelHybrid;

    public HybridCar(String brand, String model, int speed, int fuelLevel, int batteryLevelHybrid) {
        super(brand, model, speed, fuelLevel);
        this.batteryLevelHybrid = batteryLevelHybrid;
    }

    public void switchMode() {
        System.out.println("Mobil " + brand + " " + model + " beralih ke mode hemat energi");
    }

    public void switchMode(String inp) {
        System.out.println("Mobil " + brand + " " + model + " beralih ke mode " + inp);
    }

    // TODO : Tambahkan method yang hilang di kelas ini
    @Override
    public void move(){
        System.out.println(String.format("%s %s (mobil hybrid) menggunakan kombinasi bensin dan baterai (%d%% / %d%%)", brand, model, fuelLevel, batteryLevelHybrid));
    }
    
    @Override
    public void refuel(){
        System.out.println(String.format("Mobil %s %s mengisi bensin. Level saat ini: %d%%", brand, model, fuelLevel));
    }

    @Override
    public String getEnergySource(){
        return "Hybrid (Bensin + Listrik)";
    }
}