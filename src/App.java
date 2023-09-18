import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        Person teste = new Person("Jorge", "190.245.234-23", "jorge@gmail.com", "people.txt");

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

        teste.create();
        System.out.println(teste.readAll());
        System.out.println(teste.read("190.245.234-23", 1));
        System.out.println(teste.update("190.245.234-23", "Jorge,190.245.234-23,jorge2@gmail.com;", 1));
        System.out.println(teste.readAll());
        System.out.println(teste.delete("190.245.234-23", 1));
    }
}
