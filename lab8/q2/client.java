import java.rmi.*;
public class client
{
	public static void main(String args[])
	{
		try{
			Adder stub=(Adder)Naming.lookup("rmi://localhost/AddServer");
			int a =Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int c = stub.add(a,b);
			System.out.println("Sum of "+a+" and "+b+" is "+c);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
