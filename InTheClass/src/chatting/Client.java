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
			System.out.println("서버와의 연결을 시도합니다.");
//			client=new Socket("172.16.144.23", 24244);
//			client=new Socket("172.16.144.50", 24244);
			client=new Socket("localhost", 22222);
			System.out.println("연결되었습니다.");

			br=new BufferedReader(
					new InputStreamReader(
					client.getInputStream()));  //들어오는 stream     
			pw= new PrintWriter(
			client.getOutputStream() ,true);  //나가는 stream
			
			pw.println("뭐야 왜 안돼");	 
			
		}catch(Exception e){
			System.out.println("연결 실패.."); 
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
