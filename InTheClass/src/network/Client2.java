package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client2 {
	public static void main(String[] args) {
		Client2 ci = new Client2();
	}

	Socket client;
	BufferedReader br;
	PrintWriter pw;

	public Client2() {
		connect();
	}

	public void connect() {
		try {
			System.out.println("�������� ������ �õ��մϴ�");
//			client = new Socket("172.16.144.50", 24244); // �ڱ��ڽ�
			client = new Socket("localhost", 23232);// �ڱ��ڽ�
			System.out.println("����Ǿ����ϴ�");

			br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			pw = new PrintWriter(client.getOutputStream(), true);
			pw.println("aaaaadddddcccc");
			
		} catch (Exception e) {
			System.out.println("�������");

		} finally {
			try {
				if (client != null)
					client.close();
			} catch (IOException ie) {
			}
		}
	}
}