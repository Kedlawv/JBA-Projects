import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime date = LocalDateTime.parse(scanner.nextLine());
        int minutes = scanner.nextInt();

        date = date.plusMinutes(minutes);
        System.out.printf("%d %d %s",date.getYear(),date.getDayOfYear(), date.toLocalTime());

    }
}