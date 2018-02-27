import java.io.*;
import java.net.*;
class server
{
	public static void main(String args[]) throws Exception
	{

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	DatagramSocket s = new DatagramSocket(5432);
	byte[] sendData = new byte[1024];
	String sentence;

	do{
		byte[] receiveData = new byte[1024];
		DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
		s.receive(receivePacket);
		sentence=new String (receivePacket.getData());
		System.out.println("CLIENT: "+sentence);
		InetAddress IPAddress =receivePacket.getAddress();
		int port = receivePacket.getPort();
		String reply = br.readLine();
		sendData = reply.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,port);
		s.send(sendPacket);
	}while(!sentence.equals("close"));
	}
}
