import java.io.*;
import java.net.*;

class client
{

        public static void main(String[] args) throws Exception
        {
                Socket s = new Socket("localhost",8000);
                InputStream in = s.getInputStream();
                BufferedReader br=new BufferedReader(new InputStreamReader(in));
                String str=br.readLine();
                System.out.println("Server Response is " +str);
                s.close();
        }

}
