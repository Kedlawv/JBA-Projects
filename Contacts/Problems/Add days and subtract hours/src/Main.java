import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime date = LocalDateTime.parse(scanner.next());
        int days = scanner.nextInt();
        int hours = scanner.nextInt();

        System.out.println(date.minusHours(hours).plusDays(days));
    }
}