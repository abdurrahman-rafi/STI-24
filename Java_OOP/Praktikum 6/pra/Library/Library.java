
import java.util.ArrayList;
import java.util.List;

public class Library {
    // Todo: Buat atribut name (String) dan sections (List<Section>)
    private String name;
    private List<Section> sections;

    public Library(String name) {
        this.name = name;
        sections = new ArrayList<Section>();
        // Todo: Implementasi konstruktor dengan inisialisasi atribut name dengan parameter name
        // dan inisialisasi sections sebagai ArrayList kosong
    }

    // Todo: Implementasi method addSection yang menerima parameter Section
    // Method ini menambahkan section ke list sections
    // Tampilkan pesan: "Section '[nama section]' added to [nama library]"
    public void addSection(Section section){
        sections.add(section);
        System.out.println(String.format("Section '%s' added to %s", section.getSectionName(), name));
    }

    // Todo: Implementasi method findBook yang menerima parameter String title
    // Method ini mencari buku berdasarkan judul di semua section
    // Jika ditemukan, tampilkan:
    // - "Found "[title]" in [nama section] section"
    // - Detail buku menggunakan getDetails()
    // Jika tidak ditemukan, tampilkan: "Book "[title]" not found in library"
    public void findBook(String title){
        Section.Book found = null;
        Section foundSection = null;

        for(Section s : sections){
            for(Section.Book b : s.getBooks()){
                if(b.getTitle().equalsIgnoreCase(title)){
                    found = b;
                    foundSection = s;
                    break;
                }
            }
            if(found != null){
                break;
            }
        }

        if(found == null){
            System.out.println(String.format("Book \"%s\" not found in library", title));
        }else{
            System.out.println(String.format("Found \"%s\" in %s section",  title, foundSection.getSectionName()));
            System.out.println(found.getDetails());
        }
    }

    // Todo: Implementasi method displayAllBooks tanpa parameter
    // Method ini menampilkan semua buku di semua section
    public void displayAllBooks(){
        for(Section s : sections){
            s.displayBooks();
        }
    }
    // Todo: Implementasi getter getName() yang mengembalikan name
    public String getName(){
        return name;
    }
    // Todo: Implementasi getter getSections() yang mengembalikan sections
    public List<Section> getSections(){
        return sections;
    }

    // Static Nested Class - Section
    public static class Section {
        // Todo: Buat atribut sectionName (String) dan books (List<Book>)
        private String sectionName;
        private List<Book> books;

        public Section(String sectionName) {
            // Todo: Implementasi konstruktor
            // Inisialisasi sectionName dengan parameter
            // Inisialisasi books sebagai ArrayList kosong
            this.sectionName = sectionName;
            books = new ArrayList<Book>();

        }

        // Todo: Implementasi method addBook yang menerima parameter Book
        // Method ini menambahkan book ke list books
        // Tampilkan pesan: "Book "[judul buku]" added to [nama section] section"
        public void addBook(Book book){
            books.add(book);
            System.out.println(String.format("Book \"%s\" added to %s section", book.getTitle(), getSectionName() ));
        }

        // Todo: Implementasi method removeBook yang menerima parameter String title
        // Method ini menghapus buku berdasarkan judul dari list books
        // Gunakan looping untuk mencari buku dengan judul yang sesuai (case-insensitive)
        // Jika ditemukan:
        // - Hapus buku dari list
        // - Tampilkan: "Book "[title]" removed from [nama section] section"
        // Jika tidak ditemukan:
        // - Tampilkan: "Book "[title]" not found in [nama section] section"
        public void removeBook(String title){
            Book toRemove = null;

            for(Book b: books){
                if(b.getTitle().equalsIgnoreCase(title)){
                    toRemove = b;
                }
            }

            if(toRemove == null){
                System.out.println(String.format("Book \"%s\" not found in %s section",title, getSectionName() ));
            }else{
                books.remove(toRemove);
                System.out.println(String.format("Book \"%s\" removed from %s section", title, getSectionName()));
            }
        }

        // Todo: Implementasi method displayBooks tanpa parameter
        // Jika books kosong, tampilkan: "No books in this section"
        // Jika ada buku, tampilkan detail setiap buku
        public void displayBooks(){
            if(books.isEmpty()){
                System.out.println("No books in this section");
            }else{
                for(Book b: books){
                    System.out.println(b.getDetails());
                }
            }
        }

        // Todo: Implementasi getter getSectionName() yang mengembalikan sectionName
        public String getSectionName(){
            return sectionName;
        }
        // Todo: Implementasi getter getBooks() yang mengembalikan books
        public List<Book> getBooks(){
            return books;
        }

        // Non-static Inner Class - Book
        public class Book {
            // Todo: Buat atribut:
            // - title (String)
            // - author (String)
            // - isAvailable (boolean)
            // - borrowedBy (String)
            private String title;
            private String author;
            private boolean isAvailable;
            private String borrowedBy;

            public Book(String title, String author) {
                isAvailable = true;
                borrowedBy = null;
                this.title = title;
                this.author = author;
                // Todo: Implementasi konstruktor
                // Inisialisasi title dan author dengan parameter
                // Set isAvailable = true
                // Set borrowedBy = null
            }

            // Todo: Implementasi method borrowBook yang menerima parameter String memberName
            // Jika buku sudah dipinjam (!isAvailable):
            // - Tampilkan: "Error: Book "[title]" is already borrowed by [borrowedBy]"
            public void borrowBook(String memberName){
                if(!isAvailable){
                    System.out.println(String.format("Error: Book \"%s\" is already borrowed by %s", getTitle(), borrowedBy));
                    return;
                }

                isAvailable = false;
                borrowedBy = memberName;
                System.out.println(String.format("Book \"%s\" is now borrowed by %s", getTitle(), memberName));
            }
            
