package design;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// j frame�� â����� ��������?
public class DesignTest extends JFrame implements ActionListener{
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

	public DesignTest() {
		design();
	}
	
	public void design() {
		Container co = this.getContentPane(); // ������ ����
		east = new JButton("��"); // ��ư�� ��ü ����
		east.addActionListener(this);//�׼Ǹ����ʹ� �������̽�,
		
		west = new JButton("��");
		west.addActionListener(this);
		
		south = new JButton("��");
		south.addActionListener(new South()); // this ��� �����, implement�� �ʿ����, override�� �ʿ����
		
		north = new JButton("��");
		
		center = new JButton("��");
		center.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�߾��� �͸�Ŭ������ �Ѵ�");
			}
		});
		
		co.add(east, BorderLayout.EAST); // ������ ������ ��ư add��Ŵ
		co.add(west, BorderLayout.WEST);
		co.add(south, BorderLayout.SOUTH);
		co.add(north, BorderLayout.NORTH);
		co.add(center, BorderLayout.CENTER); // ��ư�� Ŭ���ϸ� actionEvent�� �߻���, actionListner�� ó��(�������̽�), actionPerfromed��ó�� 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==east) { //getSource�� �̺�Ʈ�� �߻���Ų���� �ּ�?�� ����
			System.out.println("east��ư�� Ŭ���Ǿ����ϴ�");
		} else if (e.getSource()==west) {
			System.out.println("west��ư�� Ŭ���Ǿ����ϴ�");
		}
	} 

	public static void main(String[] args) {
		DesignTest dt = new DesignTest();
		dt.setBounds(500, 500, 300, 400);
		dt.setVisible(true); // ���� ����
		
	}

}
