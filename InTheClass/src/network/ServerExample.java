package network;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(55555);
			while(true) {
				System.out.println("[서버가 연결을 기다립니다]");
				Socket socket = serverSocket.accept();
			}
		} catch (Exception e) {

		}
	}
}
