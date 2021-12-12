import java.util.Scanner;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ticketNumber = scanner.next();
        String leftNumbers = ticketNumber.substring(0, 3);
        String rightNumbers = ticketNumber.substring(3);

        System.out.println(
                sumDigits(leftNumbers) == sumDigits(rightNumbers)
                        ? "Lucky" : "Regular");
    }

    private static int sumDigits(String string) {
        return Stream.of(string.split(""))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}