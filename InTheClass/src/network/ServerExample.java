package network;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(55555);
			while(true) {
				System.out.println("[������ ������ ��ٸ��ϴ�]");
				Socket socket = serverSocket.accept();
			}
		} catch (Exception e) {

		}
	}
}
