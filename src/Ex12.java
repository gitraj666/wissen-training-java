
import java.util.concurrent.TimeUnit;

class Pool {

    private Object lock = new Object();
    static String prev = null;

    public void swim() {
        String name = Thread.currentThread().getName();
        synchronized (lock) {
            if (name == prev)
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            prev = name;
            System.out.println(name + " -- swimming started..");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " -- swimming finished..");
            lock.notify();
        }
    }

}

public class Ex12 {

    public static void main(String[] args) {

        Pool pool = new Pool();

        //boolean flag = true;
        Runnable swimTask = () -> {
            //String nextSwimmer = "boy";
            for (int i = 0; i < 3; i++) {
                pool.swim();
            }
        };

        Thread thread1 = new Thread(swimTask, "boy");
        Thread thread2 = new Thread(swimTask, "girl");

        thread1.start();
        thread2.start();

    }

}
