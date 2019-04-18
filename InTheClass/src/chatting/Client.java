package chatting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client{	
	BufferedReader br;
	PrintWriter pw;
	Socket client;

	public Client(){
		connect();		
	}	

	public void connect(){		
		try{
			System.out.println("�������� ������ �õ��մϴ�.");
//			client=new Socket("172.16.144.23", 24244);
//			client=new Socket("172.16.144.50", 24244);
			client=new Socket("localhost", 22222);
			System.out.println("����Ǿ����ϴ�.");

			br=new BufferedReader(
					new InputStreamReader(
					client.getInputStream()));  //������ stream     
			pw= new PrintWriter(
			client.getOutputStream() ,true);  //������ stream
			
			pw.println("���� �� �ȵ�");	 
			
		}catch(Exception e){
			System.out.println("���� ����.."); 
		}finally{
			try{
				if(client!=null) client.close();
			}catch(IOException ie){}  
		}
	}			

	public static void main(String[] args){
		Client ci = new Client();
	}

}
