public abstract class Vehicle {
    protected String brand;
    protected String model;
    protected int speed;

    public Vehicle(String brand, String model, int speed) {
        this.brand = brand;
        this.model = model;
        this.speed = speed;
    }

    public abstract void move();

    public void displayInfo() {
        System.out.println("Kendaraan: " + brand + " " + model);
    }

    // TODO : Tambahkan method overloading displayInfo dengan parameter String detailLevel dan Vehicle other
    public void displayInfo(String detailLevel){
        System.out.println("Kendaraan: " + brand + " " + model + " | Detail: " + detailLevel);
    }

    public void displayInfo(Vehicle other){
        System.out.println(String.format("%s %s sedang balapan dengan %s %s", brand, model, other.brand, other.model));
        // race(other);
    }

    public void refuel() {
        System.out.println("Kendaraan " + brand + " " + model + " sedang mengisi bahan bakar");
    }

    // TODO : Tambahkan method overloading refuel dengan parameter String fuelType
    public void refuel(String fuelType){
        System.out.println(String.format("Kendaraan %s %s mengisi bahan bakar jenis: %s", brand, model, fuelType));
    }

    public String getEnergySource() {
        return "Tidak diketahui";
    }

    // TODO : Tambahkan method race dengan parameter Vehicle opponent
    public void race(Vehicle opponent){
        System.out.println(String.format("%s (%s) balapan melawan %s (%s)", brand, getEnergySource(), opponent.brand, opponent.getEnergySource()));
    }

}