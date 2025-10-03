public class Pembayaran{
    private int balance;

    public Pembayaran(int balance){
        this.balance = balance;
    }

    public Pembayaran(){
        balance = 0;
    }
    public int getBalance(){
        return balance;
    }

    public void setBalance(int bal){
        this.balance = bal;
    }
}