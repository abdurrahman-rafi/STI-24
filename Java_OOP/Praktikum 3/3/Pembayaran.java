public abstract class Pembayaran{
    private String namaPelanggan;
    private double jumlah;

    public abstract double hitungTotal();

    public String getNamaPelanggan(){
        return namaPelanggan;
    }

    public double getJumlah(){
        return jumlah;
    }
}