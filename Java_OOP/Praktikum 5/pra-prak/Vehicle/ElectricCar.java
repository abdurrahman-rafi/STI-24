class ElectricCar extends Vehicle {
    private int batteryLevel;

    public ElectricCar(String brand, String model, int speed, int batteryLevel) {
        super(brand, model, speed);
        this.batteryLevel = batteryLevel;
    }

    public void recharge(int durationMinutes) {
        System.out.println("Mobil " + brand + " " + model + " mengisi daya selama " + durationMinutes + " menit");
    }

    public void recharge(String mode) {
        System.out.println("Mobil " + brand + " " + model + " mengisi daya dengan mode: " + mode);
    }

    // TODO : Tambahkan method yang hilang di kelas ini
    @Override
    public void move(){
        System.out.println(String.format("%s %s (mobil listrik) melaju dengan daya baterai %d%%", brand, model, batteryLevel));
    }
    
    @Override
    public void refuel(){
        System.out.println("Mobil listrik " + brand + " " + model + " sedang diisi daya listrik");
    }

    @Override
    public String getEnergySource(){
        return "Listrik";
    }
}