import java.io.*;
import java.net.*;

class clientserver
{

        public static void main(String[] args) throws Exception
        {
                Socket s = new Socket("localhost",8000);
		String str="";
		while(true){
		// SENDING MESSAGE TO SERVER FROM CLIENT
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		br=new BufferedReader(new InputStreamReader(System.in));
                OutputStream out = s.getOutputStream();
                PrintWriter pw = new PrintWriter(out,true);
                System.out.println("Enter message ");   //Communicate to Server
                str=br.readLine();
                pw.println(str);
		if(str.equals("close"))
			break;
		}
		s.close();
        }

}
