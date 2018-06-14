package come.practice.class20.e06;

import java.io.FileInputStream;
import java.io.IOException;

public class TestMyBufferedReader {
    public static void main(String[] args) throws IOException {
        try (FileInputStream in = new FileInputStream("D:/test/in.txt")) {
            MyBufferedReader myReader = new MyBufferedReader(in);
            String line1 = myReader.nextLine();
            System.out.println(line1);
        }
    }
}

class MyBufferedReader {
    private FileInputStream in;
    private StringBuffer buffer;
    MyBufferedReader(FileInputStream in) {
        this.in = in;
        buffer = new StringBuffer();
    }

    String nextLine() throws IOException {
        while (true) {
            int c = in.read();
            if (c == -1 || c == '\n') {
                break;
            }
            buffer.append((char)c);
        }
        String output = buffer.toString();
        buffer = new StringBuffer();
        return output;
    }
}
