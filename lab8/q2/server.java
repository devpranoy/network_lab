import java.rmi.registry.*;
import java.rmi.*;
public class server
{
	public static void main(String args[])
	{
		try{
			AdderRemote skel = new AdderRemote();
			Naming.rebind("AddServer",skel);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
