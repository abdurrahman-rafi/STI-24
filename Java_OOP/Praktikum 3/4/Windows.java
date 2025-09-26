public class Windows extends OperatingSystem{
    public enum Edition{
        HOME, PRO, SERVER
    }

    private Edition edition;
// public OperatingSystem(String name, String version, String kernelType, double baseScore)
    public Windows(String name, String version, String kernelType, double baseScore, Edition edition){
        super(name, version, kernelType, baseScore);
        this.edition = (edition == null) ? Edition.HOME : edition;
    }

    @Override
    public double calculateCompatibility(UsageType usage){
        double multiplier = 0.0;
        if (edition == Edition.SERVER && usage == UsageType.SERVER) {
            multiplier = 0.30;
        } else if (usage == UsageType.GAMING) {
            multiplier = 0.20;
        } else if (edition == Edition.HOME && usage == UsageType.SERVER) {
            multiplier = -0.05;
        }

        double result = getBaseScore() + multiplier * getBaseScore();
        return clampScore(result);
    }

    @Override
    protected String getAdditionalInfo(){
        return "Edition: " + edition.name();
    }

    public Edition getEdition(){
        return edition;
    }
}