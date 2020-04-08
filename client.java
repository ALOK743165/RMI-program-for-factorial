import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.NotBoundException;
import java.util.Scanner;

public class client{
    public static void main(String[] args) throws RemoteException {
        client c = new client();
        c.connectRemote();
    }

    private void connectRemote() throws RemoteException{
        try{
            Scanner scan = new Scanner(System.in);
            Registry reg = LocateRegistry.getRegistry("localhost", 9999);

            facto factorial = (facto)reg.lookup("ALOK KUMAR SINGH");
            System.out.print("Enter a number: ");
            int n = scan.nextInt();

            System.out.println("Factorial is " + factorial.fact(n));
            
        } catch(NotBoundException | RemoteException err) {
            System.out.println("exception: " + err);
        }
    }
}