import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {
    private String question;
    private List<Option> options;
    private int index;
    // TODO: Deklarasikan field untuk menyimpan teks pertanyaan
    // TODO: Deklarasikan field untuk daftar Option
    // TODO: Deklarasikan field untuk indeks jawaban yang benar

    public Question(String text) {
        question = text;
        options = new ArrayList<Option>();
        index= -1;
        // TODO: Inisialisasi teks pertanyaan dan struktur data daftar option
        // TODO: Atur nilai awal indeks jawaban benar (misalnya -1)
    }

    public void addOption(String optionText, boolean correct) {
        // TODO: Buat objek Option baru menggunakan inner class
        // TODO: Tambahkan option ke dalam daftar
        // TODO: Jika parameter correct true, perbarui indeks jawaban benar
        Option opt = new Option(optionText);
        options.add(opt);

        if(correct){
            index = options.size() - 1;
        }
        
    }

    public void display() {
        // TODO: Cetak teks pertanyaan yang diakhiri newline
        // TODO: Iterasi seluruh option dan tampilkan dengan format "nomor. teks<newline>"
        System.out.println(question);

        int num = 1;
        for(Option opt : options){
            System.out.println(num +". " + opt.getText());
            num++;
        }
    }

    public boolean isCorrect(int selectedOptionNumber) {
        // TODO: Konversi nomor 1-based menjadi indeks 0-based dan bandingkan dengan
        // jawaban benar yang disimpan di dalam kelas
        return (index == selectedOptionNumber-1);
    }

    public boolean isValidOption(int selectedOptionNumber) {
        // TODO: Periksa apakah nomor opsi berada dalam rentang indeks daftar option
        
        return (selectedOptionNumber < options.size()+1 && selectedOptionNumber > 0);
    }

    public List<Option> getOptions() {
        return Collections.unmodifiableList(options);
    }

    public class Option {
        // TODO: Deklarasikan field untuk menyimpan teks option
        private String optText;

        private Option(String text) {
            // TODO: Simpan teks option pada field yang sesuai
            optText=text;

        }

        public String getText() {
            // TODO: Mengembalikan teks option
            return optText;
        }
    }
}
