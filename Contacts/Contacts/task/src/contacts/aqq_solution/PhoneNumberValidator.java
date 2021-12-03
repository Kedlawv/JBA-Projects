package contacts.aqq_solution;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator implements Validator {
    private static Pattern PHONE_PATTERN = Pattern.compile("\\+?\\s?(\\(\\w+\\)|\\w+[ -]?\\(\\w{2,}\\)|\\w+)([ -]?\\w{2,})?([ -]?\\w{2,})?([ -]?\\w{2,})?");

    @Override
    public boolean validate(String number) {
        Matcher matcher = PHONE_PATTERN.matcher(number);
        return matcher.matches();
    }

}