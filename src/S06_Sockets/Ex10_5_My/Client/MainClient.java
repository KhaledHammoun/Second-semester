package S06_Sockets.Ex10_5_My.Client;

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
    Socket socket = new Socket("127.0.0.1", 6666);
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    String message = in.readLine();
    System.out.println(message);
    String operand = new Scanner(System.in).nextLine();
    out.println(operand);

    while (true)
    {
      message = in.readLine();
      System.out.println(message);
      String number = new Scanner(System.in).nextLine();
      out.println(number);
      if (number.equalsIgnoreCase("equals"))
      {
        break;
      }
      else if (number.equalsIgnoreCase("stop"))
      {
        System.out.println("Client closing..");
        return;
      }
    }

    message = in.readLine();
    System.out.println(message);
  }
}
