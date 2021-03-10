package S06_Sockets.Ex10_8.Client;

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
    Socket socket = new Socket("127.0.0.1", 12345);
    socket.setKeepAlive(false);
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(
        new InputStreamReader(socket.getInputStream()));
    while (true)
    {
      System.out.println(in.readLine());

      out.println(scanner.nextLine());
      String message = in.readLine();
      System.out.println(message);

      if (message.equalsIgnoreCase("disconnected"))
      {
        socket.close();
        return;
      }

      out.println(scanner.nextLine());

      System.out.println(in.readLine());
    }
  }
}
