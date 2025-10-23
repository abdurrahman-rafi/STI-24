import java.util.ArrayList;
import java.util.List;
public final class GedungSangkuriang implements Asrama {
    List<Mahasiswa> penghuni;
    Integer kapasitas;

    /*
     * TODO: Implementasikan constructor kelas GedungSangkuriang
     * penghuni diinisialisasi dengan ArrayList baru
     * kapasitas diinisialisasi sesuai parameter
     */
    public GedungSangkuriang(Integer kapasitas) {
        // TODO: answer here
        // super();
        this.kapasitas = kapasitas;
        penghuni = new ArrayList<>();
    }

    /*
     * TODO: Implementasikan method infoAsrama
     * Tampilkan "Asrama Gedung Sangkuriang dengan kapasitas <kapasitas>"
     */
    @Override
    public void infoAsrama() {
        // TODO: answer here
        System.out.println("Asrama Gedung Sangkuriang dengan kapasitas " + kapasitas);
    }

    /*
     * TODO: Implementasikan method daftarAsrama
     * Jika kapasitas sudah penuh, tampilkan "Asrama Gedung Sangkuriang sudah penuh"
     * Jika mahasiswa sudah terdaftar di asrama lain (assigned), tampilkan "Mahasiswa sudah terdaftar di asrama lain"
     * Jika mahasiswa asing, tampilkan "Mahasiswa asing tidak boleh mendaftar di asrama ini"
     * Jika mahasiswa domestik dan asrama belum penuh, tambahkan mhs ke penghuni,
     * tampilkan "Mahasiswa <username> diterima di asrama Gedung Sangkuriang"
     * Lalu set asrama mahasiswa ke asrama ini
     */ 
    @Override
    public void daftarAsrama(Mahasiswa mhs) {
        // TODO: answer here
        if(mhs instanceof MahasiswaAsing){
            System.out.println("Mahasiswa asing tidak boleh mendaftar di asrama ini");return;
        }
        MahasiswaDomestik mhss = (MahasiswaDomestik) mhs;

        if(penghuni.size() >= kapasitas){
            System.out.println("Asrama Gedung Sangkuriang sudah penuh");return;
        }else if(mhs.isAssigned()){
            System.out.println("Mahasiswa sudah terdaftar di asrama lain");return;
        }else{
            penghuni.add(mhss);
            System.out.println("Mahasiswa "+ mhss.getUsername() + " diterima di asrama Gedung Sangkuriang");
            mhss.setAsrama(this);
        }
    }
}