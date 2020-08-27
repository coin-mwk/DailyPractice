package fitz.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Fitz
 * @create 2020-08-27-9:31 上午
 */
public class RandomAccessFileTest {
    public static void main(String[] args) {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;

        try {
            raf1 = new RandomAccessFile(new File("8.12/src/fitz/io/c.txt"),"rwd");
            raf2 = new RandomAccessFile(new File("8.12/src/fitz/io/c_new.txt"),"rwd");
            byte[] bytes = new byte[1024];
            raf1.seek(1);
            int len = raf1.read(bytes);
            raf1.seek(1);
            raf1.write("444".getBytes());
            raf1.write(bytes,0,len);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (raf2!=null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf1!=null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
