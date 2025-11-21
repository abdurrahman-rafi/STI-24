

/*
 * Buatlah kelas ProcessTask yang memiliki atribut konstan privat:
 *      - String id
 *      - Resource cpu
 *      - Resource io
 * Inisiasi dengan konstruktor berparameter String id, Resource cpu, Resource io
 * 
 * 1. Kelas memiliki method privat void lockResource(Resource r, int ms).
 *    Method ini akan mengunci resource r selama ms milidetik.
 *    Saat resource dikunci, tampilkan pesan "<id> memperoleh <r.name>"
 *    Setelah ms milidetik, tampilkan pesan "<id> melepas <r.name>"
 * 
 * 2. Override method run() dari Thread.
 *    Operasi ini mensimulasikan eksekusi sebuah proses dalam sistem operasi.
 *    Proses ini akan melewati 3 tahapan (Berikan jeda 50ms di antara tahapan):
 *     a. Mengunci resource cpu selama 100 ms
 *     b. Mengunci resource io selama 100 ms
 *     c. Mengunci resource cpu selama 100 ms
 *   Setelah menyelesaikan ketiga tahapan, tampilkan pesan "<id> selesai"
 *   Jika thread diinterupsi saat mengunci resource io, tangkap InterruptedException
 *      dan tampilkan pesan "<id> dibatalkan saat memakai resource <io.name>"
 */

public class ProcessTask extends Thread{
    private String id;
    private Resource cpu;
    private Resource io;

    public ProcessTask(String id, Resource cpu, Resource io){
        this.id = id;
        this.cpu = cpu;
        this.io = io;
    }

    private void lockResource(Resource r, int ms) throws InterruptedException{
        System.out.println(id + " memperoleh " + r.getName());
        
        Thread.sleep(ms);
        
        System.out.println(id + " melepas " + r.getName());
    }

    @Override
    public void run(){

        try {
            cpu.acquire();
            lockResource(cpu, 100);
            cpu.release();

            Thread.sleep(50);

            io.acquire();
            try {
                lockResource(io, 100);
            } finally {
                io.release();
            }

            Thread.sleep(50);

            cpu.acquire();
            lockResource(cpu, 100);
            cpu.release();

            System.out.println(id + " selesai");
        } catch(InterruptedException e) {
            System.out.println(id + " dibatalkan saat memakai resource " + io.getName());
            // io.release();
        }
        

    }

}