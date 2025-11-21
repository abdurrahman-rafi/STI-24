public class RequestProducer implements Runnable {
    private final RequestQueue queue;
    private int counter = 1;

    /*
     * Konstruktor kelas yang menerima RequestQueue
     * inisiasi queue dengan parameter q
     */
    // Type your code here
    public RequestProducer(RequestQueue queue){
        this.queue = queue;
    }

    /*
     * Implementasikan method run() yang akan terus-menerus menghasilkan request
     * dengan menambahkan id request ke queue menggunakan method enqueue.
     * Id request berupa nilai counter yang dimulai dari 1 dan bertambah setiap kali enqueue.
     * Cetak "Producer generated request #<id>" setiap kali menambahkan request.
     * Sleep thread selama 80ms setiap pembentukan request.
     * 
     * Hint: 
     *  - Gunakan Thread.currentThread().isInterrupted() untuk pengecekan interupsi
     *  - Tangani InterruptedException dengan blok try-catch (catch kosong)
     */
    // Type your code here
    @Override
    public void run(){
        while(!Thread.currentThread().isInterrupted()){
            try {
                int id = counter;
                queue.enqueue(counter);
                System.out.println("Producer generated request #" + id);    
                
                Thread.sleep(80);
                counter++;
            } catch (InterruptedException e) {
                break;
            }
        }
        
    }
}
