public abstract class Animal implements IAnimal {

    private String name;
    private String species;
    private String habitat;
    protected String sound;

    enum AnimalType {
        MAMMAL,
        AVES,
        REPTILE
    }

    private AnimalType animalType;

    /**
     * Fungsi untuk membersihkan input teks.
     * 
     * Jika teks null atau hanya berisi spasi, kembalikan nilai fallback.
     * 
     * @param text
     * @param fallback
     * @return
     */
    private static String sanitizeText(String text, String fallback) {
        if (text == null) {
            return fallback;
        }
        String trimmed = text.trim();
        return trimmed.isEmpty() ? fallback : trimmed;
    }

    /**
     * Konstruktor untuk kelas Animal.
     * 
     * @param name
     * @param species
     * @param habitat
     * @param animalType
     */
    protected Animal(String name, String species, String habitat, String sound, AnimalType animalType) {
        this.name   = sanitizeText(name, "Unknown");
        this.species = sanitizeText(species, "Unknown");
        this.habitat = sanitizeText(habitat, "Unknown");
        this.sound   = sanitizeText(sound, "Unknown");
        this.animalType = (animalType == null) ? AnimalType.MAMMAL : animalType;
        // TODO: lengkapi constructor ini
    }

    /**
     * Getter untuk nama hewan.
     * 
     * @return nama hewan
     */
    public String getName() {
        // TODO: lengkapi method ini
        return name;

    }

    /**
     * Getter untuk spesies hewan.
     * 
     * @return spesies hewan
     */
    public String getSpecies() {
        // TODO: lengkapi method ini
        return species;
    }

    /**
     * Getter untuk habitat hewan.
     * 
     * @return habitat hewan
     */
    public String getHabitat() {
        return habitat;
        // TODO: lengkapi method ini
    }

    /**
     * Getter untuk jenis hewan.
     * 
     * @return jenis hewan
     */
    public AnimalType getAnimalType() {
        return animalType;
        // TODO: lengkapi method ini
    }

    /**
     * Mengembalikan representasi string dari objek Animal.
     * 
     * @return representasi string dari objek Animal
     */
    @Override
    public String toString() {
        return "Animal Info:\n" +
                "--------------------\n" +
                "Name: " + name + "\n" +
                "Species: " + species + "\n" +
                "Habitat: " + habitat + "\n" +
                "--------------------";
    }

    /**
     * Metode untuk suara hewan.
     * 
     * @return suara hewan
     */
    public String sound() {
        return sound;
        // TODO: lengkapi method ini
    }
}
