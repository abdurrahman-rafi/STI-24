
public abstract class Hero {
    // TODO: Buat atribut berikut String name,int  level,int  hp,int  attackPower, String role
    private String name;
    private int level;
    private int hp;
    private int attackPower;
    private String role;

    // TODO: Buat constructor yang menerima name, hp, attackPower, role
    // Level default = 1
    public Hero(String name, int hp, int attackPower, String role){
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        this.role = role;
        level = 1;
    }

    // TODO: Buat method displayInfo() yang menampilkan info hero
    // Gunakan format "<role> <name> - Level: <level>, HP: <hp>, Attack: <attackPower>"
    // Contoh: "Mage Kagura - Level: 1, HP: 300, Attack: 80"
    public void displayInfo(){
        System.out.println(String.format("%s %s - Level: %d, HP: %d, Attack: %d", getRole(), getName(), getLevel(), getHp(), getAttackPower()));
    }

    // TODO: Buat method attack() dasar
    // Tampilkan pesan "<name> melakukan serangan dasar dengan damage <attackPower>!"
    // Contoh: "Kagura melakukan serangan dasar dengan damage 80!"
    public void attack(){
        System.out.println(name + " melakukan serangan dasar dengan damage " + attackPower + "!");
    }

    // TODO: Buat method levelUp() yang menaikkan level dan stats dasar
    // Naikkan level, Naikkan hp sebanyak 50, naikkan attackPower sebanyak 10, tampilkan pesan level up
    // Format: "<name> naik ke level <level>!"
    // Contoh: "Kagura naik ke level 2!"
    public void levelUp(){
        level++;
        hp += 50;
        attackPower +=10;

        System.out.println(name + " naik ke level " + (int)level + "!");
    }

    // TODO: Implementasikan method abstract berikut di subclass
    public abstract void specialSkill();

    // TODO: Buat getter dan setter untuk semua atribut
    public int getLevel(){
        return level;
    }

    public int getHp(){
        return hp;
    }

    public int getAttackPower(){
        return attackPower;
    }

    public String getName(){
        return name;
    }
        
    public String getRole(){
        return role;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public void setHp(int hp){
        this.hp = hp;
    }

    public void setAttackPower(int attackPower){
        this.attackPower = attackPower;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setRole(String role){
        this.role = role;
    }
}