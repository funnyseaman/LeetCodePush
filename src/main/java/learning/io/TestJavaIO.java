package learning.io;

import org.junit.Test;

import java.io.*;

public class TestJavaIO {
    String path = "src/main/java/learning/io/test.txt";

    @Test
    public void test_FileReader_BufferedReader() throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
//        System.out.println(br.readLine());
//        System.out.println(br.readLine());
//        System.out.println(br.readLine());
        char[] temp = new char[50];
        int len = br.read(temp);
        System.out.println(new String(temp, 0, len));
    }

    @Test
    public void test_FileInputStream_BufferedInputStream() throws IOException {
        FileInputStream fis = new FileInputStream(path);
        BufferedInputStream bis = new BufferedInputStream(fis);
        byte[] temp = new byte[100];
        int len = bis.read(temp);
        System.out.println(new String(temp, 0, len));
    }

    @Test
    public void test_FileInputStream_InputStreamReader() throws IOException {
        FileInputStream fr = new FileInputStream(path);
        InputStreamReader isr = new InputStreamReader(fr);
        char[] temp = new char[50];
        int len = isr.read(temp);
        System.out.println(new String(temp, 0, len));
    }
}
