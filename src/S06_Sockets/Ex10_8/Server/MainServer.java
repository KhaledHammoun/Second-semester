package S06_Sockets.Ex10_8.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer
{
  public static void main(String[] args) throws IOException
  {
    try (ServerSocket serverSocket = new ServerSocket(12345))
    {
      while (true)
      {
        Socket socket = serverSocket.accept();
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));

        System.out.println(
            "Connected " + socket.getInetAddress().getHostAddress() + " "
                + socket.getLocalPort() + " connected");
        while (true)
        {
          out.println("How can I help you?");
          String message = in.readLine();
          if (message.equalsIgnoreCase("stop"))
          {
            out.println("Disconnected");
            socket.close();
            break;
          }

          out.println("Give me string to " + message);

          if (message.equalsIgnoreCase("uppercase"))
          {
            message = in.readLine();
            out.println("Result: " + message.toUpperCase());
          }
          else if (message.equalsIgnoreCase("lowercase"))
          {
            message = in.readLine();
            out.println("Result: " + message.toLowerCase());
          }
          else
          {
            in.readLine();
            out.println(message + " is invalid operation.");
          }
        }
      }

    }
  }
}
