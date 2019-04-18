package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ChatThread extends Thread { // initNetwork(ä�� ������ In & Out), run(), sendMessage()
	private Socket socket;
	private BufferedReader chatIn;
	private PrintWriter chatOut;
	private boolean flag = false;

//	extends Thread / ��ӹ��� /
//	ChatThread(), initNetwork(), run(), sendMessage()

	public ChatThread(Socket socket) {
		this.socket = socket;
		initNetwork();
	}

	public void initNetwork() { // ä�� ������ In & Out ��Ʈ�� ����
		try {
			chatIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			chatOut = new PrintWriter(socket.getOutputStream(), true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() { // chatIn�� �о msg�� ����. msg�� null�� �ƴϰ�, ""�� �ƴϸ� this�� ����ϰ�,
		try { // ChatserverMain.cct.sendAllmessage(msg)�� ������
			while (!flag) {
				String msg = chatIn.readLine();
				if (msg != null && !msg.equals("")) {
					System.out.println(this);
					ChatServerMain.cct.sendAllmessage(msg); // cct -> ChatControl class�� ����
					if (msg.endsWith("]:���� �����մϴ� ")) { // �����Ѵٴ� �̾߱Ⱑ ������ this�� chatThread�� �����϶�¶��ε�
						ChatServerMain.cct.removeChatThread(this); // �׸��� ���� flag�� true
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

	public void sendMessage(String msg) { // msg�� chatOut
		chatOut.println(msg);
	}
}
