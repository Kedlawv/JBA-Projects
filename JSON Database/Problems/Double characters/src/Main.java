import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        char[] charArr = string.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char ch : charArr) {
            sb.append(ch).append(ch);
        }

        System.out.println(sb.toString());
    }
}