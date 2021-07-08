package learning.reflection;

public class TestClass {
    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("非静态代码块");
    }

    public String pubVal;
    private String value;

    public TestClass() {
        value = "HelloWorld";
    }

    public void publicMethod(String s) {
        System.out.println("public func: " + s);
    }

    private void privateMethod() {
        System.out.println("private func: " + value);
    }
}
