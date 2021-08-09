package learning.thread.printByOrder;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockPrinter {
    public static void main(String[] args) {
        int count = 3;
        new Thread(new MyPrinter("A", count)).start();
        new Thread(new MyPrinter("B", count)).start();
        new Thread(new MyPrinter("C", count)).start();
    }
}

class MyPrinter implements Runnable {
    private static Lock lock = new ReentrantLock();
    private static Condition conditionA = lock.newCondition();
    private static Condition conditionB = lock.newCondition();
    private static Condition conditionC = lock.newCondition();
    private static String last = "C";

    private String name;
    private int count;

    public MyPrinter(String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            switch (name) {
                case "A":
                    printA();
                    break;
                case "B":
                    printB();
                    break;
                case "C":
                    printC();
                    break;
                default:
                    break;
            }
        }
    }

    private void printA() {
        lock.lock();
        try {
            if (!last.equals("C")) {
                conditionA.await();
            }
            System.out.println(name);
            last = name;
            conditionB.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void printB() {
        lock.lock();
        try {
            if (!last.equals("A")) {
                conditionB.await();
            }
            System.out.println(name);
            last = name;
            conditionC.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void printC() {
        lock.lock();
        try {
            if (!last.equals("B")) {
                conditionC.await();
            }
            System.out.println(name);
            last = name;
            conditionA.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

