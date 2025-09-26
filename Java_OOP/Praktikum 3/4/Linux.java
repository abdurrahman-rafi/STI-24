public class Linux extends OperatingSystem{
    public enum Distro {
        UBUNTU, FEDORA, ARCH, DEBIAN
    }
    private Distro distroType;
// public OperatingSystem(String name, String version, String kernelType, double baseScore)
    public Linux(String name, String version, String kernelType, double baseScore, Distro distroType){
        super(name, version, kernelType, baseScore);
        if(distroType == null){
            this.distroType = Distro.UBUNTU;
        }else{
            this.distroType = distroType;
        }
    }

    @Override
    public double calculateCompatibility(UsageType usage){
        double multiplier = 1;
        switch(usage){
            case SERVER:
                multiplier = 0.20;break;
            case DEVELOPMENT:
                multiplier = 0.10;break;
            case GAMING:
                multiplier = -0.15;break;
        }

        return clampScore(getBaseScore() + getBaseScore() * multiplier);
    }

    @Override
    protected String getAdditionalInfo(){
        return "Distribution: " + distroType.name();
    }

    public Distro getDistroType(){
        return distroType;
    }
}