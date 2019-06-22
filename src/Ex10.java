// Deadlock Example


class Mary {
    private static Object keyMary = new Object();

    public synchronized void getName(John john) {
        System.out.println("Got name:: Mary");
    }

    public synchronized void getAge() {
        System.out.println("Got age:: Mary");
    }
}

class John {
    private static Object keyJohn = new Object();

    public synchronized void getName(Mary mary) {
        System.out.println("Got name:: John");
    }

    public synchronized void getAge() {
        System.out.println("Got age:: John");
    }
}


public class Ex10 {
    public static void main(String[] args) {
        Mary mary = new Mary();
        John john = new John();

        Runnable dead = () -> {
            String name = Thread.currentThread().getName();
            if (name.equals("T1"))
                mary.getName(john);
            else
                john.getName(mary);
        };

        Thread thread1 = new Thread(dead, "T1");
        Thread thread2 = new Thread(dead, "T2");

        thread1.start();
        thread2.start();
    }
}
