// import java.lang.System;
class Car extends Vehicle {
    protected int fuelLevel;

    public Car(String brand, String model, int speed, int fuelLevel) {
        super(brand, model, speed);
        this.fuelLevel = fuelLevel;
    }

    public void refuel(int liter) {
        System.out.println("Mobil " + brand + " mengisi bensin sebanyak " + liter + " liter");
    }
    
    // TODO : Tambahkan method yang hilang di kelas ini
    @Override
    public void move(){
        System.out.println(String.format("%s %s (mobil bensin) melaju dengan kecepatan %d km/h", brand, model, speed));
    }

    @Override
    public void refuel(){
        System.out.println(String.format("Mobil %s %s mengisi bensin. Level saat ini: %d%%", brand, model, fuelLevel));
    }
    
    @Override
    public String getEnergySource(){
        return "Bensin";
    }
}