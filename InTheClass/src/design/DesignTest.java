package design;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// j frame은 창모양을 지원해줌?
public class DesignTest extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6315886262190977301L;
	// 직렬화 - > 네트워크할때 생김 
	// DEsignTest의 노란 밑줄에 커서 갖다 대면 두번째꺼 선택
	
	private JButton east; // actionPerformed 메소드에서 가져다 쓰기 위함
	private JButton west;
	private JButton south;
	private JButton north;
	private JButton center;

	public DesignTest() {
		design();
	}
	
	public void design() {
		Container co = this.getContentPane(); // 디자인 영역
		east = new JButton("동"); // 버튼을 객체 만듦
		east.addActionListener(this);//액션리스터는 인터페이스,
		
		west = new JButton("서");
		west.addActionListener(this);
		
		south = new JButton("남");
		south.addActionListener(new South()); // this 대신 사용함, implement가 필요없고, override가 필요없음
		
		north = new JButton("북");
		
		center = new JButton("중");
		center.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("중앙은 익명클래스로 한다");
			}
		});
		
		co.add(east, BorderLayout.EAST); // 디자인 영역에 버튼 add시킴
		co.add(west, BorderLayout.WEST);
		co.add(south, BorderLayout.SOUTH);
		co.add(north, BorderLayout.NORTH);
		co.add(center, BorderLayout.CENTER); // 버튼을 클랙하면 actionEvent가 발생함, actionListner가 처리(인터페이스), actionPerfromed가처리 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==east) { //getSource는 이벤트를 발생시킨것의 주소?를 얻어옴
			System.out.println("east버튼이 클릭되었습니다");
		} else if (e.getSource()==west) {
			System.out.println("west버튼이 클릭되었습니다");
		}
	} 

	public static void main(String[] args) {
		DesignTest dt = new DesignTest();
		dt.setBounds(500, 500, 300, 400);
		dt.setVisible(true); // 눈에 보임
		
	}

}
