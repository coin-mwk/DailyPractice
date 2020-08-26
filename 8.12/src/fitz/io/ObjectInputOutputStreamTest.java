package fitz.io;


import java.io.*;

/**
 * @author Fitz
 * @create 2020-08-26-1:06 下午
 */
public class ObjectInputOutputStreamTest {

    public static void main(String[] args) {
        testObjectOutputStream();
        testObjectInputStream();


    }

    private static void testObjectInputStream() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("8.12/src/fitz/io/date,dat"));
            Object o = ois.readObject();
            System.out.println(o);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois!=null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static void testObjectOutputStream() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("8.12/src/fitz/io/date,dat"));
            oos.writeObject(new String("我爱编程！编程爱我！"));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (oos!=null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
