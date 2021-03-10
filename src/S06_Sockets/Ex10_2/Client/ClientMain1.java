package S06_Sockets.Ex10_2.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain1
{

  public static void main(String[] args) throws IOException
  {

    Socket socket = new Socket("127.0.0.1", 1235);
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(
        new InputStreamReader(socket.getInputStream()));

    String message = in.readLine();
    System.out.println(message);
    String name = new Scanner(System.in).nextLine();
    out.println(name);
    message = in.readLine();
    System.out.println(message);
    for (int i = 0; i < 3; i++)
    {
      message = in.readLine();
      System.out.println(message);
      String ward = new Scanner(System.in).nextLine();
      out.println(ward);
      message = in.readLine();
      System.out.println(message);
    }
  }
}
