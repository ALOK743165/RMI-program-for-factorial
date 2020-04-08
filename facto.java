import java.rmi.*;

public interface facto extends Remote{
    public int fact(int n) throws RemoteException;
}