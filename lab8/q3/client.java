import java.rmi.*;
public class client
{
	public static void main(String args[])
	{
		try{
			Adder stub=(Adder)Naming.lookup("rmi://localhost/AddServer");
			 
			System.out.println(stub.add());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
