package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception { // 원래 main에서 exception 처리하면 안됨, jvm에 처리하게됨
		Server se = new Server();
		se.serverStart();
	}
	
	private ServerSocket ss;
	private java.net.Socket innerSocket; // 원래는 Socket innerSocket이었으나 ss.accept()가 오류남
	private BufferedReader br;
	private BufferedWriter bw;
	private PrintWriter pw;

	public void serverStart() throws Exception { // 메인으로 예외처리함
		ss = new ServerSocket(23232); // 22222번 포트생성
		System.out.println("서버소켓이 생성되었습니다");
		
		while(true) {
			System.out.println("클라이언트를 기다립니다");
			innerSocket = ss.accept(); // 포트에 접속되면 새로운 포트를 할당해서 innerSocket한테 넘겨줌
			System.out.println("클라이언트와 연결되었습니다");
			getMessage(innerSocket); // 
		}
	}



	private void getMessage(Socket innerSocket) throws Exception{ // 소켓은 inputstream으로 밖에 리턴을 안하므로 한 라인씩 읽는 buffered로 바꿔줘야함
		//입력스트림
//		InputStream is = innerSocket.getInputStream(); // Socket은 Input(Output)Stream밖에 지원 안하므로 (1byte)
//		InputStreamReader isr = new InputStreamReader(is); // BufferedReader는 2byte로 줘야함. 그러므로 InputStreamReader로 2byte처리를 하고
//		br = new BufferedReader(isr); // 그걸 buffered로 받음
		br = new BufferedReader(new InputStreamReader(innerSocket.getInputStream())); //한단계
		
		
		//출력스트림은 입력스트림의 반대 
//		bw = new BufferedWriter(new OutputStreamWriter(innerSocket.getOutputStream()));
//		bw.flush();???뭐 어쩌구 몇줄 더 쳐야함
		
		//출력스트림,, 위의 BufferedWriter() method는 여러단계를 거쳐야하지만 printWriter는 바로 OutputStream을 받을수있음
		pw = new PrintWriter(innerSocket.getOutputStream(), true);
		//Outputsream을 바로 받을 수 있음, 두번째인자는 ture 하면 바로 전송됨 autoflush()
		
		String temp = br.readLine();
		System.out.println("서버쪽에서 받은 문자열을 클라이언트로 출력합니다 : ");
//		System.out.println(temp);
		pw.println(temp);
		
		if(br!=null) br.close();
		if(ss!=null) innerSocket.close();		
	}
}