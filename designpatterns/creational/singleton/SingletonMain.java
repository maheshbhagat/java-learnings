package designpatterns.creational.singleton;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Singleton{

    private static Singleton instance = null;
    private static Lock lock = new ReentrantLock();

    private Singleton(){

    }

    public static Singleton getInstance(){
        System.out.println("Accessed by : "+Thread.currentThread().getName());
        if(instance == null){
            synchronized(Singleton.class){
                System.out.println("Lock acquired by : "+Thread.currentThread().getName());
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        System.out.println("Completed by : "+Thread.currentThread().getName());
        return instance;
    }

    public static Singleton getInstanceV2(){
        System.out.println("Accessed by : "+Thread.currentThread().getName());

        if(instance == null){
            lock.lock();
            System.out.println("Lock acquired by : "+Thread.currentThread().getName());

            try{
                if(instance == null){
                    instance = new Singleton();
                    System.out.println("Creating instance by : "+Thread.currentThread().getName());
                }
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("Lock released by : "+Thread.currentThread().getName());
                lock.unlock();
            }
        }
        System.out.println("Completed by : "+Thread.currentThread().getName());
        return instance;
    }

}

public class SingletonMain{
    public static void main(String[] args){

        Thread t1 = new Thread(() -> {
            Singleton s1 = Singleton.getInstance();
            System.out.println(s1);
        },"T1");

        Thread t2 = new Thread(() -> {
            Singleton s1 = Singleton.getInstance();
            System.out.println(s1);
        },"T2");

        Thread t3 = new Thread(() -> {
            Singleton s1 = Singleton.getInstance();
            System.out.println(s1);
        },"T3");

        t1.start();
        t2.start();
        t3.start();

        try{
            t1.join();t2.join();t3.join();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}