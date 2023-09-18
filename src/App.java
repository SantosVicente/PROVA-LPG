import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Person> people = new ArrayList<Person>();
        people.add(new Person("Jorge", "190.245.234-23", "jorge@gmail.com", "people.txt"));

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("people.txt"));
            String line = bufferedReader.readLine();
            boolean prox = true;

            if (line != null) {
                prox = false;
            } else if (line == null && prox == true) {
                try (FileWriter fileWriter = new FileWriter("people.txt", false);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                    bufferedWriter.write("");
                    bufferedWriter.close();
                } catch (IOException e) {
                    System.out.println("ERRO: Não foi possível abrir o arquivo -> " + e.getMessage());
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            try (FileWriter fileWriter = new FileWriter("people.txt", false);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.write("");
                bufferedWriter.close();
            } catch (IOException e2) {
                System.out.println("ERRO: Não foi possível abrir o arquivo -> " + e2.getMessage());
            }
        }

        people.get(0).create();
        System.out.println(people.get(0).readAll());
        System.out.println(people.get(0).read("190.245.234-23", 1));
        System.out.println(people.get(0).update("190.245.234-23", "Jorge,190.245.234-23,jorge2@gmail.com;", 1));
        System.out.println(people.get(0).readAll());
        System.out.println(people.get(0).delete("190.245.234-23", 1));
    }
}
