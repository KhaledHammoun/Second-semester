package S06_Sockets.Ex11_1.Server;

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
      Socket socket = serverSocket.accept();

      Thread thread = new Thread(new ServerSocketHandler(socket));
      thread.start();
    }
  }
}
