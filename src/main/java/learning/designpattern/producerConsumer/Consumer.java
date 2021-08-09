package learning.designpattern.producerConsumer;

public class Consumer extends Thread {
    private Buffer buffer;
    private int id;

    public Consumer(Buffer buffer, int id) {
        this.buffer = buffer;
        this.id = id;
    }

    @Override
    public void run() {
        int value;
        for (int i = 0; i < 3; i++) {
            // 从缓冲区拿取数据
            value = buffer.get();
            try {
                // 模拟消费数据
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("消费者 #" + id + " get: " + value);
        }
    }
}
