public class COD extends Pembayaran implements Payable{
    public COD(int balance){
        super(balance);
    }

    public COD(){
        super();
    }

    @Override
    public void pay(int amount){
        if(amount > 0 && getBalance() >= amount){
            setBalance(getBalance() - amount);
            System.out.println(String.format("[COD] Paid: %d. Remaining balance: %d", amount, getBalance()));
        }else{
            System.out.println("[COD] Payment failed. Insufficient balance or invalid amount.");
        }
    }
}