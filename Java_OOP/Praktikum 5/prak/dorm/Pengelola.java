public final class Pengelola implements User {
    static Integer pengelolaCounter = 0;
    String NIP;  // format "2"+5 digit angka (200001, 200002, dst)
    String username;
    String password;

    /*
     * TODO: Implementasikan constructor kelas Pengelola
     * username, dan password diinisialisasi null
     * NIP di-generate otomatis dengan format "2"+5 digit angka (200001, 200002, dst)
     * pengelolaCounter diincrement setiap ada objek Pengelola baru
     */
    public Pengelola() {
        // TODO: answer here
        pengelolaCounter++;
        NIP = String.format("2%05d", pengelolaCounter);
        
        username = null;
        password = null;
        // mahasiswaCounter++;
        // pengelolaCounter++;
    }

    /*
     * TODO: Implementasikan method isRegistered
     * mengembalikan true jika username dan password tidak null
     * mengembalikan false jika username atau password null
     */
    @Override
    public boolean isRegistered() {
        return (username != null && password != null);
        // TODO: answer here
    }

    /*
     * TODO: Implementasikan method register
     * Jika sudah terdaftar, tampilkan "Pengelola dengan username <username> sudah terdaftar"
     * Jika belum terdaftar, lakukan pendaftaran dengan mengisi username, password, dan NIP
     * Setelah berhasil mendaftar, tampilkan "Pengelola berhasil terdaftar"
     */
    @Override
    public void register(String username, String password) {
        // TODO: answer here
        if(isRegistered()){
            System.out.println("Pengelola dengan username "+ getUsername() + " sudah terdaftar");
        }else{
            this.username = username;
            this.password = password;
            System.out.println("Pengelola berhasil terdaftar");
        }
    }

    /*
     * TODO: Implementasikan method login
     * Jika username dan password sesuai, tampilkan "Login berhasil" dan perkenalkan diri
     * Jika tidak sesuai, tampilkan "Login gagal"
     * perkenalkan diri dilakukan dengan memanggil method perkenalkan()
    */
    @Override
    public void login(String username, String password) {
        // TODO: answer here

        if(isRegistered()){
            if(this.password.equals(password) && this.username.equals(username)){
                System.out.println("Login berhasil");
                perkenalkan();
            }else{
                System.out.println("Login gagal");
            }
        }else{
            System.out.println("User belum terdaftar");
        }
    }

    /*
     * TODO: Implementasikan method perkenalkan
     * Tampilkan "Halo, saya pengelola dengan NIP <NIP> dan username <username>"
     */
    @Override
    public void perkenalkan(){
        // TODO: answer here
        System.out.println("Halo, saya pengelola dengan NIP " + getNIP() +  " dan username " + getUsername());
    }
    /*
     * TODO: Implementasikan method terimaPendaftaran
     * Jika mahasiswa sudah memilih asrama, set assigned mahasiswa menjadi true
     * Tampilkan "Pendaftaran mahasiswa <username> telah diverifikasi oleh pengelola <username>"
     * Jika mahasiswa belum memilih asrama, tampilkan "Pengelola gagal melakukan verifikasi pendaftaran mahasiswa <username>"
     */
    public void terimaPendaftaran(Mahasiswa mhs, Asrama asrama) {
        // TODO: answer here
        if(mhs.getAsrama() == null){
            System.out.println("Pengelola gagal melakukan verifikasi pendaftaran mahasiswa " + mhs.getUsername());
        }else{
            mhs.setAssigned(true);
            System.out.println("Pendaftaran mahasiswa " + mhs.getUsername() + " telah diverifikasi oleh pengelola " + getUsername());
        }
        
    }

    public String getNIP(){
        return NIP;
    }

    public String getUsername(){
        return username;
    }

    public void setNIP(String NIP){
        this.NIP = NIP;
    }

    public void setUsername(String username){
        this.username = username;
    }
    
}
