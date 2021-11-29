package contacts;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Record {

    private String name;
    private String surname;
    private String number ="";

    public Record(String name, String surname, String number) {
        this.name = name;
        this.surname = surname;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equals(name, record.name) &&
                Objects.equals(surname, record.surname) &&
                Objects.equals(number, record.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, number);
    }

    @Override
    public String toString() {
        return name + " " + surname + ", " + getNumber();
    }
}
