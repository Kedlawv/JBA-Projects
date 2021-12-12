import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int startIndex = scanner.nextInt();
        int endIndexIncl = scanner.nextInt();

        System.out.println(string.substring(startIndex, endIndexIncl + 1));
    }
}