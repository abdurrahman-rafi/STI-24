public class EducationalBot implements Chatbot{
    private String name;
    private static int sessionCount = 0;
    public EducationalBot(String name){
        this.name = name;
        // this.ecom = ecom;
    }

    @Override
    public void respond(){
        System.out.println("Educational bot " + getName() + " siap membantu belajar Anda");
    }

    @Override
    public void displayInfo(){
        System.out.println("Educational Bot " + name + " telah melayani " + getSessionCount() + " sesi");
    }

    public void teachTopic(String topic){
        System.out.println("Mengajarkan topik: " + topic);
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
        return "Educational Bot";
    }
}