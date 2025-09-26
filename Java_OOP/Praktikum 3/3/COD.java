public class COD extends Pembayaran{

    public COD(String nama, double jumlah){
        super(nama,jumlah);
    }
    @Override
    public double hitungTotal(){
        return getJumlah() + 5000;
    }
}