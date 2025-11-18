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
        List<Integer> subbed =top.subList(0, Math.min(collection.size(), n));
        return subbed;
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

        for(int i = 0 ; i<collection.size(); i++){
            int sum = 0;
            for(int j = 0; j<=i; j++){
                sum += collection.get(j);
            }
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
        Set<Set<Integer>> pairs = new HashSet<>();
        Set<String> pairsSort = new TreeSet<>();
        List<String> pairSum = new ArrayList<>();

        for(int i = 0; i < collection.size() - 1; i++){
            
            for(int j = i+1; j<collection.size(); j++){
                Set<Integer> check = new HashSet<>();
                int num1 = collection.get(i);
                int num2 = collection.get(j);

                check.add(num1);
                check.add(num2);
                if(!pairs.contains(check) && num1 + num2 == targetSum){
                    pairs.add(check);
                    int sum = num1 + num2;
                    pairsSort.add(num1 + "+" + num2 + "=" + sum);
                }
            }
        }

        pairSum.addAll(pairsSort);
        return pairSum;
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
        List<Integer> unique = new ArrayList<>();
        Map<Integer, Long> freqs = new TreeMap<>();
        // System.out.println(unique.size());
        // System.out.println(freqs.size());
        
        
        for(Integer i: collection){
            if(!unique.contains(i)){
                unique.add(i);
            }
            
            if(freqs.containsKey(i)){
                long freq = freqs.get(i);
                freq++;
                freqs.replace(i, freq);
            }else{
                freqs.put(i,1L);
            }
        }

        List<Long> topN = new ArrayList<>();
        for(Integer i : unique){
            // System.out.println(i);
            topN.add(freqs.get(i));
        }
        // System.out.println(unique.size());
        // System.out.println(freqs.size());
        List<Integer> sorted = new ArrayList<>();
        int it = 0;
        while(it < n){
            Long highestfreq = max(topN);
            sorted.add(unique.get(topN.indexOf(highestfreq)));
            unique.remove(unique.get(topN.indexOf(highestfreq)));
            topN.remove(highestfreq);
            it++;
        }

        return sorted;

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
