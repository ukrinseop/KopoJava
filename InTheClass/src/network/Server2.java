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
		System.out.println("���������� �����Ǿ����ϴ�");
		
		while(true) {
			System.out.println("Ŭ���̾�Ʈ�� ��ٸ��ϴ�");
			innerSocket = ss.accept();
			System.out.println("Ŭ���̾�Ʈ�� ����Ǿ����ϴ�");
			getMessage(innerSocket); // 
		}
	}



	private void getMessage(Socket innerSocket) throws Exception{
		//�Է½�Ʈ��
//		InputStream is = innerSocket.getInputStream();
//		InputStreamReader isr = new InputStreamReader(is);
//		br = new BufferedReader(isr);
		br = new BufferedReader(new InputStreamReader(innerSocket.getInputStream()));
//		bw = new BufferedWriter(new OutputStreamWriter(innerSocket.getOutputStream()));
		pw = new PrintWriter(innerSocket.getOutputStream(), true);
		
		String temp = br.readLine();
		System.out.println("�����ʿ��� ���� ���ڿ��� Ŭ���̾�Ʈ�� ����մϴ� : ");
		pw.println(temp);
		
		if(br!=null) br.close();
		if(ss!=null) innerSocket.close();		
	}
}