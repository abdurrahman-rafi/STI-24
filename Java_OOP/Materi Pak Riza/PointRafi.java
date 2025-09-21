public class PointRafi {
    public int x = 0;
    public int y = 0;
    // konstruktor untuk point otomatis jalan ketika memangiil class
    public PointRafi(int a, int b){
        x = a; y= b;
    }

    //Metode
    public void printPoint(PointRafi P){
        System.out.println("Koordinat x: " + x + "\nKoordinat y: "+ y + "\n");
    }
}