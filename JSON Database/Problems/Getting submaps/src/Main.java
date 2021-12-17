import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] ranges = scanner.nextLine().split(" ");
        int start = Integer.parseInt(ranges[0]);
        int end = Integer.parseInt(ranges[1]);

        int size = Integer.parseInt(scanner.nextLine());

        SortedMap<Integer, String> pairs = new TreeMap<>();
        String[] values;

        while (scanner.hasNextLine()) {
            values = scanner.nextLine().split(" ");
            pairs.put(Integer.parseInt(values[0]), values[1]);
        }

        SortedMap<Integer, String> subMap = pairs.subMap(start, end + 1);

        for (Map.Entry<Integer, String> entry : subMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}