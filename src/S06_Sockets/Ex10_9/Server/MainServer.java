package S06_Sockets.Ex10_9.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainServer
{
  public static void main(String[] args) throws IOException
  {
    try (ServerSocket serverSocket = new ServerSocket(5678))
    {
      while (true)
      {
        Scanner scanner = new Scanner(System.in);
        Socket socket = serverSocket.accept();
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        System.out.println(
            "Connected is " + socket.getInetAddress().getHostAddress() + " " + socket.getPort());

        while (true)
        {
          //String messageSend = scanner.nextLine();
          //out.println(messageSend);
          String messageReceived = in.readLine();
          System.out.println(messageReceived);

          String messageSend = scanner.nextLine();
          out.println(messageSend);
          if (messageReceived.equalsIgnoreCase("bye") || messageSend.equalsIgnoreCase("bye"))
          {
            socket.close();
            break;
          }
        }
      }
    }
  }
}

