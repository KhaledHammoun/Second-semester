package S06_Sockets.Ex10_6.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EsbenServer
{
  public static void main(String[] args) throws IOException
  {
    try (ServerSocket serverSocket = new ServerSocket(5678))
    {
      Socket socket = serverSocket.accept();
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(
          new InputStreamReader(socket.getInputStream()));

      out.println("Hello. Give me the first number.");
      int numberOne = Integer.parseInt(in.readLine());

      out.println("Give me an operand");
      String operand = in.readLine();

      out.println("Give me a second number");
      int secondNum = Integer.parseInt(in.readLine());

      int result = 0;
      switch (operand)
      {
        case "add":
            result = numberOne + secondNum;
          break;
        case "subtract":
          result = numberOne - secondNum;
          break;
        case "multiply":
          result = numberOne * secondNum;
          break;
      }
      out.println("The result is " + result);
    }

  }
}
