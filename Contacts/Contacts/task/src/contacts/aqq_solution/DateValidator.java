package contacts.aqq_solution;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateValidator  implements Validator {
    private final static Pattern DATE_PATTERN = Pattern.compile("\\w");

    @Override
    public boolean validate(String date) {
        Matcher matcher = DATE_PATTERN.matcher(date);
        return matcher.matches();
    }

}