public class MathTutorBot extends EducationalBot{
    // private String name;
    private String topic;
    private static int sessionCount = 0;
    public MathTutorBot(String name, String topic){
        super(name);
        // this.name = name;
        // this.ecom = ecom;
        this.topic = topic;
    }

    @Override
    public void respond(){
        System.out.println("Math tutor bot " + getName() + " untuk subject " + topic + " siap membantu");
    }

    @Override
    public void displayInfo(){
        System.out.println("Math Tutor Bot " + getName() + " untuk subject " + topic + " telah melayani " + getSessionCount() + " sesi");
    }

    public void solveProblem(String problem){
        System.out.println("Menyelesaikan soal " + topic + ": " + problem);
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
        return "Math Tutor Bot";
    }
}