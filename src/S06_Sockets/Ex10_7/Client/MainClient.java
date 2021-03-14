package S06_Sockets.Ex10_7.Client;

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
    Socket socket = new Socket("192.168.1.11", 5678);
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    System.out.println(in.readLine());
    out.println(new Scanner(System.in).nextLine());

    System.out.println(in.readLine());
    out.println(new Scanner(System.in).nextLine());

    System.out.println(in.readLine());
    out.println(new Scanner(System.in).nextLine());

    System.out.println(in.readLine());
  }
}
