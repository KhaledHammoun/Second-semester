package S06_Sockets.Ex11_1.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;

  public ServerSocketHandler(Socket socket)
  {
    this.socket = socket;
  }

  @Override public void run()
  {
    try
    {
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
        out.println(toUppercase.toUpperCase());
      }
    }
    catch (IOException e)
    {

    }
  }
}
