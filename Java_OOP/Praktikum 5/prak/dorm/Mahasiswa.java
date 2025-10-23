public abstract class Mahasiswa implements User {    
    static Integer mahasiswaCounter = 0;
    private String userId; // format "1"+5 digit angka (100001, 100002, dst)
    private String username;
    private String password;
    private boolean assigned; // true jika sudah diverifikasi pendaftaran asramanya oleh pengelola
    private Asrama asrama;

    /*
     * TODO: Implementasikan constructor kelas Mahasiswa
     * userId di-generate otomatis dengan format "1"+5 digit angka (100001, 100002, dst)
     * username dan password diinisialisasi dengan null
     * assigned diinisialisasi dengan false
     * mahasiswaCounter diincrement setiap ada objek Mahasiswa baru
    */
    Mahasiswa(){
        mahasiswaCounter++;
        userId = String.format("1%05d", mahasiswaCounter);
        username = null;
        password = null;
        assigned = false;
        // mahasiswaCounter++;
        // TODO: answer here
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
     * Jika sudah terdaftar, tampilkan "User dengan username <username> sudah terdaftar"
     * Jika belum terdaftar, lakukan pendaftaran dengan mengisi username dan password
     * Setelah berhasil mendaftar, tampilkan "User berhasil terdaftar"
     */
    @Override
    public void register(String username, String password) {
        if(isRegistered()){
            System.out.println("User dengan username "+ getUsername() + " sudah terdaftar");
        }else{
            this.username = username;
            this.password = password;
            System.out.println("User berhasil terdaftar");
        }
        // TODO: answer here
    }

    /*
     * TODO: Implementasikan method login
     * Jika belum terdaftar, tampilkan "User belum terdaftar"
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
     * TODO: Implementasikan method login
     * Jika belum terdaftar, tampilkan "User belum terdaftar"
     * Jika ssoSlug sesuai dengan expectedSlug (this.userId + "-" + this.username), 
     * tampilkan "Login berhasil" dan perkenalkan diri
     * Jika tidak sesuai, tampilkan "Login gagal"
     * perkenalkan diri dilakukan dengan memanggil method perkenalkan()
    */
    public void login(String ssoSlug) {
        // TODO: answer here
        if(isRegistered()){
            if(ssoSlug.equals(this.userId + "-" + this.username)){
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
     * TODO: Implementasikan method getter untuk atribut asrama
     * getAsramaInfo
     * Jika asrama tidak null, panggil method infoAsrama pada objek asrama dan kembalikan true
     * Jika asrama null, tampilkan "Mahasiswa belum mendaftar asrama" dan kembalikan false
     */
    public boolean getAsramaInfo() {
        // TODO: answer here
        if(asrama != null){
            this.asrama.infoAsrama();
            return true;
        }else{
            System.out.println("Mahasiswa belum mendaftar asrama");
            return false;
        }
    }

    /* 
     * daftarAsrama method yang akan diimplementasikan di subclass
     */
    abstract public void daftarAsrama(Asrama asrama);

    /*
     * TODO: Implementasikan method setter dan getter untuk atribut asrama, assigned, username, userId
     */
    public String getUserId(){
        return userId;
    }

    public Asrama getAsrama(){
        return asrama;
    }

    public String getUsername(){
        return username;
    }
    
    public boolean isAssigned(){
        return assigned;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public void setAsrama(Asrama asrama){
        this.asrama = asrama;
    }

    public void setUsername(String username){
        this.username = username;
    }
    
    public void setAssigned(boolean assigned){
        this.assigned = assigned;
    }

    // abstract public Gender getGender();
}

