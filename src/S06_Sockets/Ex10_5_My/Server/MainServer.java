package S06_Sockets.Ex10_5_My.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MainServer
{
  public static void main(String[] args) throws IOException
  {
    System.out.println("Server starting...");
    try (ServerSocket serverSocket = new ServerSocket(6666))
    {
      while (true)
      {
        Socket socket = serverSocket.accept();
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        out.println("Welcome to the calculator server. What operation do you want to perform?");
        String operand = in.readLine();
        out.println("You would like to " + operand + ". Give me number now:");
        String number = in.readLine();
        List<Double> numbers = new ArrayList<>();
        while (true)
        {
          if (number.equalsIgnoreCase("equals"))
          {
            break;
          }
          else if (number.equalsIgnoreCase("stop"))
          {
            return;
          }
          numbers.add(Double.parseDouble(number));
          out.println("Give me another number:");
          number = in.readLine();
        }
        double result = 0;
        switch (operand)
        {
          case "add":
            for (Double num : numbers)
            {
              result += num;
            }
            break;
          case "subtract":
            for (Double num: numbers)
            {
              result -= num;
            }
              break;
          case "multiply":
            result++;
            for (Double num : numbers)
            {
              result *= num;
            }
            break;
        }

        out.println("The total is: " + result);
      }
    }
  }
}
