import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ConverterImpl extends UnicastRemoteObject implements Converter {
    protected ConverterImpl() throws RemoteException {
        super();
    }

    @Override
    public String toPolar(double x, double y) throws RemoteException {
        double r = Math.sqrt(x * x + y * y);
        double theta = Math.atan2(y, x);
        return r + "," + theta;
    }
}

