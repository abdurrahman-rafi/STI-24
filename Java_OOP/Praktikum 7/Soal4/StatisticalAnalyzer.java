//
// Atribut yang diperlukan:
// - String analyzerName
//
// Method yang diperlukan:
// - Constructor(String name): inisialisasi analyzer
// - getAnalyzerName(): return nama analyzer
// - calculateAverage(Container<? extends Number> container): hitung rata-rata
//   * Pertanyaan: Mengapa kita menggunakan wildcard "? extends Number"?
//   * Hint: Apa hubungan antara Integer, Double, Float dengan Number?
//         Jika method menerima Container<Number>, bisakah kita pass Container<Integer>?
//   * Tampilkan: "Menghitung rata-rata dari [container.getName()]..."
//   * Return rata-rata sebagai double, atau 0.0 jika kosong
//   * Hint: Bagaimana cara mengkonversi berbagai tipe Number menjadi double?
// - calculateSum(Container<? extends Number> container): hitung total
//   * Tampilkan: "Menghitung total dari [container.getName()]... (tanpa [])"
//   * Return sum sebagai double
// - findAboveThreshold(Container<? extends Number> container, double threshold)
//   * Tampilkan: "Mencari nilai di atas threshold [threshold] di [container.getName()]..."
//   * Return List<Number> berisi semua nilai yang lebih besar dari threshold
//   * Hint: Pikirkan cara membandingkan Number dengan double.
import java.util.ArrayList;
import java.util.List;
public class StatisticalAnalyzer {
    // TODO: Implementasikan class ini
    private String analyzerName;

    public StatisticalAnalyzer(String name){
        analyzerName = name;
    }

    public String getAnalyzerName(){
        return analyzerName;
    }

    public double calculateSum(Container<? extends Number> container){
        System.out.println("Menghitung total dari " + container.getName() + "...");
        List<? extends Number> list = container.getItems();
        if(list.isEmpty()){
            return 0.0;
        }

        double total = 0;
        for(Number n : list){
            total += n.doubleValue();
        }
        return total;
    }

    public double calculateAverage(Container<? extends Number> container){
        System.out.println("Menghitung rata-rata dari "+ container.getName() + "...");
        List<? extends Number> list = container.getItems();
        if(list.isEmpty()){
            return 0.0;
        }

        double avg = 0.0;
        double total = 0.0;
        for(Number n : list){
            total += n.doubleValue();
        }

        avg = total/container.size();
        return (double) total/container.size();
    }

    public List<Number> findAboveThreshold(Container<? extends Number> container, double threshold){
        System.out.println("Mencari nilai di atas threshold " + threshold + " di " + container.getName() + "...");
        List<Number> output = new ArrayList<>();
        List<? extends Number> list = container.getItems();

        for(Number n : list){
            if(n.doubleValue() > threshold){
                output.add(n);
            }
        } 

        return output;
    }
}
