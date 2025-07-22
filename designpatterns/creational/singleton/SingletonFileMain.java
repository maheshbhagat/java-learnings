package designpatterns.creational.singleton;


class Singleton1  {

    private static Singleton1 instance = new Singleton1();

    private Singleton1(){

    }

    public static Singleton1 getInstane(){
        return instance;
    }
}

public class SingletonFileMain {

    public static void main(String[] args) {
        
        Singleton1 s1 = Singleton1.getInstane();

        System.out.println(s1);
    }
}
