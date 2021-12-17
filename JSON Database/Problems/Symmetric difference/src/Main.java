import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SetUtils {

    /**
     * @return symmetric difference between set1 and set2
     */

    // (A-B)+(B-A)
    public static Set<String> symmetricDifference(Set<String> set1, Set<String> set2) {
        Set<String> a = new HashSet<>(set1);
        Set<String> b = new HashSet<>(set2);
        a.removeAll(set2);
        b.removeAll(set1);
        a.addAll(b);

        return a;
    }

    // Solution from JBA less readable but clever
    public static Set<String> symmetricDifferenceStream(Set<String> set1, Set<String> set2) {
        return Stream.of(set1, set2) // stream of sets
                .flatMap(set -> set.stream())  // streams get joined
                .filter(s -> !set1.contains(s) || !set2.contains(s))  // we get a stream of all strings
                .collect(Collectors.toSet());
    }

}

/* Do not change the code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String strSet1 = scanner.nextLine();
        String strSet2 = scanner.nextLine();

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        if (!Objects.equals(strSet1, "empty")) {
            Collections.addAll(set1, strSet1.split("\\s+"));
        }

        if (!Objects.equals(strSet2, "empty")) {
            Collections.addAll(set2, strSet2.split("\\s+"));
        }

        Set<String> resultSet = SetUtils.symmetricDifference(set1, set2);

        System.out.println(String.join(" ", resultSet));
    }
}