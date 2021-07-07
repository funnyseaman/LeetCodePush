package learning.class_object;

import org.junit.Test;

public class Pig extends Animal implements Flyable {
    public Pig(String name) {
        super(name);
    }

    @Override

    public void fly() {
        System.out.println("Aah, pig can fly!");
    }

    @Override
    public void run() {
        // super.run();
        System.out.println("Pig can run.");
    }

    private void pig() {
        System.out.println("Hey,it is private also.");
    }


    @Test
    public void test() {
        super.run();
        this.run();
    }
}
