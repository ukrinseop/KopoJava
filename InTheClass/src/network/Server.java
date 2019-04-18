package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception { // ���� main���� exception ó���ϸ� �ȵ�, jvm�� ó���ϰԵ�
		Server se = new Server();
		se.serverStart();
	}
	
	private ServerSocket ss;
	private java.net.Socket innerSocket; // ������ Socket innerSocket�̾����� ss.accept()�� ������
	private BufferedReader br;
	private BufferedWriter bw;
	private PrintWriter pw;

	public void serverStart() throws Exception { // �������� ����ó����
		ss = new ServerSocket(23232); // 22222�� ��Ʈ����
		System.out.println("���������� �����Ǿ����ϴ�");
		
		while(true) {
			System.out.println("Ŭ���̾�Ʈ�� ��ٸ��ϴ�");
			innerSocket = ss.accept(); // ��Ʈ�� ���ӵǸ� ���ο� ��Ʈ�� �Ҵ��ؼ� innerSocket���� �Ѱ���
			System.out.println("Ŭ���̾�Ʈ�� ����Ǿ����ϴ�");
			getMessage(innerSocket); // 
		}
	}



	private void getMessage(Socket innerSocket) throws Exception{ // ������ inputstream���� �ۿ� ������ ���ϹǷ� �� ���ξ� �д� buffered�� �ٲ������
		//�Է½�Ʈ��
//		InputStream is = innerSocket.getInputStream(); // Socket�� Input(Output)Stream�ۿ� ���� ���ϹǷ� (1byte)
//		InputStreamReader isr = new InputStreamReader(is); // BufferedReader�� 2byte�� �����. �׷��Ƿ� InputStreamReader�� 2byteó���� �ϰ�
//		br = new BufferedReader(isr); // �װ� buffered�� ����
		br = new BufferedReader(new InputStreamReader(innerSocket.getInputStream())); //�Ѵܰ�
		
		
		//��½�Ʈ���� �Է½�Ʈ���� �ݴ� 
//		bw = new BufferedWriter(new OutputStreamWriter(innerSocket.getOutputStream()));
//		bw.flush();???�� ��¼�� ���� �� �ľ���
		
		//��½�Ʈ��,, ���� BufferedWriter() method�� �����ܰ踦 ���ľ������� printWriter�� �ٷ� OutputStream�� ����������
		pw = new PrintWriter(innerSocket.getOutputStream(), true);
		//Outputsream�� �ٷ� ���� �� ����, �ι�°���ڴ� ture �ϸ� �ٷ� ���۵� autoflush()
		
		String temp = br.readLine();
		System.out.println("�����ʿ��� ���� ���ڿ��� Ŭ���̾�Ʈ�� ����մϴ� : ");
//		System.out.println(temp);
		pw.println(temp);
		
		if(br!=null) br.close();
		if(ss!=null) innerSocket.close();		
	}
}