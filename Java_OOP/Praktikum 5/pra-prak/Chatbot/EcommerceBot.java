public class EcommerceBot extends CustomerServiceBot{
    // String name;
    private static int sessionCount = 0;
    private String ecom;

    public EcommerceBot(String name, String ecom){
        super(name);
        // this.name = name;
        this.ecom = ecom;
    }

    @Override
    public void respond(){
        System.out.println("Ecommerce bot " + getName() + " dari " + ecom + " siap melayani Anda");
    }

    @Override
    public void displayInfo(){
        System.out.println("Ecommerce Bot " + getName() + " dari " + ecom + " telah melayani " + getSessionCount() + " sesi");
    }

    public void processOrder(String order){
        System.out.println("Memproses pesanan: " + order + " dari " + ecom);
    }

    @Override
    public int getSessionCount(){
        return sessionCount;
    }

    // @Override 
    // public String getName(){
    //     return name;
    // }

    @Override
    public void startSession(){
        System.out.println("Session started for " + getName());
        sessionCount++;
    }

    @Override
    public String getBotType(){
        return "Ecommerce Bot";
    }
}