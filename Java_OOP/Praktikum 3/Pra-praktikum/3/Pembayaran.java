public abstract class Pembayaran{
    private String namaPelanggan;
    private double jumlah;

    public abstract double hitungTotal();

    public Pembayaran(String namaPelanggan, double jumlah){
        this.namaPelanggan = namaPelanggan;
        this.jumlah = jumlah;
    }
    public String getNamaPelanggan(){
        return namaPelanggan;
    }

    public double getJumlah(){
        return jumlah;
    }
}