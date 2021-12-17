import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String newsPaper = scanner.nextLine();
        String note = scanner.nextLine();

        Map<String, Integer> newsPaperWords = getWordsCount(newsPaper);
        Map<String, Integer> noteWords = getWordsCount(note);

        for (String key : noteWords.keySet()) {
            if (!newsPaperWords.containsKey(key)) {
                System.out.println("You are busted");
                return;
            } else if (newsPaperWords.get(key) < noteWords.get(key)) {
                System.out.println("You are busted");
                return;
            }
        }

        System.out.println("You get money");


    }

    private static Map<String, Integer> getWordsCount(String string) {
        String[] words = string.split(" ");
        Map<String, Integer> wordsCount = new HashMap<>();
        Arrays.stream(words).forEach(word -> wordsCount.merge(word, 1, Integer::sum));
        return wordsCount;
    }
}