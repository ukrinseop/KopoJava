package chatting;
import java.io.*;
import java.net.*;
public class Server {
	private ServerSocket ss;
	private Socket innerSocket;
	private BufferedReader br;	
	private BufferedWriter bw;	
	private PrintWriter pw;	
	
	public void serverStart() throws Exception{		
		  ss=new ServerSocket(22222);
		  System.out.println("���������� �����Ǿ����ϴ�.");
	      while(true){
	        System.out.println("Ŭ���̾�Ʈ�� ��ٸ��ϴ�.");
	        innerSocket=ss.accept();
	        System.out.println("Ŭ���̾�Ʈ�� ����Ǿ����ϴ�.");
	        getMessage(innerSocket);
	      }
	}
	
	public void getMessage(Socket innerSocket)throws Exception{
//		�Է� ��Ʈ�� �����
//		InputStream is =innerSocket.getInputStream();
//		InputStreamReader isr = new InputStreamReader(is);
//		br = new BufferedReader(isr);	
		br=new BufferedReader(new InputStreamReader(innerSocket.getInputStream()));
		
//		��½�Ʈ��	
//		PrintWriter�� �ٷ� ����
		pw=new PrintWriter(innerSocket.getOutputStream(),true);
		
		
		String temp=br.readLine();
		System.out.println("�����ʿ��� Ŭ���̾�Ʈ�κ��� ���� ���ڿ� ��� "+temp);
//		pw.println(temp);
	
		if(br!=null) br.close();
		if(ss!=null) innerSocket.close();		
	}	
	
	public static void main(String[] args) throws Exception{
		Server se= new Server();
		se.serverStart();
	}
}
