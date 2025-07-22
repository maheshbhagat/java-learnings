package threads.completablefutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
        /*CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
            }
            System.out.println("Hello World!Y");
            return "100";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(6000);
            } catch (Exception e) {
            }
            System.out.println("Hello World!X");
            return "200";
        });

       // CompletableFuture<Void> completed = CompletableFuture.allOf(future1, future2);
        //completed.get();
        
        System.out.println(future1.getNow("Jobs"));
        //System.out.println(future2.get());
        
        System.out.println("Running main completed");*/



        /*CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Task completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });*/

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Task completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.setDaemon(true);
        thread.start();

        System.out.println("Main thread finished");
    }
}
