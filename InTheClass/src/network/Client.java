package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		Client ci = new Client();
	}

	Socket client;
	BufferedReader br;
	PrintWriter pw;

	public Client() {
		connect();
	}

	public void connect() {
		try {
			System.out.println("서버와의 연결을 시도합니다");
//			client = new Socket("172.16.144.50", 24244); // 자기자신
			client = new Socket("localhost", 23232);// 자기자신
			System.out.println("연결되었습니다");

			br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			pw = new PrintWriter(client.getOutputStream(), true);
			pw.println("aaaaadddddcccc");
			
		} catch (Exception e) {
			System.out.println("연결실패");

		} finally {
			try {
				if (client != null)
					client.close();
			} catch (IOException ie) {
			}
		}
	}
}