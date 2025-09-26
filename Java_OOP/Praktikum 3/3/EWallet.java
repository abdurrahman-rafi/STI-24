public class EWallet extends Pembayaran{
    

    public EWallet(String nama, double jumlah){
        super(nama,jumlah);
    }

    @Override
    public double hitungTotal(){
        return getJumlah() + (getJumlah() * 0.01);
    }
}