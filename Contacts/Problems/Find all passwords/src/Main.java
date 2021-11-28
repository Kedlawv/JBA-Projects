import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
//        String text = "My email javacoder@gmail.com with password    SECRET115. Here is my old PASSWORD: PASS.";

        // Pattern in the parenthesis is a capturing group. We match on the whole pattern (group 0)
        // but we can access only the part of the pattern in the parenthesis by calling
        // matcher.group(1)
        Pattern pattern = Pattern.compile("password[ :]*([a-zA-Z0-9]+)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        if (!matcher.find()) {
            System.out.println("No passwords found.");
        } else {
            matcher.reset();
            while (matcher.find()) {
                System.out.println(matcher.group(1));
            }
        }

    }
}