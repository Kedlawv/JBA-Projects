import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String one = scanner.nextLine();
        String two = scanner.nextLine();

        Map<String, Integer> oneCount = new HashMap<>();
        Map<String, Integer> twoCount = new HashMap<>();

        Arrays.stream(one.toLowerCase().split(""))
                .forEach(key -> oneCount.merge(key, 1, Integer::sum));
        Arrays.stream(two.toLowerCase().split(""))
                .forEach(key -> twoCount.merge(key, 1, Integer::sum));

        System.out.println(oneCount.equals(twoCount) ? "yes" : "no");

    }
}