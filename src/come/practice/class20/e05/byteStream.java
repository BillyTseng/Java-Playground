package come.practice.class20.e05;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class byteStream {
    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        try{
            in = new FileInputStream("D:/test/in.txt");
            out = new FileOutputStream("D:/test/out.txt");
            /*int c;
            while ((c = in.read()) != -1) {
                System.out.print((char)c);
                out.write(c);
            }
            System.out.println();*/

            byte[] bytes = new byte[7];
            int n = in.read(bytes);
            System.out.println("n = " + n);
            for (byte b : bytes) {
                System.out.print((char)b);
            }
        } finally{
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
