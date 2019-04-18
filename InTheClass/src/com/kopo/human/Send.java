package com.kopo.human;

public class Send {
	int send;
	
	public Send(int send) {
		this.send = send;
	}
	
	public void send() {
		Receive re = new Receive();
		int result = re.receive(send);
		System.out.println(result);
	}
}
