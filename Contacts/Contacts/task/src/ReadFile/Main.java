package ReadFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    static File file = new File("./Contacts/task/src/ReadFile/dataset_91033.txt");

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNext()){
                System.out.println(scanner.next());
            }

        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }

        File directory = new File("./"); //get absolute path to the root of working directory
        System.out.println(directory.getAbsolutePath());

        System.out.println("--------------------------------------");

        try {
            String s = readFileAsString(file.getPath());
            System.out.println(s);
        } catch (IOException e) {
            System.out.println("Cannot read file: " + e.getMessage());
        }

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        try(Stream<String> stream= Files.lines(Path.of(file.toURI()))){
            stream.forEach(s -> {Integer i = Integer.parseInt(s);System.out.print("" + i + i.getClass());});
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n******************************************************");

        try(Stream<String> stream= Files.lines(Path.of(file.toURI()))){
            Integer result = stream
                    .map(Integer::parseInt)
                    .reduce(0, Integer::sum);
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(findGreatestInFile("./Contacts/task/src/ReadFile/dataset_91007.txt"));


    }
        public static String readFileAsString(String fileName) throws IOException {
            return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static int findGreatestInFile(String path){
        int greatest = 0;
        try{
            String string = new String(Files.readAllBytes(Paths.get(path)));
            greatest = Arrays.stream(string.split(" "))
                    .map(Integer::parseInt)
                    .max(Integer::compareTo)
                    .orElse(Integer.MIN_VALUE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return greatest;
    }
}
