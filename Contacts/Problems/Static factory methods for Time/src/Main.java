import java.time.LocalTime;
import java.util.Scanner;

class Time {

    int hour;
    int minute;
    int second;


    private Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public static Time noon() {
        return new Time(12, 0, 0);
    }

    public static Time midnight() {
        return new Time(0, 0, 0);
    }

    public static Time ofSeconds(long seconds) {
        int maxSeconds = 86400;
        if (seconds > maxSeconds) {
            seconds -= maxSeconds * (seconds / maxSeconds);
        }

        LocalTime time = LocalTime.ofSecondOfDay(seconds);
        return new Time(time.getHour(), time.getMinute(), time.getSecond());
    }

    public static Time of(int hour, int minute, int second) {
        if (inRange(0, 23, hour)
                && inRange(0, 59, minute)
                && inRange(0, 59, second)) {
            return new Time(hour, minute, second);
        }
        return null;
    }

    public static boolean inRange(int minValue, int maxValue, int value) {
        if (maxValue < minValue) {
            return false;
        }
        return (value >= minValue) && (value <= maxValue);
    }
}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String type = scanner.next();
        Time time = null;

        switch (type) {
            case "noon":
                time = Time.noon();
                break;
            case "midnight":
                time = Time.midnight();
                break;
            case "hms":
                int h = scanner.nextInt();
                int m = scanner.nextInt();
                int s = scanner.nextInt();
                time = Time.of(h, m, s);
                break;
            case "seconds":
                time = Time.ofSeconds(scanner.nextInt());
                break;
            default:
                time = null;
                break;
        }

        if (time == null) {
            System.out.println(time);
        } else {
            System.out.println(String.format("%s %s %s", time.hour, time.minute, time.second));
        }
    }
}