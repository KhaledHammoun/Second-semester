package Ex10_9.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MainClient
{
  public static void main(String[] args) throws IOException
  {
    Scanner scanner = new Scanner(System.in);
    Socket socket = new Socket("127.0.0.1", 5678);
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    while (true)
    {
      String messageReceived = in.readLine();
      System.out.println(messageReceived);
      String messageSend = scanner.nextLine();
      out.println(messageSend);

      if (messageReceived.equalsIgnoreCase("bey")|| messageSend.equalsIgnoreCase("bey"))
      {
        socket.close();
        return;
      }
    }
  }
}
