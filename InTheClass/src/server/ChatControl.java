package server;

import java.util.Vector;

public class ChatControl extends Vector<ChatThread> {

//	Vector<ChatThread> vc = new Vector<ChatThread>();
	
//	synchronized addChatThread(), removeChatThread(); sendAllmessage(),
	public synchronized void addChatThread(ChatThread ct) {
		this.add(ct);
		// extends�� �ƴҰ�� vs�� ���� vs��.add�� ��
	}

	public synchronized void removeChatThread(ChatThread ct) {
		if (this.contains(ct)) { // contains�� ��������
			this.remove(ct);
		}
	}

	public synchronized void sendAllmessage(String msg) { // ChatThread�κ��� msg�� ������
		for (ChatThread ct : this) { 
			ct.sendMessage(msg); // <vector>�� ����ִ°��� ����(����ȭ, arraylist��� �����)
		}
	}
}
