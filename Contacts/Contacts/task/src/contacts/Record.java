package contacts;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Record {


    private String number ="";
    private final LocalDateTime creationDateTime;
    private LocalDateTime editDateTime;

    public Record(){
        creationDateTime = LocalDateTime.now();
    }

    public Record(String number) {
        creationDateTime = LocalDateTime.now();
        setNumber(number);
    }

    private boolean isValidNumber(String number){
        Pattern pattern = Pattern.compile(
                "^\\+?\\([\\da-zA-Z]+\\)([ -][a-zA-Z0-9]{2,})*" +
                        "|^\\+?[\\da-zA-Z]+[ -]?([0-9a-zA-Z]{2,}[ -]?)*$" +
                        "|^\\d*$" +
                        "|^\\+?[\\da-zA-Z]{2,}[ -](\\([0-9a-zA-Z]+\\))([ -][a-zA-Z0-9]{2,})*");

        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    public boolean hasNumber(){
        return !"".equals(number) && number != null;
    }

    public String getNumber() {
        return hasNumber() ? number : "[no number]";
    }

    public boolean setNumber(String number) {
        if(isValidNumber(number)){
            this.number = number;
            return true;
        } else {
            this.number = "";
            return false;
        }
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public LocalDateTime getEditDateTime() {
        return editDateTime;
    }

    public void setEditDateTime(LocalDateTime editDateTime) {
        this.editDateTime = editDateTime;
    }


}
