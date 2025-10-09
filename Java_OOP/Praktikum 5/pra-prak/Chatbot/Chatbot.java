public interface Chatbot{

    // public Chatbot(String name){
    //     this.name = name;
    //     session = 1;
    // }

    public void respond();
    public void startSession();
    
    public void displayInfo();
    public int getSessionCount();
    // public void setSessionCount(int session);
    public String getName();
    public String getBotType();


}