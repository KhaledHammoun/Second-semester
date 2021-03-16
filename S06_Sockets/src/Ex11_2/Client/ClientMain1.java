package Ex11_2.Client;

import java.io.IOException;
import java.net.Socket;

public class ClientMain1
{

  public static void main(String[] args) throws IOException, ClassNotFoundException
  {
    Socket socket = new Socket("127.0.0.1", 1235);
    Client client = new Client(socket);
    client.start();
  }
}
