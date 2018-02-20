import java.io.*;
import java.net.*;

class TCPserver
{

	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(8000);
		System.out.println("Server Running on port 8000");
		Socket s = ss.accept();
		System.out.println("Connection Established");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		OutputStream out = s.getOutputStream();
		PrintWriter pw = new PrintWriter(out,true);
		System.out.println("Enter message ");	//Communicate to Server
		String str=br.readLine();
		pw.println(str);
		s.close();
	}
}
