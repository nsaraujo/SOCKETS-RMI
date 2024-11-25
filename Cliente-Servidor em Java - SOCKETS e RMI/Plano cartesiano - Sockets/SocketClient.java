import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

public class SocketClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String input = JOptionPane.showInputDialog("Insira as coordenadas cartesianas no formato x,y:");
            out.println(input);

            String response = in.readLine();
            String[] polarCoords = response.split(",");
            double r = Double.parseDouble(polarCoords[0]);
            double theta = Double.parseDouble(polarCoords[1]);

            JOptionPane.showMessageDialog(null,
                    String.format("Coordenadas Polares:\nr = %.2f\nθ = %.2f rad", r, theta));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
