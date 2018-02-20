import java.net.*;
import java.io.*;
class server implements Runnable{
	int clientnumber=0;
	Socket s[]=new Socket[20];
	String st="";
	Thread addclient;
	public static ServerSocket ss;
	PrintWriter pr;
	OutputStream out[]=new OutputStream[20];
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public server() throws Exception{
		Thread t;
		t=new Thread(this);
		addclient=new Thread(this);
		t.start();
		addclient.start();
	}
	public void run()
		{
		try{
			if(Thread.currentThread()==addclient)
			{	while(true){
					s[clientnumber]=ss.accept();
					clientnumber++;
				}
			}
			else{
				while(!st.equals("close")){
				System.out.println("Enter the broadcast message :");
				String st=br.readLine();
				for(int j=0;j<clientnumber;j++)
				{	
					out[j]=s[j].getOutputStream();					
					pr=new PrintWriter(out[j],true);
					pr.println(st);
				}
				}
			}	
		//s[clientnumber].close();
		}catch(Exception e){}	
	}
	public static void main(String args[]) throws Exception{
		ss=new ServerSocket(8769);
		server start=new server();			
	}
}

