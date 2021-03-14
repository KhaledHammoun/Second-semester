package S06_Sockets.Ex11_2.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain1
{

  public static void main(String[] args) throws IOException, ClassNotFoundException
  {
    Socket socket = new Socket("127.0.0.1", 1235);
    Client client = new Client(socket);
    client.start();
  }
}
