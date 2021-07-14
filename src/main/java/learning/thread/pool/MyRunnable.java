package learning.thread.pool;

import java.util.Date;

// 这是一个简单的Runnable类，需要大约5秒钟来执行其任务。
public class MyRunnable implements Runnable {
    private String command;

    public MyRunnable(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
        processCommand(3000);
        System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
    }

    private void processCommand(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
