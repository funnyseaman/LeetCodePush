package learning.class_object;

import org.junit.Test;

public class Animal implements Cloneable{
    private String name;
    private Animal child;

    public Animal(String name) {
        this.name=name;
    }

    public void run() {
        System.out.println("Animal can run.");
    }

    private void animal() {
        System.out.println("Hey, it is private.");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        Animal child = new Animal("child");

        Animal a1 = new Animal("a1");
        a1.child=child;

        Animal a2 = (Animal) a1.clone();

        System.out.println(a1.hashCode());
        System.out.println(a2.hashCode());
    }
}
