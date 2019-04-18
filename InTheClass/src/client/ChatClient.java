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
	private JTextField chatField; // Runnable�� �׽�Ʈ�� ���� ������
	private JTextArea chatContent;
	private BufferedReader chatIn;
	private PrintWriter chatOut;
	private String nickName;
	private boolean flag = false;
	private Socket socket;

//	ChatClient(), design(), initNetwork(), run(), sendMessage(), actionPerformed(), stop();

	public ChatClient(String nickName) {
		super(nickName); // Jframe ��ӹ޾����Ƿ� ���ڿ��� �޴� Jframe�� � ���� ������ ǥ����
		this.nickName = nickName; // this�� ���� pravate String nickname�� ����
		this.addWindowListener(new WindowAdapter() { // this�� ActionListener�� ����  
			@Override // �����츮���� windowAdapter() ->
			//�����츮���ʴ� �������̽��� �� ���� 8�� �޼ҵ尡 �ִµ� ������
			//���� �������̵带 ����������� windowadapter�� ���� �ϳ��� �ص� ��
			public void windowClosing(WindowEvent e) { //â�� ������ Xǥ������ �߻�
				stop();
				System.exit(0); // Ŭ���̾�Ʈ ����
			}
		});
		design();
		initNetwork();
		new Thread(this).start(); // runnable�� ������ ChatClient�� ���ϴ� ��
	}

	public void design() {
		Container ca = this.getContentPane();
		JPanel southPanel = new JPanel();
		chatField = new JTextField(20); // �Է°����� ũ��
		chatField.addActionListener(this);
		JButton jb = new JButton("������");
		jb.addActionListener(this);
		
		//�г����� �ʵ�ø��� ������ ��ư�� �ø�

		southPanel.add(chatField);
		southPanel.add(jb);
		chatContent = new JTextArea(); // �������� �Է��Ҽ�����
		chatContent.setLineWrap(true); //�ڵ��ٹٲ�
		chatContent.setEditable(false); // Ÿ���α���

		ca.add(southPanel, BorderLayout.SOUTH);
		ca.add(new JScrollPane(chatContent), BorderLayout.CENTER);
	}

	public void initNetwork() {
		try {
			socket = new Socket("127.0.0.1", 23456);
			chatIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			chatOut = new PrintWriter(socket.getOutputStream(), true);
			sendMessage("[" + nickName + "]���� �����߽��ϴ�");
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
					chatContent.setCaretPosition(chatContent.getText().length()); //setCaretPosition�� ��ũ�ѹٰ� ������ ���󰡰� ����
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
	public void actionPerformed(ActionEvent e) { //�����⴩���� �׼��̺�Ʈ �޴� ��
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
		sendMessage("[" + nickName + "]:���� �����մϴ�");
		flag = true;
	}
}
