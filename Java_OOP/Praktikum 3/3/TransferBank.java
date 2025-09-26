public class TransferBank extends Pembayaran{

    public TransferBank(String nama, double jumlah){
        super(nama,jumlah);
    }

    @Override
    public double hitungTotal(){
        return getJumlah() + 4000;
    }
}