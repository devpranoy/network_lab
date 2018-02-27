import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.io.*;
import java.util.*;
import java.text.*;
public class AdderRemote extends UnicastRemoteObject implements Adder
{
	AdderRemote() throws RemoteException
	{
	}
	public String add()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String str = dateFormat.format(date);
		return str;
	}
}
