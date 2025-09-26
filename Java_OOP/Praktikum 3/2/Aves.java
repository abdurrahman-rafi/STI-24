public class Aves extends Animal {
    private boolean canFly;

    /**
     * Konstruktor untuk kelas Aves.
     * 
     * @param name
     * @param species
     * @param habitat
     * @param sound
     * @param canFly
     */
    public Aves(String name, String species, String habitat, String sound, boolean canFly) {
        super(name, species, habitat, sound, AnimalType.AVES);
        this.canFly = canFly;
        // TODO: lengkapi method ini
    }

    /**
     * Getter untuk kemampuan terbang.
     * 
     * @return true jika dapat terbang, false jika tidak
     */
    public boolean canFly() {
        return canFly;
        // TODO: lengkapi method ini
    }

    /**
     * Mengembalikan sound hewan.
     * 
     * Hint: Panggil method sound() dari superclass (Animal)
     */
    @Override
    public String sound() {
        return super.sound();
        // TODO: lengkapi method ini
    }
}
