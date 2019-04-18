package design;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// j frame�� â����� ��������?
public class DesignTestEasyMode extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6315886262190977301L;
	// ����ȭ - > ��Ʈ��ũ�Ҷ� ���� 
	// DEsignTest�� ��� ���ٿ� Ŀ�� ���� ��� �ι�°�� ����
	
	private JButton east; // actionPerformed �޼ҵ忡�� ������ ���� ����
	private JButton west;
	private JButton south; 
	private JButton north;
	private JButton center;

	public DesignTestEasyMode() {
		design();
	}
	
	public void design() {
		Container co = this.getContentPane(); // ������ ����
		east = new JButton("��"); // ��ư�� ��ü ����
		east.addActionListener(new East());
		
		west = new JButton("��");
		west.addActionListener(new West());
		
		south = new JButton("��");
		south.addActionListener(new South()); // this ��� �����, implement�� �ʿ����, override�� �ʿ����
		
		north = new JButton("��");
		north.addActionListener(new North());
		
		center = new JButton("��");
		center.addActionListener(new Center());
		
		co.add(east, BorderLayout.EAST); // ������ ������ ��ư add��Ŵ
		co.add(west, BorderLayout.WEST);
		co.add(south, BorderLayout.SOUTH);
		co.add(north, BorderLayout.NORTH);
		co.add(center, BorderLayout.CENTER); // ��ư�� Ŭ���ϸ� actionEvent�� �߻���, actionListner�� ó��(�������̽�), actionPerfromed��ó�� 
	}

	public static void main(String[] args) {
		DesignTestEasyMode dt = new DesignTestEasyMode();
		dt.setBounds(500, 500, 300, 400);
		dt.setVisible(true); // ���� ����
		
	}

}
