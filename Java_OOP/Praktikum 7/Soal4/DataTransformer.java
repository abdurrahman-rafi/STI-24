// TODO: Buat generic class DataTransformer<T, R>
// Pertanyaan: Mengapa kita menggunakan dua type parameter T dan R?
// Hint: Pikirkan tentang transformasi data. Apakah tipe input selalu sama dengan tipe output?
//       Misalnya, mengubah String menjadi Integer, atau Integer menjadi Double.
//
// Atribut yang diperlukan:
// - String transformerName
//
// Method yang diperlukan:
// - Constructor(String transformerName): inisialisasi transformer
// - transform(Container<T> source, Container<R> destination, TransformFunction<T, R> function)
//   * Pertanyaan: Apa itu TransformFunction? (lihat interface TransformFunction.java)
//   * Tampilkan: "Transforming data dari [source.getName()] ke [destination.getName()]..."
//   * Loop setiap item di source, apply function, masukkan hasil ke destination
//   * Hint: TransformFunction memiliki method untuk mengubah tipe T menjadi tipe R.
// - getTransformerName(): return nama transformer
import java.util.List;

public class DataTransformer<T,R> {
    // TODO: Implementasikan class ini
    private String transformerName;
    public DataTransformer(String transformerName){
        this.transformerName = transformerName;
    }

    public void transform(Container<T> source, Container<R> destination, TransformFunction<T, R> function){
        System.out.println("Transforming data dari " + source.getName() + " ke " + destination.getName() +"...");
        List<T> list = source.getItems();
        for(T i : list){
            destination.add(function.apply(i));
        }
    }

    public String getTransformerName(){
        return transformerName;
    }

}
