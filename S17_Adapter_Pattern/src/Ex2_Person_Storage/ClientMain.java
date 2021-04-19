package Ex2_Person_Storage;

import java.util.Scanner;

public class ClientMain
{
    public static void main(String[] args)
    {
        PersonStorage storage = new DBPersonStorage();

        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.print("ADD/GET: ");
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("add"))
            {
                System.out.print("Give a name: ");
                String name = scanner.nextLine();
                System.out.print("Give a date of birth: ");
                String DOB = scanner.nextLine();
                System.out.print("Give social security number: ");
                int ssn = Integer.parseInt(scanner.nextLine());

                Person person = new Person(name, DOB, ssn);
                storage.addPerson(person);
            }
            else if (command.equalsIgnoreCase("get"))
            {
                System.out.print("Give persons ssn: ");
                int ssn = Integer.parseInt(scanner.nextLine());

                System.out.println(storage.getPerson(ssn));
            }
            else
                System.out.println("Invalid operation. Try again.");
        }

    }
}
