import java.io.*;
import java.net.*;
class client
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket s = new DatagramSocket();
		InetAddress IPAddress =InetAddress.getByName("localhost");
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
		String sentence;
		do
		{
			System.out.print("YOU:");
			sentence=br.readLine();
			sendData = sentence.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,5432);
			s.send(sendPacket);
			DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length,IPAddress,5432);
			s.receive(receivePacket);
			String modifiedSentence = new String(receivePacket.getData());
			System.out.println("Server: " + modifiedSentence); 
		
		}while(!sentence.equals("close"));
		s.close();
	}
}
