import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class server extends UnicastRemoteObject implements facto{
    public server() throws RemoteException {}

    //calculating 
    @Override
    public int fact(int n) throws RemoteException{
        System.out.println("Received " + n + " from client");

        int fact = 1;
        for(int i = 2;i <= n; i++)
            fact *= i;

        System.out.println("Returning " + fact + "\n");
        return fact;
    }

    public static void main(String[] args) throws RemoteException{
        try{
            Registry reg = LocateRegistry.createRegistry(9999);
            reg.rebind("ALOK KUMAR SINGH", new server());
            System.out.println("Server is ready");
        }
        catch(RemoteException err){
            System.out.println("exception" + err);
        }
    }
}