import java.util.*;

public class SuperCollection {
    private List<Integer> collection;

    // TODO: Buat constructor yang menerima List<Integer> sebagai parameter
    // Inisialisasi atribut collection dengan parameter yang diterima
    public SuperCollection(List<Integer> collection){
        this.collection = collection;
    }

    // TODO: Buat method partitionByCondition(int threshold)
    // Pisahkan collection menjadi dua grup: element <= threshold dan element > threshold
    // Return List<List<Integer>> dimana:
    // - Index 0 berisi element <= threshold
    // - Index 1 berisi element > threshold
    //
    // HINT:
    // - Perlu membuat struktur data untuk menampung dua kelompok element
    // - Gunakan loop untuk mengiterasi collection dan kondisi untuk memisahkan
    public List<List<Integer>> partitionByCondition(int threshold){
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> below = new ArrayList<>();
        List<Integer> above = new ArrayList<>();

        for(Integer i : collection){
            if(i <= threshold){
                below.add(i);
            }else{
                above.add(i);
            }
        }

        list.add(below);
        list.add(above);

        return list;
    }

    // TODO: Buat method findTopN(int n)
    // Return List<Integer> berisi n element terbesar dalam urutan descending
    // Jika n lebih besar dari ukuran collection, return semua element yang ada
    // Pastikan hasilnya terurut dari terbesar ke terkecil
    //
    // HINT:
    // - Collection asli tidak boleh dimodifikasi
    // - Pertimbangkan cara mengurutkan List dalam urutan terbalik
    // - Collections class memiliki method utility yang berguna
    public List<Integer> findTopN(int n){
        List<Integer> top = new ArrayList<>(collection);
        top.sort(Collections.reverseOrder());
        return new ArrayList<>(top.subList(0, Math.min(collection.size(), n)));
    }
    // TODO: Buat method runningSum()
    // Return List<Integer> berisi cumulative sum
    // Element ke-i berisi jumlah dari element index 0 sampai i
    // Contoh: [1, 2, 3, 4] -> [1, 3, 6, 10]
    //
    // HINT:
    // - Perlu menyimpan state (akumulasi) saat iterasi
    // - Setiap element dalam result adalah hasil penjumlahan sampai index tersebut
    public List<Integer> runningSum(){
        List<Integer> runSum = new ArrayList<>();
        int sum = 0;

        for(int i = 0 ; i<collection.size(); i++){
            sum += collection.get(i);
            runSum.add(sum);
        }

        return runSum;
    }

    // TODO: Buat method findPairsWithSum(int targetSum)
    // Cari semua pasangan element yang jika dijumlahkan = targetSum
    // Return List<String> dengan format "a+b=sum"
    // Hindari duplikat pasangan (a,b) dan (b,a) dianggap sama
    // Urutkan hasil berdasarkan nilai a
    //
    // HINT:
    // - Perlu mengecek setiap kemungkinan pasangan element
    // - Bagaimana cara menghindari duplikat seperti "3+5" dan "5+3"?
    // - Pertimbangkan struktur data yang otomatis mengurutkan dan menghindari duplikat
    // - TreeSet adalah Set yang sorted
    // - Gunakan .addAll untuk menambahkan seluruh elemen dari set ke List hasil kalian
    public List<String> findPairsWithSum(int targetSum){
        Set<String> pairsSet = new TreeSet<>();
        for(int i = 0; i < collection.size() - 1; i++){
            for(int j = i+1; j<collection.size(); j++){
                int num1 = collection.get(i);
                int num2 = collection.get(j);

                if(num1 + num2 == targetSum){
                    int smaller = Math.min(num1, num2);
                    int larger = Math.max(num1,num2);

                    pairsSet.add(smaller + "+" + larger + "=" + (smaller + larger));
                }
            }
        }

        // pairSum.addAll(pairsSort);
        return new ArrayList<>(pairsSet);
    }

    // TODO: Buat method getMostFrequentElements(int n)
    // Return List<Integer> berisi n element yang paling sering muncul
    // Jika ada element dengan frekuensi sama, pilih yang nilainya lebih besar
    //
    // HINT:
    // - Langkah 1: Identifikasi semua element unik
    // - Langkah 2: Hitung berapa kali setiap element muncul
    // - Langkah 3: Urutkan berdasarkan frekuensi (tinggi ke rendah), lalu nilai (tinggi ke rendah)
    // - Pertimbangkan membuat helper class untuk menyimpan pasangan (value, frequency)
    // - Untuk sorting custom, gunakan Comparator
    public List<Integer> getMostFrequentElements(int n){
        Map<Integer, Long> freqs = new HashMap<>();

        for(Integer i: collection){
            freqs.put(i, freqs.getOrDefault(i, 0L) + 1);
        }

        List<Map.Entry<Integer,Long>> entries = new ArrayList<>(freqs.entrySet());

        entries.sort((a,b) -> {
            int freqCompare = Long.compare(b.getValue(), a.getValue());
            if(freqCompare != 0){
                return freqCompare;
            }

            return Integer.compare(b.getKey(), a.getKey());
        });

        List<Integer> result = new ArrayList<>();
        int limit = Math.min(n, entries.size());

        for(int i = 0; i < limit; i++){
            result.add(entries.get(i).getKey());
        }

        return result;

    }

    // TODO: Buat method getCollection()
    // Return collection yang sedang digunakan (type: List<Integer>)
    public List<Integer> getCollection(){
        return collection;
    }

    // TODO: Buat method setCollection(List<Integer> newCollection)
    // Set atribut collection dengan newCollection
    public void setCollection(List<Integer> newCollection){
        this.collection = newCollection;
    }

    public Long max(List<Long> list){
        Long max = list.get(0);
        for(Long i : list){
            if(i > max){
                max = i;
            }
        }

        return max;
    }
}
