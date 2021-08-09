package learning.designpattern.producerConsumer;

public class Producer extends Thread {
    private Buffer buffer;
    private int id;

    public Producer(Buffer buffer, int id) {
        this.buffer = buffer;
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                // 模拟生产数据
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 将数据放入缓冲区
            buffer.put(i);
            System.out.println("生产者 #" + id + " put: " + i);
        }
    }
}
