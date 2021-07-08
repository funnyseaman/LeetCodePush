package learning;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigDecimalDemo {
    @Test
    public void test_BigDecimal() {
        BigDecimal a = new BigDecimal("2");
        BigDecimal b = new BigDecimal("1.1");

        System.out.println(a.add(b));
        System.out.println(a.subtract(b));
        System.out.println(a.multiply(b));
        System.out.println(a.divide(b, 3, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void test_BigInteger() {
        BigInteger a = new BigInteger("100");
        BigInteger b = new BigInteger("30");
        System.out.println(a.mod(b));
        System.out.println(a.remainder(b));
    }
}
