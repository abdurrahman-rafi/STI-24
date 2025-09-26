public class COD extends Pembayaran{
    @Override
    public double hitungTotal(){
        return getJumlah() + 5000;
    }
}