
// TODO: 
// Lengkapi definisi kelas ChampionDuel 
// dengan menambahkan sebuah parameter 
// generik yang harus menerapkan interface Comparable.
final class ChampionDuel<Player extends Comparable<Player>> implements Comparable<ChampionDuel<Player>> {
    // TODO:
    // 1. Buat atribut final dengan tipe generik dari elemen pertama dan elemen
    // kedua
    private final Player first;
    private final Player second;
    // 2. Buat atribut final label dengan tipe String untuk menyimpan label dari
    // duel saat ini
    private final String label;


    ChampionDuel(String label, Player first, Player second) {
        // TODO: Lengkapi definisi konstruktor.
        this.label = label;
        this.first = first;
        this.second = second;
    }

    Player decideChampion() {
        // TODO:
        // 1. Lengkapi definisi fungsi dengan menambahkan return type yang sesuai dengan tipe generik dari elemen pertama dan kedua
        // 2. Kembalikan hasil dari fungsi findChampion dari Champion Finder
        return ChampionFinder.findChampion(first, second);
    }

    String report() {
        // TODO:
        // Kembalikan string <tanpa newline dimanapun>:
        // "<label> champion between <player pertama> and <player kedua> is: <hasil
        // decide champion>"
        return String.format("%s champion between %s and %s is: %s", label, first, second, decideChampion());
    }

    @Override
    public int compareTo(ChampionDuel<Player> other) {
        // Compare based on their champions
        return this.decideChampion().compareTo(other.decideChampion());
    }
}
