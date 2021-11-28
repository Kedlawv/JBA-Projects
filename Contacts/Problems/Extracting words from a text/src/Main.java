import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern regex = Pattern.compile("[a-zA-Z]*program[a-zA-Z]*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = regex.matcher(text);
        StringBuilder sb = new StringBuilder();

        matcher.results()
                .forEach(r -> sb.append(r.start()).append(" ").append(r.group()).append("\n"));

        System.out.println(sb.toString());


    }
}