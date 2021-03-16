package Ex10_3.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain1
{

  public static void main(String[] args) throws IOException
  {
    ServerSocket serverSocket = new ServerSocket(1235);
    while (true)
    {
      try
      {
        Socket socket = serverSocket.accept();
        System.out.println(
            "Client connected from " + socket.getInetAddress().getHostAddress()
                + " " + socket.getLocalPort());
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        out.println("Hello from server. Write your name");
        String nameFromClient = in.readLine();
        out.println("Hello " + nameFromClient);
        for (int i = 0; i < 3; i++)
        {
          out.println("Please give me a String to uppercase.");
          String toUppercase = in.readLine();
          if (toUppercase.equalsIgnoreCase("exit"))
          {
            serverSocket.close();
            System.out.println("Server shutting down. ");
            return;
          }
          else if (toUppercase.equalsIgnoreCase("stop"))
          {
            System.out.println("Current client closed");
            break;
          }
          out.println(toUppercase.toUpperCase());
        }
      }
      catch (IOException e)
      {

      }
    }
  }
}
