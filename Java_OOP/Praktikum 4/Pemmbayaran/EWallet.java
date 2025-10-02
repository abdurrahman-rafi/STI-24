public class EWallet extends Pembayaran implements Payable, Refundable{
    public EWallet(int balance){
        super(balance);
    }

    public EWallet(){
        super();
    }

//     1. void pay(int amount)
// - Jika amount valid (lebih besar dari nol dan balance nya cukup), keluarkan output ("[<Tipe Pembayaran>] Paid: {amount}. Remaining balance: {balance}")
// - Jika tidak valid, keluarkan output ("[<Tipe Pembayaran>] Payment failed. Insufficient balance or invalid amount.")


    @Override
    public void pay(int amount){
        if(amount > 0 && getBalance() >= amount){
            setBalance(getBalance() - amount);
            System.out.println(String.format("[EWallet] Paid: %d. Remaining balance: %d", amount, getBalance()));
        }else{
            System.out.println("[EWallet] Payment failed. Insufficient balance or invalid amount.");
        }
    }

    @Override 
    public void refund(int amount){
        if(amount > 0){
            setBalance(getBalance() + amount);
            System.out.println(String.format("[EWallet] Refunded: %d. New balance: %d", amount, getBalance()));
        }else{
            System.out.println("[EWallet] Refund failed. Invalid amount.");
        }
    }
}