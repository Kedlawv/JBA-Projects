import java.io.*;

class Executor {
    public static void main(String[] args) {
        UserProfile userProfile = new UserProfile("BilboB"
                , "bilbo@shire.me", "cheese");

        File file = new File("./Problems/Password processing/src/user_profile.txt");

        try(FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(userProfile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis)){
            UserProfile userProfileDes = (UserProfile)ois.readObject();
            System.out.println(userProfileDes);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
