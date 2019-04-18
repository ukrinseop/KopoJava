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
		  System.out.println("서버소켓이 생성되었습니다.");
	      while(true){
	        System.out.println("클라이언트를 기다립니다.");
	        innerSocket=ss.accept();
	        System.out.println("클라이언트와 연결되었습니다.");
	        getMessage(innerSocket);
	      }
	}
	
	public void getMessage(Socket innerSocket)throws Exception{
//		입력 스트림 만들기
//		InputStream is =innerSocket.getInputStream();
//		InputStreamReader isr = new InputStreamReader(is);
//		br = new BufferedReader(isr);	
		br=new BufferedReader(new InputStreamReader(innerSocket.getInputStream()));
		
//		출력스트림	
//		PrintWriter은 바로 전송
		pw=new PrintWriter(innerSocket.getOutputStream(),true);
		
		
		String temp=br.readLine();
		System.out.println("서버쪽에서 클라이언트로부터 받은 문자열 출력 "+temp);
//		pw.println(temp);
	
		if(br!=null) br.close();
		if(ss!=null) innerSocket.close();		
	}	
	
	public static void main(String[] args) throws Exception{
		Server se= new Server();
		se.serverStart();
	}
}
