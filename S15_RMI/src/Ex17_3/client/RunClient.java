package Ex17_3.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RunClient
{
    public static void main(String[] args) throws RemoteException, NotBoundException
    {
        RemoteClient client = new RemoteClient();
        client.startClient();

        Scanner scanner = new Scanner(System.in);
        String result = "";
        while (true)
        {
            System.out.print("Enter operation: ");
            String operation = scanner.nextLine();

            System.out.print("Enter message: ");
            String message = scanner.nextLine();

            switch (operation.toLowerCase())
            {
                case "uppercase":
                    try
                    {
                        client.changeToUpperCase(message);
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "randomcase":
                    try
                    {
                        client.changeToRandomCase(message);
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Operation not found.");
                    break;
            }
        }
    }
}
