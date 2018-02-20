import java.net.*;
import java.io.*;
class client{
	public static void main(String args[]) throws Exception{
		Socket ss=new Socket("localhost",8769);
		String st="";	
		BufferedReader br=new BufferedReader(new InputStreamReader(ss.getInputStream()));
		while(!st.equals("close"))
		{
			st=br.readLine();
			System.out.println("Server says : "+st);
		}
		ss.close();
	}
}
