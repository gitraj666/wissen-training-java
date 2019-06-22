import java.util.concurrent.*;

public class Ex13 {
    public static void main(String[] args) {
        Callable<String> foodTask = () -> {
            String food = "biryani";
            return food;
        };

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(foodTask);

        System.out.println(future.isDone());

        try {
            String food = future.get();
            System.out.println(food);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        Object key = new Object();
        Runnable task = () -> {
            synchronized (key) {
                String name = Thread.currentThread().getName();
                System.out.println(name + " Started ...");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished...");
            }
        };
        ExecutorService executorService1;
        executorService1 = Executors.newFixedThreadPool(3);
        executorService1.submit(task);
        executorService1.submit(task);
        executorService1.submit(task);


        executorService1.shutdown();
    }
}
