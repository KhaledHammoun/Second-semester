package S06_Sockets.Ex10_6.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain1 {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 5678);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String message = in.readLine();
        System.out.println(message);
        String firstNumber = new Scanner(System.in).nextLine();
        out.println(firstNumber);
        message = in.readLine();
        System.out.println(message);

        String operand = new Scanner(System.in).nextLine();
        out.println(operand);
        message = in.readLine();
        System.out.println(message);

        String secondNumber = new Scanner(System.in).nextLine();
        out.println(secondNumber);
        message = in.readLine();
        System.out.println(message);



    }
}
