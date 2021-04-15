package Ex17_2.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RunClient
{
    public static void main(String[] args) throws RemoteException, NotBoundException
    {
        EchoClient client = new EchoClient();
        client.startClient();

        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.print("Message to uppercase: ");
            String message = scanner.nextLine();

            if (message.equalsIgnoreCase("exit"))
            {
                break;
            }
            client.addMessage(message);
        }
    }
}
