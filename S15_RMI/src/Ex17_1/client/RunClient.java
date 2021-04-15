package Ex17_1.client;

import Ex17_1.shared.TextServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RunClient
{
    public static void main(String[] args) throws RemoteException, NotBoundException
    {
        TextClient client = new TextClient();
        client.startClient();

        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.print("Message to send: ");
            String message = scanner.nextLine();

            try
            {
                client.sendText(message);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
