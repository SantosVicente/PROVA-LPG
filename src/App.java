import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        /*Files name var */
        String FileName = "people.txt";

        List<Person> People = new ArrayList<Person>(); //lista que carrega os dados
        Person Person = new Person(FileName); //auxiliar para manipular os dados

        try {
            String data = Person.readAll();
            String[] lines = data.split(";");
            for (String line : lines) {
                String[] parts = line.split(",");
                Person.setName(parts[0]);
                Person.setDescription(parts[1]);
                People.add(Person);
            }
        } catch (Exception e) {
            System.out.println("ERRO: Não foi possível ler do arquivo -> " + e.getMessage());
        }

        Scanner input = new Scanner(System.in);
        int menu = 0;

        do{
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - op1");
            System.out.println("2 - op2");
            System.out.println("3 - Sair\n");
            System.out.print("R: ");
            menu = Integer.parseInt(input.nextLine());

            if (menu == 1) {
                Person.setName("Jorge");
                Person.setDescription("Teste");
                People.add(Person);
                Person.create();
            }

            if (menu == 2) {
                continue;
            }

            if (menu != 1 && menu != 2 && menu != 3) {
                System.out.println("\nOpção inválida!\n");
            }
        }while(menu != 3);

        input.close();
    }
}
