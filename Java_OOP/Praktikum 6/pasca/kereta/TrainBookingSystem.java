import java.util.List;

public class TrainBookingSystem {
    private List<Train> trains;
    private BookingManager bookingManager;


    /*
     * Konstruktor Kelas TrainBookingSystem
     * TODO: Lengkapi state awal dari attribut TrainBookingSystem
     *      - Inisialisasi trains dari parameter konstruktor
     *      - Inisialisasi bookingManager dengan objek BookingManager baru
     */
    public TrainBookingSystem(List<Train> trains) {
        this.trains = trains;
        bookingManager = new BookingManager();
        // TODO: lengkapi konstruktor
    }

    /*
     * Method showTrains
     * TODO:    Method ini berupa prosedur yang akan menampilkan semua kereta yang ada di dalam list trains.
     *          Awali dengan menampilkan header "=== Daftar Kereta Tersedia ==="
     *          - Jika tidak ada kereta, tampilkan pesan "(Tidak ada kereta tersedia)\n"
     *          - Jika trains tidak kosong, print objek train satu per satu dengan format "<index>. <train.toString()>"
     *          - Index dimulai dari 1
     *          - Akhiri dengan baris kosong
     */
    public void showTrains() {
        System.out.println("=== Daftar Kereta Tersedia ===");
        if(trains.isEmpty()){
            System.out.println("(Tidak ada kereta tersedia)");
        }else{
            int i = 1;
            for(Train t : trains){
                System.out.println(i + ". " + t.toString());
                i++;
            }
        }
        // TODO: Lengkapi method showTrains
    }

    /*
     * Method bookTicket
     * TODO:    Method ini berupa prosedur yang akan melakukan booking tiket 
     *          untuk customerName pada kereta dengan nama trainName.
     *          - Jika kereta dengan nama trainName tidak ditemukan, 
     *              tampilkan pesan "Kereta tidak ditemukan: <trainName>"
     *          - Jika kereta ditemukan tetapi tidak ada kursi tersedia, 
     *              tampilkan pesan "Kursi penuh pada kereta: <trainName>"
     *          - Jika booking berhasil, buat objek Booking baru dengan 
     *              customerName dan objek Train yang bersangkutan.
     *              Tambahkan booking ke dalam BookingManager, kurangi kursi pada kereta, 
     *              dan tampilkan pesan "Booking berhasil: <booking.toString()>"
     */
    public void bookTicket(String customerName, String trainName) {
        Train t = null;
        for(Train s : trains){
            if(s.getName().equals(trainName)){
                t = s;
                break;
            }
        }

        if(t == null){
            System.out.println("Kereta tidak ditemukan: " + trainName);
        }else if(!t.hasAvailableSeats()){
            System.out.println("Kursi penuh pada kereta: " + trainName);
        }else{
            Booking b = new Booking(customerName, t);
            BookingManager.Action act = bookingManager.new Action();
            act.addBooking(b);
            t.reduceSeat();
            System.out.println("Booking berhasil: " + b);
        }
        // TODO: lengkapi method bookTicket
    }

    /*
     * Method cancelBooking
     * TODO: Method ini berupa prosedur yang akan membatalkan booking dengan bookingId tertentu.
     *         Gunakan method cancel dari BookingManager.Action untuk membatalkan booking.
     * 
     */
    public void cancelBooking(String bookingId) {
        // TODO: lengkapi method cancelBooking
        BookingManager.Action act = bookingManager.new Action();
        boolean bool = act.cancel(bookingId);
    }

    /*
     * Method showAllBookings
     * TODO: Method ini berupa prosedur yang akan menampilkan semua booking yang ada di dalam BookingManager.
     *        Gunakan method showAllBookings dari BookingManager untuk menampilkan semua booking.
     */
    public void showAllBookings() {
        bookingManager.showAllBookings();
        // TODO: lengkapi method showAllBookings
    }
}
