import java.io.*;
import java.net.*;

class serverclient
{

	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(8000);
		System.out.println("Server Running on port 8000");
		//Server started
		String str="";

		Socket s = ss.accept();
		System.out.println("Connection Established");
		while(true){
		InputStream in = s.getInputStream();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                br=new BufferedReader(new InputStreamReader(in));
                str=br.readLine();
                System.out.println("Client --> " +str);
		if( str.equals("close"))
			break;
		}
		s.close();
	}
}
