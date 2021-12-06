import java.io.CharArrayWriter;
import java.io.IOException;

class Converter {
    public static char[] convert(String[] words) throws IOException {
        CharArrayWriter charWriter = new CharArrayWriter();
        for (String s : words) {
            charWriter.write(s);
        }

        char[] chars = charWriter.toCharArray();
        charWriter.close();

        return chars;
    }
}