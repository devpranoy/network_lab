import java.rmi.*;
public interface Adder extends Remote{

public String add() throws RemoteException;
}
