package contacts.aqq_solution;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenderValidator implements Validator {
    private static Pattern GENDER_PATTERN = Pattern.compile("[MF]", Pattern.CASE_INSENSITIVE);
    @Override
    public boolean validate(String gender) {
        Matcher matcher = GENDER_PATTERN.matcher(gender);
        return matcher.matches();
    }

}