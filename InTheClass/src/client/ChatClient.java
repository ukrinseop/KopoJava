package client;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener, Runnable {
	private JTextField chatField; // Runnable은 테스트를 위해 구현함
	private JTextArea chatContent;
	private BufferedReader chatIn;
	private PrintWriter chatOut;
	private String nickName;
	private boolean flag = false;
	private Socket socket;

//	ChatClient(), design(), initNetwork(), run(), sendMessage(), actionPerformed(), stop();

	public ChatClient(String nickName) {
		super(nickName); // Jframe 상속받았으므로 문자열을 받는 Jframe의 어떤 것이 제목을 표시함
		this.nickName = nickName; // this는 위의 pravate String nickname을 뜻함
		this.addWindowListener(new WindowAdapter() { // this는 ActionListener를 뜻함  
			@Override // 윈도우리스너 windowAdapter() ->
			//윈도우리스너는 인터페이스고 그 밑의 8개 메소드가 있는데 원래는
			//전부 오버라이드를 해줘야하지만 windowadapter가 오면 하나만 해도 됨
			public void windowClosing(WindowEvent e) { //창이 닫히는 X표누르면 발생
				stop();
				System.exit(0); // 클라이언트 종료
			}
		});
		design();
		initNetwork();
		new Thread(this).start(); // runnable을 구현한 ChatClient를 말하는 듯
	}

	public void design() {
		Container ca = this.getContentPane();
		JPanel southPanel = new JPanel();
		chatField = new JTextField(20); // 입력공간의 크기
		chatField.addActionListener(this);
		JButton jb = new JButton("보내기");
		jb.addActionListener(this);
		
		//패널위에 필드올리고 그위에 버튼을 올림

		southPanel.add(chatField);
		southPanel.add(jb);
		chatContent = new JTextArea(); // 여러줄을 입력할수있음
		chatContent.setLineWrap(true); //자동줄바꿈
		chatContent.setEditable(false); // 타이핑금지

		ca.add(southPanel, BorderLayout.SOUTH);
		ca.add(new JScrollPane(chatContent), BorderLayout.CENTER);
	}

	public void initNetwork() {
		try {
			socket = new Socket("127.0.0.1", 23456);
			chatIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			chatOut = new PrintWriter(socket.getOutputStream(), true);
			sendMessage("[" + nickName + "]님이 입장했습니다");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			while (!flag) {
				String msg = chatIn.readLine();
				if (msg != null && !msg.equals("")) {
					chatContent.append(msg + "\n"); // JTextArea = chatContent
					chatContent.setCaretPosition(chatContent.getText().length()); //setCaretPosition은 스크롤바가 밑으로 따라가게 해줌
				} else {
					stop();
				}
			}
			chatIn.close();
			chatOut.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) { //보내기누르면 액션이벤트 받는 곳
		String message = chatField.getText();
		if (!message.equals("")) {
			sendMessage("[" + nickName + "]" + message);
			chatField.setText("");
		}
	}

	public void sendMessage(String message) {
		chatOut.println(message);
	}

	public void stop() {
		sendMessage("[" + nickName + "]:님이 퇴장합니다");
		flag = true;
	}
}
