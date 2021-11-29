import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static LocalDateTime merge(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        int year = Math.max(dateTime1.getYear(), dateTime2.getYear());
        int month = Math.max(dateTime1.getMonth().getValue(), dateTime2.getMonth().getValue());
        int day = Math.max(dateTime1.getDayOfMonth(), dateTime2.getDayOfMonth());
        int hours = Math.max(dateTime1.getHour(), dateTime2.getHour());
        int minutes = Math.max(dateTime1.getMinute(), dateTime2.getMinute());
        int seconds = Math.max(dateTime1.getSecond(), dateTime2.getSecond());

        return LocalDateTime.of(year, month, day, hours, minutes, seconds);
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final LocalDateTime firstDateTime = LocalDateTime.parse(scanner.nextLine());
        final LocalDateTime secondDateTime = LocalDateTime.parse(scanner.nextLine());
//        final LocalDateTime firstDateTime = LocalDateTime.parse("2018-10-20T22:30");
//        final LocalDateTime secondDateTime = LocalDateTime.parse("2017-12-30T22:31:45");

        System.out.println(merge(firstDateTime, secondDateTime));
    }
}
