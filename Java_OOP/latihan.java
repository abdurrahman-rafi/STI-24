public class GeoLoc{
    private float lat;
    private float lon;
    private int alt;

    public GeoLoc(float lat, float lon, int alt){
        this ...;
    }

    get ..

    set ..
    
}

public interface Moveable{
    public void moveTo(GeoLoc newLoc);
}

public class Vehicle implements Moveable{
    private GeoLoc loc;
    private int speed;
    private static int numVehicle;

    public void getLocation(){
        return loc;
    }

    public Vehicle(Geo, int){

    }

    public abstract void accelerate();
}