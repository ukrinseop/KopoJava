package server;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServerMain {
	private Socket socket;
	private ServerSocket serverSocket;
	static ChatControl cct = new ChatControl();

	public void startServer() {
		try {
			serverSocket = new ServerSocket(23456);
			System.out.println("������ �����Ǿ����ϴ�. port number : 55555");
			while (true) {
				socket = serverSocket.accept();
				ChatThread ct = new ChatThread(socket);
				cct.addChatThread(ct); // ct�� vector�� add
				ct.start();
//				new Thread(ct).start(); ChatThread�� runnable�� �� �����ϴ� ���
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ChatServerMain csm = new ChatServerMain();
		csm.startServer();
	}
}