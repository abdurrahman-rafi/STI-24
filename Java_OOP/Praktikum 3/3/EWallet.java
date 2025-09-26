public class EWallet extends Pembayaran{
    @Override
    public double hitungTotal(){
        return getJumlah() + (getJumlah() * 0.01);
    }
}