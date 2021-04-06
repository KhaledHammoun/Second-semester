package Ex17_6.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class RunClient
{
    public static void main(String[] args) throws RemoteException, NotBoundException
    {
        RMITaskClient client = new RMITaskClient();
        client.startClient();

        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.println("What operation do you want to perform? \"add, remove, size\"");
            String operation = scanner.nextLine();
            switch (operation)
            {
                case "add":
                    System.out.print("Enter task text: ");
                    String text = scanner.nextLine();

                    System.out.print("Enter estimated time: ");
                    Long time = Long.parseLong(scanner.nextLine());

                    client.addTask(text, time);
                    break;
                case "remove":
                    client.remove();
                    break;
                case "size":
                    client.size();
                    break;
                default:
                    System.out.println("Illegal operation");
            }

        }
    }
}
