// Producer Consumer Pattern

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Ex11 {
    static List<Integer> list = new ArrayList<>();
    static int counter = 0;
    static int startEven = 2;
    static int start = 1;

    public static void main(String[] args) {
        Object lock = new Object();
        //int startEven = 2;
        Runnable evenFactory = () -> {

            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    if (counter % 2 == 0) {
                        try {
                            System.out.println("Even factory waitin....");
                            lock.wait();
                            System.out.println("Notification recieved");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        try {
                            TimeUnit.SECONDS.sleep(3);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Even started");
                    list.add(startEven);
                    System.out.println(startEven + " added ");
                    counter = startEven;
                    startEven += 2;
                    lock.notify();
                }
            }
        };

        Runnable oddFactory = () -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    if (counter % 2 != 0) {
                        try {
                            System.out.println("Odd factory waitin....");
                            lock.wait();
                            System.out.println("Notification recieved");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    System.out.println("Odd Started");
                    list.add(start);
                    System.out.println(start + " added");
                    counter = start;
                    start += 2;
                    lock.notify();
                }
            }
        };
        Thread thread1 = new Thread(oddFactory);
        Thread thread2 = new Thread(evenFactory);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list);
    }
}
