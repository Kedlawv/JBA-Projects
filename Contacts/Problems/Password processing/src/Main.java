import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class UserProfile implements Serializable {
    private static final long serialVersionUID = 26292552485L;

    private String login;
    private String email;
    private transient String password;

    public UserProfile(String login, String email, String password) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    // implement readObject and writeObject properly

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(encrypt(password));
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        this.password = decrypt((String)ois.readObject());
    }

    private String encrypt(String string) {
        char[] stringAsCharArr = string.toCharArray();
        for (int i = 0; i < stringAsCharArr.length; i++) {
            stringAsCharArr[i] = (char)(stringAsCharArr[i] + 1);
        }
        return String.valueOf(stringAsCharArr);
    }

    private String decrypt(String string) {
        char[] stringAsCharArr = string.toCharArray();
        for (int i = 0; i < stringAsCharArr.length; i++) {
            stringAsCharArr[i] = (char)(stringAsCharArr[i] - 1);
        }
        return String.valueOf(stringAsCharArr);
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}