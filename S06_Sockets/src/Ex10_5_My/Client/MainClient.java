package Ex10_5_My.Client;

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

    Socket socket = new Socket("127.0.0.1", 6666);
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    String message = in.readLine();
    System.out.println(message);

    out.println(scanner.nextLine());

    while (true)
    {
      System.out.println(in.readLine());
      String number = scanner.nextLine();
      out.println(number);

      if (number.equalsIgnoreCase("equals"))
      {
        break;
      }
      else if (number.equalsIgnoreCase("exit"))
      {
        System.out.println("Client closing..");
        return;
      }
    }

    System.out.println(in.readLine());
  }
}
