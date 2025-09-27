public abstract class OperatingSystem{
    private String name;
    private String version;
    private String kernelType;
    private double baseScore;

    public OperatingSystem(String name, String version, String kernelType, Double baseScore) {
        this.name       = (name == null || name.trim().isEmpty()) ? "Unknown OS" : name.trim();
        this.version    = (version == null || version.trim().isEmpty()) ? "Unknown Version"  : version.trim();
        this.kernelType = (kernelType == null || kernelType.trim().isEmpty()) ? "Unknown Kernel" : kernelType.trim();
        this.baseScore  = (baseScore == null)? 0.0: baseScore; 
    }

    public  abstract double calculateCompatibility(UsageType usage);

    protected abstract String getAdditionalInfo();

    protected double clampScore(double score){
        if(score < 0){
            return 0.0;
        }else if(score > 100){
            return 100.0;
        }else{
            return score;
        }
    }

    public void printInfo(UsageType usage){
        System.out.printf("Name: %s\nVersion: %s\nKernel Type: %s\n", this.getName(), this.getVersion(), this.getKernelType());
        String additional = getAdditionalInfo();
        if (!additional.isEmpty()) System.out.println(additional);
        System.out.printf("Base Score: %.2f\nCompatibility for %s: %.2f\n", baseScore, usage,calculateCompatibility(usage));
    }

    public String getName(){
        return name;
    }

    public String getVersion(){
        return version;
    }

    public String getKernelType(){
        return kernelType;
    }

    public double getBaseScore(){
        return baseScore;
    }

    

    
}