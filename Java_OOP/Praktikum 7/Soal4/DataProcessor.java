import java.util.List;

public class DataProcessor<T extends Comparable<T>> {
    // TODO: Implementasikan class ini
    // TODO: Buat generic class DataProcessor<T extends Comparable<T>>
// Pertanyaan: Mengapa kita menggunakan bounded type parameter "T extends Comparable<T>"?
// Hint: Method apa yang diperlukan untuk melakukan sorting atau mencari min/max?
//       Apakah semua tipe data memiliki method tersebut secara default?
//
// Atribut yang diperlukan:
// - String processorName
    private String processorName;
//
// Method yang diperlukan:
// - Constructor(String processorName): inisialisasi processor
    public DataProcessor(String processorName){
        this.processorName = processorName;
    }
// - findMin(Container<T> container): mencari nilai minimum
//   * Tampilkan: "Mencari nilai minimum di [container.getName()]..."
//   * Return nilai minimum, atau null jika container kosong
//   * Hint: Bagaimana cara membandingkan dua objek untuk menentukan mana yang lebih kecil?
    public T findMin(Container<T> container){
        System.out.println("Mencari nilai minimum di " + container.getName() + "...");
        List<T> list = container.getItems();
        if (list.isEmpty()){
            return null;
        }

        T min = list.get(0);
        for(T i : list){
            if(i.compareTo(min) < 0){
                min = i;
            }
        }

        return min;
    }
// - findMax(Container<T> container): mencari nilai maximum
//   * Tampilkan: "Mencari nilai maksimum di [container.getName()]..."
//   * Return nilai maximum, atau null jika container kosong
    public T findMax(Container<T> container){
        System.out.println("Mencari nilai maksimum di " + container.getName() + "...");
        List<T> list  = container.getItems();
        if(list.isEmpty()){
            return null;
        }

        T max = list.get(0);
        for(T i : list){
            if(i.compareTo(max) > 0){
                max = i;
            }
        }

        return max;
    }
    
// - sort(Container<T> container): mengurutkan item dalam container (ascending)
//   * Tampilkan: "Mengurutkan data di [container.getName()]..."
//   * Hint: Pikirkan algoritma sorting sederhana yang pernah Anda pelajari.
//   * Method ini memodifikasi container secara langsung

    public void sort(Container<T> container){
        System.out.println("Mengurutkan data di " + container.getName() + "...");
        List<T> list = container.getItems();

        boolean swapped;
        for(int i = 0; i < container.size()-1; i++){
            swapped = false;
            for(int j = 0; j < container.size() - 1 - i; j++){
                if(list.get(j).compareTo(list.get(j+1)) > 0){
                    T temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }
// - getProcessorName(): return nama processor

    public String getProcessorName(){
        return processorName;
    }
}
