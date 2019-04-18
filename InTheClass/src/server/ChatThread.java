package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ChatThread extends Thread { // initNetwork(채팅 내용을 In & Out), run(), sendMessage()
	private Socket socket;
	private BufferedReader chatIn;
	private PrintWriter chatOut;
	private boolean flag = false;

//	extends Thread / 상속받음 /
//	ChatThread(), initNetwork(), run(), sendMessage()

	public ChatThread(Socket socket) {
		this.socket = socket;
		initNetwork();
	}

	public void initNetwork() { // 채팅 내용을 In & Out 스트림 생성
		try {
			chatIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			chatOut = new PrintWriter(socket.getOutputStream(), true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() { // chatIn을 읽어서 msg에 저장. msg가 null이 아니고, ""이 아니면 this를 출력하고,
		try { // ChatserverMain.cct.sendAllmessage(msg)를 실행함
			while (!flag) {
				String msg = chatIn.readLine();
				if (msg != null && !msg.equals("")) {
					System.out.println(this);
					ChatServerMain.cct.sendAllmessage(msg); // cct -> ChatControl class에 있음
					if (msg.endsWith("]:님이 퇴장합니다 ")) { // 퇴장한다는 이야기가 있으면 this의 chatThread를 제거하라는뜻인듯
						ChatServerMain.cct.removeChatThread(this); // 그리고 나서 flag를 true
						flag = true;
					}
				} else {

				}
			}
			chatIn.close();
			chatOut.close();
			socket.close();
		} catch (Exception e) {
			ChatServerMain.cct.removeChatThread(this);
			try {
				if (chatIn != null)
					chatIn.close();
				if (chatOut != null)
					chatOut.close();
				if (socket != null)
					socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void sendMessage(String msg) { // msg를 chatOut
		chatOut.println(msg);
	}
}
