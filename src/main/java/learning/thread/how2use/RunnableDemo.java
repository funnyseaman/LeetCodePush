package learning.thread.how2use;

import org.junit.Test;

public class RunnableDemo implements Runnable {
    private Thread thread;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    @Test
    public void test() {
        new Thread(new RunnableDemo(),"thread-1").start();
        new Thread(new RunnableDemo(),"thread-2").start();
    }
}
