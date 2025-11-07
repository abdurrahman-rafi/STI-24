import java.util.ArrayList;
import java.util.List;

public class Member {
    // TODO: Implementasi class Member dengan exception handling
  //   TODO: Lengkapi class Member
  //  Class untuk member perpustakaan dengan batasan peminjaman.

  //  Fields:
  //  - name (String): nama member
  //  - memberId (String): ID unik member
  //  - maxBorrowLimit (int): maksimal buku yang bisa dipinjam
  //  - borrowedBooks (List<String>): daftar judul buku yang sedang dipinjam
  //  - isActive (boolean): status aktif member
    private String name;
    private String memberId;
    private int maxBorrowLimit;
    private List<String> borrowedBooks;
    private boolean isActive;

  //  Constructor:
    public Member(String name, String memberId, int maxBorrowLimit) throws LibraryException{

      if(name == null || name.trim().isEmpty()){
        throw new LibraryException("Name is empty/null", "INVALID_MEMBER");
      }

      if(memberId == null || memberId.trim().isEmpty()){
        throw new LibraryException("Invalid MemberID", "INVALID_MEMBER");
      }

      if(maxBorrowLimit < 1){
        throw new LibraryException("Borrow limit is negative", "INVALID_MEMBER");
      }


      this.name = name.trim();
      this.memberId = memberId.trim();
      this.maxBorrowLimit = maxBorrowLimit;
      borrowedBooks = new ArrayList<>();
      isActive = true;
    }
  //    Validasi:
  //    * name tidak boleh null/kosong (after trim) -> throw LibraryException dengan errorCode "INVALID_MEMBER"
  //    * memberId tidak boleh null/kosong (after trim) -> throw LibraryException dengan errorCode "INVALID_MEMBER"
  //    * maxBorrowLimit harus > 0 -> throw LibraryException dengan errorCode "INVALID_MEMBER"
  //    * inisialisasi borrowedBooks sebagai ArrayList kosong
  //    * set isActive = true

  //  Methods:
  //  - getters untuk semua fields: getName(), getMemberId(), getMaxBorrowLimit(), isActive()
  //  - getCurrentBorrowedCount(): return jumlah buku yang dipinjam
  //  - getBorrowedBooks(): return copy of list (new ArrayList<>(borrowedBooks))
  //  - setActive(boolean active): set status aktif
      public String getName(){
        return name;
      }
      public String getMemberId(){
        return memberId;
      }

      public int getMaxBorrowLimit(){
        return maxBorrowLimit;
      }

      public boolean isActive(){
        return isActive;
      }
      public int getCurrentBorrowedCount(){
        return borrowedBooks.size();
      }

      public List<String> getBorrowedBooks(){
        List<String> copy = new ArrayList<>(borrowedBooks);
        return copy;
      }

      public void setActive(boolean active){
        isActive = active;
      }


  //  - borrowBook(String bookTitle) throws LibraryException
  //    * URUTAN PENGECEKAN PENTING:
  //    1. Cek member aktif, jika tidak throw LibraryException dengan errorCode "MEMBER_INACTIVE"
  //    2. Cek belum meminjam buku ini (DUPLICATE CHECK FIRST!), jika sudah throw LibraryException dengan errorCode "ALREADY_BORROWED"
  //       Format message: "Anggota <name> sudah meminjam buku '<bookTitle>'."
  //    3. Cek belum mencapai limit, jika sudah throw LibraryException dengan errorCode "LIMIT_EXCEEDED"
  //       Format message: "Anggota <name> telah mencapai batas peminjaman (<current>/<max>)."
  //    4. Tambahkan bookTitle ke borrowedBooks
      public void borrowBook(String bookTitle) throws LibraryException{
        if(!isActive){
          throw new LibraryException("Member Inactive","MEMBER_INACTIVE");
        }

        if(borrowedBooks.contains(bookTitle)){
          throw new LibraryException(String.format("Anggota %s sudah meminjam buku '%s'.", name, bookTitle), "ALREADY_BORROWED");
        }

        if(getCurrentBorrowedCount() >= maxBorrowLimit){
          throw new LibraryException(String.format("Anggota %s telah mencapai batas peminjaman (%d/%d).", getName(), getCurrentBorrowedCount(), maxBorrowLimit), "LIMIT_EXCEEDED");
        }

        borrowedBooks.add(bookTitle);
      }

  //  - returnBook(String bookTitle) throws LibraryException
  //    * Cek buku ada di borrowedBooks, jika tidak throw LibraryException dengan errorCode "NOT_BORROWED"
  //      Format message: "Anggota <name> tidak meminjam buku '<bookTitle>'."
  //    * Hapus bookTitle dari borrowedBooks
    public void returnBook(String bookTitle) throws LibraryException{
      if(!borrowedBooks.contains(bookTitle)){
        throw new LibraryException(String.format("Anggota %s tidak meminjam buku '%s'.", getName(), bookTitle), "NOT_BORROWED");
      }

      borrowedBooks.remove(bookTitle);


    }

  //  - hasBorrowedBook(String bookTitle): return true jika ada di borrowedBooks
    public boolean hasBorrowedBook(String bookTitle){
      return (borrowedBooks.contains(bookTitle));
    }

  //  - toString(): return format string
  //    * Format EXACT (abaikan simbol <>): "<name> (ID: <id>) - Borrowed: <count>/<limit>"
  //    * <name> = nama member
  //    * <id> = memberId
  //    * <count> = getCurrentBorrowedCount()
  //    * <limit> = maxBorrowLimit
  //    * Contoh: "Alice Johnson (ID: M001) - Borrowed: 2/3"
  //    * Contoh: "Bob Smith (ID: M002) - Borrowed: 0/5"
    @Override
    public String toString(){
      String out = String.format("%s (ID: %s) - Borrowed: %d/%d", name, memberId, getCurrentBorrowedCount(),maxBorrowLimit);
      return out;
    }
}
