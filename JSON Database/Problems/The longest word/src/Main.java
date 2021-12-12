import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");

        int indexOfLongest = -1;
        int maxLength = -1;

        for (int i = 0; i < strings.length; i++) {
            int length = strings[i].length();

            if (length > maxLength) {
                maxLength = length;
                indexOfLongest = i;
            }
        }

        // Alternative solution
        String longestWord = "";
        for (String word : strings) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        System.out.println(strings[indexOfLongest]);
    }
}