import java.io.*;
import java.net.*;

class serverclientchat
{

	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(8000);
		System.out.println("Server Running on port 8000");
		//Server started

		Socket s = ss.accept();
		System.out.println("Connection Established");
		while(true){
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		OutputStream out = s.getOutputStream();
		PrintWriter pw = new PrintWriter(out,true);
		System.out.println("Server --> ");	//Communicate to Client
		String str=br.readLine();
		pw.println(str);
		InputStream in = s.getInputStream();
                br=new BufferedReader(new InputStreamReader(in));
                str=br.readLine();
                System.out.println("Client --> " +str);
		if (str.equals("close"))
			break;
		}
		s.close();
	}
}
