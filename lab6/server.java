import java.net.*;
import java.io.*;
class server implements Runnable{
	int clientnumber=0;
	Socket s[];
	String st="";
	Thread client[];
	ServerSocket ss;
	PrintWriter pr[];
	BufferedReader br[];
	public server() throws Exception{
		ss=new ServerSocket(6446);
		client=new Thread[20];
		pr=new PrintWriter[20];
		br= new BufferedReader[20];
		s=new Socket[20];
		while(true)
		{
			s[clientnumber]=ss.accept();
			client[clientnumber]=new Thread(this);
			br[clientnumber]=new BufferedReader(new InputStreamReader(s[clientnumber].getInputStream()));
			pr[clientnumber]=new PrintWriter(s[clientnumber].getOutputStream(),true);			
			client[clientnumber].start();
			clientnumber++;
		}
	}
	public void run()
		{
		try{
			for(int i=0;i<clientnumber;i++)
			{
				if(Thread.currentThread()==client[i])
				{	
					st="client["+i+"] says "+br[i].readLine();
					for(int j=0;j<clientnumber;j++)
					{
						if(i!=j)
						{
							pr[j].println(st);
						}
					}
				}
			}
		}catch(Exception e){System.out.println(e);}	
	}
	public static void main(String args[]) throws Exception{
		server start=new server();			
	}
}

