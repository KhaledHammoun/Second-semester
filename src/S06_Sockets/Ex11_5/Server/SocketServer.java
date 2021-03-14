package S06_Sockets.Ex11_5.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer
{
    private Pool connections;

    public SocketServer()
    {
      connections = new Pool();
    }

    public void startServer()
    {
      try (ServerSocket serverSocket = new ServerSocket(12345))
      {
        while (true)
        {
          Socket socket = serverSocket.accept();
          System.out.println("Connected " + socket.getInetAddress().getHostAddress());
          ServerSocketHandler serverSocketHandler = new ServerSocketHandler(
              socket, connections);
          connections.addConnection(serverSocketHandler);
          Thread thread = new Thread(serverSocketHandler);
          thread.start();
        }
      }
      catch (IOException e)
      {

      }

    }

}
