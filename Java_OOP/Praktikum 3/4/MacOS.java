public class MacOS extends OperatingSystem {
    private boolean hasMSeriesChip;
// public OperatingSystem(String name, String version, String kernelType, double baseScore)
    public MacOS(String name, String version, String kernelType, double baseScore, boolean hasMSeriesChip){
        super(name, version, kernelType, baseScore);
        this.hasMSeriesChip = hasMSeriesChip;
    }

    @Override
    public double calculateCompatibility(UsageType usage){
        double multiplier = 0.0;
        switch(usage){
            case DEVELOPMENT:
                multiplier = 0.25;
                break;
            case GAMING:
                multiplier = -0.20;
                break;
            case SERVER:
                break;
        }

        if(hasMSeriesChip){
            multiplier += 0.10;
        }

        return clampScore(getBaseScore() + getBaseScore() * multiplier);
    }

    @Override
    protected  String getAdditionalInfo(){
        return "Has M-Series Chip: " + (hasMSeriesChip ? "Yes" : "No");
    }

    public boolean hasMSeriesChip(){
        return hasMSeriesChip;
    }
}