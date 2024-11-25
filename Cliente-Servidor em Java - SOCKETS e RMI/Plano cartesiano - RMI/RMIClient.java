import java.rmi.Naming;
import javax.swing.JOptionPane;

public class RMIClient {
    public static void main(String[] args) {
        try {

            Converter converter = (Converter) Naming.lookup("//localhost/ConverterOn");

            String input = JOptionPane.showInputDialog("Insira as coordenadas cartesianas no formato x,y:");
            String[] coords = input.split(",");
            double x = Double.parseDouble(coords[0]);
            double y = Double.parseDouble(coords[1]);

            String response = converter.toPolar(x, y);
            String[] polarCoords = response.split(",");
            double r = Double.parseDouble(polarCoords[0]);
            double theta = Double.parseDouble(polarCoords[1]);

            JOptionPane.showMessageDialog(null, String.format("Coordenadas Polares:\nr = %.2f\nθ = %.2f rad", r, theta));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
