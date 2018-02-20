import java.net.*;
import java.io.*;
class client implements Runnable{
	String st="";
	Socket ss;
	String str="";
	Thread t1;
	Thread t2;
	BufferedReader br,sr;
	OutputStream out;
	PrintWriter pr; 
	public client(){
		try{
		t1= new Thread(this);		
		t2= new Thread(this);		
		ss=new Socket("localhost",6446);			
		br=new BufferedReader(new InputStreamReader(ss.getInputStream()));
		sr=new BufferedReader(new InputStreamReader(System.in));
		out=ss.getOutputStream();
		pr=new PrintWriter(out,true);		
		t1.start();
		t2.start();
		}catch(Exception e){System.out.println("exception in client run :"+e);}
	}
	public void run()
		{
		try{
		while(!str.equals("close") && !st.equals("close")){
		if (Thread.currentThread()==t1)
			{
				//read message 
				st=br.readLine();
				System.out.println(st);
			}
		else if(Thread.currentThread()==t2)
			{
				//write message
				System.out.println("Enter your message :");
				str=sr.readLine();
				pr.println(str);	
			}}ss.close();
		}catch(Exception e){System.out.println("exception in client run :"+e);}
	}
	public static void main(String args[]) throws Exception
	{
		try{
		client c=new client();
		}catch(Exception e){System.out.println("exception in main: "+e);}
		}

}