            // Jika tersedia:
            // - Set isAvailable = false
            // - Set borrowedBy = memberName
            // - Tampilkan: "Book "[title]" is now borrowed by [memberName]"

            // Todo: Implementasi method returnBook tanpa parameter
            // Jika buku sedang tidak dipinjam (isAvailable):
            // - Tampilkan: "Error: Book "[title]" is not currently borrowed"
           
            // Jika sedang dipinjam:
            // - Tampilkan: "Book "[title]" returned by [borrowedBy]"
            // - Set isAvailable = true
            // - Set borrowedBy = null

            public void returnBook(){
                if(isAvailable){
                    System.out.println(String.format("Error: Book \"%s\" is not currently borrowed", getTitle()));
                }else{
                    System.out.println(String.format("Book \"%s\" returned by %s", getTitle(), borrowedBy));
                    isAvailable = true;
                    borrowedBy = null;
                }
            }

            // Todo: Implementasi method getDetails() yang mengembalikan String
            // Buat variabel status:
            // - Jika isAvailable = true, status = "Available"
            // - Jika isAvailable = false, status = "Borrowed by [borrowedBy]"
            // Return format: "Book "[title]" by [author] [[status]] - Section: [sectionName]"
            // Note: Book dapat mengakses sectionName dari enclosing class Section
            public String getDetails(){
                String status;
                if(isAvailable){
                    status = "Available";
                }else{
                    status = "Borrowed by " + borrowedBy;
                }

                return String.format("Book \"%s\" by %s [%s] - Section: %s", getTitle(), getAuthor(), status, getSectionName());
            }

            // Todo: Implementasi getter getTitle() yang mengembalikan title
            public String getTitle(){
                return title;
            }
            // Todo: Implementasi getter getAuthor() yang mengembalikan author
            public String getAuthor(){
                return author;
            }

            // Todo: Implementasi getter isAvailable() yang mengembalikan isAvailable
            public boolean isAvailable(){
                return isAvailable;
            }
        }
    }

    public static class Member {
        // Todo: Buat atribut:
        // - name (String)
        // - borrowedBooks (List<Section.Book>)
        // - maxBorrowLimit (int)
        private String name;
        private List<Section.Book> borrowedBooks;
        private int maxBorrowLimit;

        public Member(String name, int maxBorrowLimit) {
            // Todo: Implementasi konstruktor
            this.name=name;
            this.maxBorrowLimit = maxBorrowLimit;
            borrowedBooks = new ArrayList<Section.Book>();
            // Inisialisasi name dan maxBorrowLimit dengan parameter
            // Inisialisasi borrowedBooks sebagai ArrayList kosong
        }

        // Todo: Implementasi method canBorrow() yang mengembalikan boolean
        // Return true jika jumlah borrowedBooks < maxBorrowLimit
        // Return false jika sudah mencapai limit
        public boolean canBorrow(){
            return (borrowedBooks.size() < maxBorrowLimit);
        }

        // Todo: Implementasi method borrowBook yang menerima parameter Section.Book book
        // Jika member tidak bisa meminjam lagi (!canBorrow()):
        // - Tampilkan: "Error: [name] has reached the borrow limit of [maxBorrowLimit] books"
        
        // Jika buku tidak tersedia (!book.isAvailable()):
        // - Tampilkan: "Error: Book "[judul buku]" is not available"
      
        // Jika bisa meminjam:
        // - Panggil book.borrowBook(name)
        // - Tambahkan book ke borrowedBooks
        public void borrowBook(Section.Book book){
            if(!canBorrow()){
                System.out.println(String.format("Error: %s has reached the borrow limit of %d books", name, maxBorrowLimit));
            }else if(!book.isAvailable()){
                System.out.println(String.format("Error: Book \"%s\" is not available",book.getTitle() ));
            }else{
                book.borrowBook(name);
                borrowedBooks.add(book);
            }
        }

        // Todo: Implementasi method returnBook yang menerima parameter Section.Book book
        // Jika book ada di borrowedBooks:
        // - Panggil book.returnBook()
        // - Hapus book dari borrowedBooks
        // Jika book tidak ada di borrowedBooks:
        // - Tampilkan: "Error: [name] has not borrowed "[judul buku]""
        public void returnBook(Section.Book book){
            if(borrowedBooks.contains(book)){
                book.returnBook();
                borrowedBooks.remove(book);
            }else{
                System.out.println(String.format("Error: %s has not borrowed \"%s\"", name, book.getTitle()));
            }
        }

        // Todo: Implementasi method displayBorrowedBooks tanpa parameter
        // Tampilkan: "[name]'s Borrowed Books ([jumlah borrowed]/[maxBorrowLimit]):"
        // Jika borrowedBooks kosong:
        // - Tampilkan: "No books currently borrowed"
        // Jika ada buku yang dipinjam:
        // - Untuk setiap buku, tampilkan: "  - [title] by [author]"
        public void displayBorrowedBooks(){
            System.out.println(String.format("%s's Borrowed Books (%d/%d):", name, borrowedBooks.size(), maxBorrowLimit));
            if(borrowedBooks.isEmpty()){
                System.out.println("No books currently borrowed");
            }else{
                for(Section.Book book : borrowedBooks){
                    System.out.println("  - " + book.getTitle() + " by " + book.getAuthor());
                }
            }
        }
    }
}