package learning.thread.how2use;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableAndFutureDemo implements Callable {
    @Override
    public String call() {
        System.out.println("started");
        return "ok";
    }


    @Test
    public void test() throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new CallableAndFutureDemo());
        new Thread(futureTask,"thread-1").start();
        new Thread(futureTask,"thread-2").start();
        System.out.println(futureTask.get());
        futureTask.run();
    }
}
