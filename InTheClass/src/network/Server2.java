package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
	public static void main(String[] args) throws Exception {
		Server2 se = new Server2();
		se.serverStart();
	}
	
	private java.net.ServerSocket ss;
	private java.net.Socket innerSocket;
	private BufferedReader br;
	private BufferedWriter bw;
	private PrintWriter pw;

	public void serverStart() throws Exception {
		ss = new ServerSocket(23232);
		System.out.println("서버소켓이 생성되었습니다");
		
		while(true) {
			System.out.println("클라이언트를 기다립니다");
			innerSocket = ss.accept();
			System.out.println("클라이언트와 연결되었습니다");
			getMessage(innerSocket); // 
		}
	}



	private void getMessage(Socket innerSocket) throws Exception{
		//입력스트림
//		InputStream is = innerSocket.getInputStream();
//		InputStreamReader isr = new InputStreamReader(is);
//		br = new BufferedReader(isr);
		br = new BufferedReader(new InputStreamReader(innerSocket.getInputStream()));
//		bw = new BufferedWriter(new OutputStreamWriter(innerSocket.getOutputStream()));
		pw = new PrintWriter(innerSocket.getOutputStream(), true);
		
		String temp = br.readLine();
		System.out.println("서버쪽에서 받은 문자열을 클라이언트로 출력합니다 : ");
		pw.println(temp);
		
		if(br!=null) br.close();
		if(ss!=null) innerSocket.close();		
	}
}