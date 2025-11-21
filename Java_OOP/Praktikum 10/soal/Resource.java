
import java.util.concurrent.locks.ReentrantLock;

/*
 * Buatlah kelas Resource dengan attribut String name dan Object lock
 * Inisiasi kelas dengan konstruktor menerima parameter String name
 * Object lock diinisiasi dengan object baru
*/
public class Resource{
    private String name;
    private ReentrantLock lock;

    public Resource(String name){
        this.name = name;
        lock = new ReentrantLock();
    }

    public String getName(){
        return name;
    }

    public ReentrantLock getLock(){
        return lock;
    }

    public boolean tryAcq(){
        return lock.tryLock();
    }

    public void acquire(){
        lock.lock();
    }

    public void release(){
        if(lock.isHeldByCurrentThread()){
            lock.unlock();
        }
    }
}
