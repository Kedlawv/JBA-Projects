package contacts.aqq_solution;

import java.util.Scanner;

public class ContactUtils {

    public static String initiateDialogue(String request, Validator validator, String posResponse, String negResponse) {
        Scanner sc = new Scanner(System.in);
        System.out.println(request);
        String input = sc.nextLine();
        sc.close();
        if (validator.validate(input)) {
            System.out.println(posResponse);
            return input;
        } else {
            System.out.println(negResponse);
            return null;
        }
    }

}