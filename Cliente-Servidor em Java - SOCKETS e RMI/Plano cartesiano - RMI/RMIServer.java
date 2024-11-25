import java.rmi.Naming;

public class RMIServer {
    public static void main(String[] args) {
        try {
            Converter converter = new ConverterImpl();
            Naming.rebind("//localhost/ConverterOn", converter);
            System.out.println("Servidor RMI está em execução");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
