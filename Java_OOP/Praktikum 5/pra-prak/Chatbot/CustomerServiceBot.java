public class CustomerServiceBot implements  Chatbot{
    private String name;
    private static int sessionCount = 0;
    public CustomerServiceBot(String name){
        this.name = name;
        // this.ecom = ecom;
    }

    @Override
    public void respond(){
        System.out.println("Customer service bot "+ name + " siap melayani Anda");
    }

    @Override
    public void displayInfo(){
        System.out.println("Customer Service Bot " + name + " telah melayani " + getSessionCount() + " sesi");
    }

    public void handleComplaint(String cmp){
        System.out.println("Menangani keluhan: " + cmp);
    }

    @Override
    public int getSessionCount(){
        return sessionCount;
    }

    @Override 
    public String getName(){
        return name;
    }

    @Override
    public void startSession(){
        System.out.println("Session started for " + getName());
        sessionCount++;
    }

    @Override
    public String getBotType(){
        return "Customer Service Bot";
    }
}