public class Mage extends Hero {
    // TODO: Buat atribut: mana, spellPower
    private int mana;
    private int spellPower;

    public int getMana(){
        return mana;
    }

    public int getSpellPower(){
        return spellPower;
    }

    public void setMana(int mana){
        this.mana = mana;
    }

    public void setSpellPower(int spellPower){
        this.spellPower = spellPower;
    }

    // TODO: Buat constructor yang menerima name, hp, attackPower, mana, spellPower
    // Gunakan pula constructor parent dengan role "Mage"
    // Jangan lupa set atribut mana dan spellPower
    public Mage(String name, int hp, int attackPower, int mana, int spellPower){
        super(name, hp, attackPower, "Mage" );
        this.mana = mana;
        this.spellPower = spellPower;
        // isStealthed = false;
    }

    // TODO: Override method specialSkill()
    // Mage cast "Fireball" yang butuh 30 mana, damage = attackPower + spellPower
    // Jika mana cukup, tampilkan: "<name> casts Fireball! Deals <damage> magic damage! Mana: <mana>"
    // Contoh: "Kagura casts Fireball! Deals 130 magic damage! Mana: 120"
    // Jika tidak cukup: "<name> tidak memiliki cukup mana untuk Fireball!"
    @Override
    public void specialSkill(){
        int damage = getAttackPower() + getSpellPower();
        if(getMana() >= 30){
            setMana(getMana() - 30);
            System.out.println(getName() + " casts Fireball! Deals " + damage + " magic damage! Mana: " + getMana());
        }else{
            System.out.println(getName() + " tidak memiliki cukup mana untuk Fireball!");
        }
    }

    // TODO: Buat method levelUp() yang override parent
    // Panggil super.levelUp() dulu, lalu tambah mana +40, spellPower +15
    // Tampilkan pesan bonus: "Bonus Mage: +40 mana, +15 spell power!"
    @Override
    public void levelUp(){
        super.levelUp();
        setMana((int)(getMana() + 40));
        setSpellPower(getSpellPower() + 15);
        System.out.println("Bonus Mage: +40 mana, +15 spell power!");
    }


    // TODO: Buat method meditation() untuk restore 60 mana (max 200)
    // Format: "<name> bermeditasi dan memulihkan mana. Mana sekarang: <mana>"
    // Contoh: "Kagura bermeditasi dan memulihkan mana. Mana sekarang: 200"
    public void meditation(){
        setMana((int)(getMana() + 60));
        if(getMana() > 200) {
            setMana(200);
        }

        System.out.println(getName() + " bermeditasi dan memulihkan mana. Mana sekarang: " + getMana());

    }

    // TODO: Buat getter dan setter untuk mana dan spellPower
}