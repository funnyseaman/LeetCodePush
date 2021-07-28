package learning.thread;

public class PrintByOrder {


    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            System.out.println("thread-1");
        });
        Thread t2=new Thread(()->{
            System.out.println("thread-2");
        });
        Thread t3=new Thread(()->{
            System.out.println("thread-3");
        });

        int i=0;
        while (i < 3) {
            t1.start();
            t2.start();
            t3.start();
        }
    }

}
