import java.io.*;
import java.net.*;

class clientserverchat
{

        public static void main(String[] args) throws Exception
        {
                Socket s = new Socket("localhost",8000);
		while(true){
                InputStream in = s.getInputStream();
                BufferedReader br=new BufferedReader(new InputStreamReader(in));
                String str=br.readLine();
                System.out.println("Server--> " +str);
		// SENDING MESSAGE TO SERVER FROM CLIENT
		br=new BufferedReader(new InputStreamReader(System.in));
                OutputStream out = s.getOutputStream();
                PrintWriter pw = new PrintWriter(out,true);
                System.out.println("Enter message ");   //Communicate to Server
                str=br.readLine();
                pw.println(str);
		if (str.equals("close"))
			break;
	}
		s.close();
        }

}
