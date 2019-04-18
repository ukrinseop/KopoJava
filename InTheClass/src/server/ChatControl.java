package server;

import java.util.Vector;

public class ChatControl extends Vector<ChatThread> {

//	Vector<ChatThread> vc = new Vector<ChatThread>();
	
//	synchronized addChatThread(), removeChatThread(); sendAllmessage(),
	public synchronized void addChatThread(ChatThread ct) {
		this.add(ct);
		// extends가 아닐경우 vs를 만들어서 vs로.add로 함
	}

	public synchronized void removeChatThread(ChatThread ct) {
		if (this.contains(ct)) { // contains는 참조값비교
			this.remove(ct);
		}
	}

	public synchronized void sendAllmessage(String msg) { // ChatThread로부터 msg를 받으면
		for (ChatThread ct : this) { 
			ct.sendMessage(msg); // <vector>에 담겨있는것을 송출(동기화, arraylist대신 사용함)
		}
	}
}
