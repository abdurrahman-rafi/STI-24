public class TransferBank extends Pembayaran{
    @Override
    public double hitungTotal(){
        return getJumlah() + 4000;
    }
}