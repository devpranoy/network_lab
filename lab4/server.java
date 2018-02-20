import java.net.*;
import java.io.*;
class server implements Runnable {
	String st="";
	Socket s;
	String str="";
	Thread t1;
	Thread t2;
	ServerSocket ss;
	BufferedReader br,sr;
	OutputStream out;
	PrintWriter pr; 	
	public server() throws Exception{
		t1= new Thread(this);		
		t2= new Thread(this);
		br=new BufferedReader(new InputStreamReader(System.in));
		ss=new ServerSocket(6446);
		s=ss.accept();
		sr=new BufferedReader(new InputStreamReader(s.getInputStream()));
		out=s.getOutputStream();
		pr=new PrintWriter(out,true);
		t1.start();
		t2.start();
	}
	public void run()
		{
		try{
			while(!st.equals("close") && !str.equals("close")){
			if (Thread.currentThread()==t1)
			{
				System.out.println("Enter the message :");
				st=br.readLine();
				pr.println(st);
				//Thread.sleep(100);
			}
			else if(Thread.currentThread()==t2)
			{
				str=sr.readLine();
				System.out.println("Client says : "+str);
				//Thread.sleep(100);	
			}
		}	
		s.close();
		}catch(Exception e){}	
	}

public static void main(String args[]){
	try{
	server c=new server();
	}catch(Exception e){}
	}

}
