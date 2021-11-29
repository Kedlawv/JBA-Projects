import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime date = LocalDateTime.parse(scanner.next());

        System.out.println(date.plusHours(11).toLocalDate());
    }
}