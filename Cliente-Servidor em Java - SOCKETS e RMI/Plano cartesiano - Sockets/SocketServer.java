import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

public class SocketServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("O Servidor está em execução");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado!");

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String input = in.readLine(); 
                StringTokenizer st = new StringTokenizer(input, ",");
                double x = Double.parseDouble(st.nextToken());
                double y = Double.parseDouble(st.nextToken());

                double r = Math.sqrt(x * x + y * y);
                double theta = Math.atan2(y, x);

                out.println(r + "," + theta);

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
