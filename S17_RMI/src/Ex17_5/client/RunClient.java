package Ex17_5.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RunClient
{
    public static void main(String[] args) throws RemoteException, NotBoundException
    {
        RemoteMessageClient client = new RemoteMessageClient();
        client.startClient();

        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.println("Enter message:");
            String message = scanner.nextLine();

            client.addMessage(message);
        }
    }
}
