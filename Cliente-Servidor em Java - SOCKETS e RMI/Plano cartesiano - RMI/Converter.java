import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Converter extends Remote {
    String toPolar(double x, double y) throws RemoteException;
}
