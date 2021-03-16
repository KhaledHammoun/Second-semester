package Ex10_7.Server;

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
    try(ServerSocket serverSocket = new ServerSocket(5678))
    {
      while (true)
      {
        Socket socket = serverSocket.accept();
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        out.println("Would you like to connect?");
        String message = in.readLine();
        if (!(message.equalsIgnoreCase("connect")))
        {
          out.println("Disconnected.");
          continue;
        }
        System.out.println(
            "Client " + socket.getInetAddress().getHostAddress() + " " + socket.getLocalPort() + " connected");

        out.println("Username: ");
        String username = in.readLine();

        out.println("Password: ");
        String password = in.readLine();

        out.println("Approved.");
      }
    }
  }
}
