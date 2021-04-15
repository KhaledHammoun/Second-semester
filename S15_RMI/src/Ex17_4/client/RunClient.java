package Ex17_4.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RunClient
{
    public static void main(String[] args) throws RemoteException, NotBoundException
    {
        RemoteMessageClient client = new RemoteMessageClient();
        client.startClient();

        for (int i = 0; i < 1000000; i++)
        {
            try
            {
                client.addMessage(i + "");
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }

        try
        {
            client.printMessagesSize();
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
