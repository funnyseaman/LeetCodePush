package learning.thread.how2use;

import org.junit.Test;

public class ThreadChildDemo extends Thread{
    private Thread thread;


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    @Test
    public void test() {
        new ThreadChildDemo().start();
        new ThreadChildDemo().start();
    }
}
