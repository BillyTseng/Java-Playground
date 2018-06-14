package come.practice.class20.e05;

import java.io.*;

public class characterStream {
    public static void main(String[] args) throws IOException {
        FileReader in = null;
        FileWriter out = null;
        try{
            in = new FileReader("D:/test/in.txt");
            out = new FileWriter("D:/test/out.txt");
            int c;
            while ((c = in.read()) != -1) {
                System.out.print((char)c);
                out.write(c);
            }
            System.out.println();

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
