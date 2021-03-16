package Ex11_6.Client;

import java.io.IOException;

public class RunClient
{
  public static void main(String[] args) throws IOException
  {
    ClientSocket clientSocket = new ClientSocket();
    clientSocket.start();
  }
}
