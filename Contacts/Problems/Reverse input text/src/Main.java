

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int ch = reader.read();
        while (ch != -1) {
            sb.append((char) ch);
            ch = reader.read();
        }

        System.out.println(sb.reverse().toString());
        reader.close();
    }
}