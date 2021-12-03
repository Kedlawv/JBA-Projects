package contacts;

import java.time.LocalDate;
import java.util.Objects;

public class PersonRecord extends Record{

    private String name;
    private String surname;
    private String birthDate;
    private String gender;

    public PersonRecord(){}

    public PersonRecord(String name, String surname, String number
            , String birthDate, String gender) {
        super(number);
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
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

    public String getBirthDate() {
        if(birthDate == null || birthDate.isEmpty()){
            return "[no data]";
        }
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        if(gender == null || gender.isEmpty()){
            return "[no data]";
        }

        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n"
                + "Surname: " + surname + "\n"
                + "Birth date: " + getBirthDate() + "\n"
                + "Gender: " + getGender() + "\n"
                + "Number: " + super.getNumber() + "\n"
                + "Time created: " + super.getCreationDateTime() + "\n"
                + "Time last edit: " + super.getEditDateTime();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonRecord that = (PersonRecord) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(birthDate, that.birthDate) &&
                gender == that.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate, gender);
    }
}
