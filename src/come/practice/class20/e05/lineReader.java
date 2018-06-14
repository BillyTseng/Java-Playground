package come.practice.class20.e05;

import java.io.*;

public class lineReader {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;

        try{
            fis = new FileInputStream("D:/test/in.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } finally{
            if (fis != null) {
                fis.close();
            }
        }
    }
}
