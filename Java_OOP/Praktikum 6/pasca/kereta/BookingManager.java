import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Booking> bookings;

    /*
     * Konstruktor Kelas BookingManager
     * TODO: Lengkapi state awal dari attribut BookingManager
     *      - Inisialisasi list bookings dengan list kosong
     */
    public BookingManager() {
        // TODO: lengkapi konstruktor
        bookings = new ArrayList<Booking>();

    }

    /*
     * Inner class Action
     * TODO: Buatlah method cancel dan addbooking
     *     - Method cancel akan menerima parameter String bookingId dan mengembalikan boolean.
     *          Method cancel akan menghapus booking yang memiliki bookingId dari bookings.
     *          Jika booking berhasil dihapus, jangan lupa untuk menambahkan seat pada kereta 
     *          yang bersangkutan dan keluarkan pesan "Booking <bookingId> berhasil dibatalkan."
     *          Jika bookingId tidak ditemukan, kembalikan false dan keluarkan pesan 
     *          "Booking ID tidak ditemukan: <bookingId>"
     * 
     *     - Method addBooking berupa prosedur yang menerima parameter Booking booking.
     *          Method ini akan menambahkan booking ke dalam list bookings.
     */
    public class Action {
        // TODO: Lengkapi class Action
        public boolean cancel(String bookingId){
            // System.out.println(bookingId);
            Booking toC = null;
            for(Booking b : bookings){
                // System.out.println(b.getBookingId());
                if(b.getBookingId().equals(bookingId)){
                    toC = b;
                    break;
                }
            }

            if(toC == null){
                System.out.println("Booking ID tidak ditemukan: " + bookingId);
                return false;
            }else{
                System.out.println("Booking " + bookingId + " berhasil dibatalkan.");
                toC.getTrain().increaseSeat();
                bookings.remove(toC);
                return true;
            }
        }

        public void addBooking(Booking booking){
            bookings.add(booking);
        }
    }

    /*
     * Method showAllBookings
     * TODO:    Method ini berupa prosedur yang akan menampilkan semua booking yang ada di dalam list bookings.
     *          Awali dengan menampilkan header "=== Daftar Semua Booking ===\n"
     *          - Jika tidak ada booking, tampilkan pesan "(Belum ada booking)\n"
     *          - Jika bookings tidak kosong, print objek booking satu per satu.
     */
    public void showAllBookings() {
        // TODO: lengkapi method showAllBookings
        System.out.println("=== Daftar Semua Booking ===");
        if(bookings.isEmpty()){
            System.out.println("(Belum ada booking)");
        }else{
            for(Booking b : bookings){
                System.out.println(b);
            }
        }
    }

    /*
     * Getter untuk bookings
     * TODO: Getter ini akan mengembalikan list bookings
     */
    public List<Booking> getBookings() {
        // TODO: lengkapi getter
        return bookings;
    }
}
