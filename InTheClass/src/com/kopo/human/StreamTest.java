package com.kopo.human;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class StreamTest {
	int temp = 0;

	public void test() { // 4623 밀리세컨
		try {
			FileInputStream fs = new FileInputStream("d:/a.txt"); // FileInputStream = 1byte씩 읽음

			long before = System.currentTimeMillis();
			while ((temp = fs.read()) != -1) {
				System.out.print((char) temp);
			}
			System.out.println();
			long amount = System.currentTimeMillis() - before;
			System.out.println("FileInputStream while문이 걸린시간" + amount);
			fs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void test1() { // 2576밀리세컨
		try {
			FileReader fr = new FileReader("d:/a.txt"); // FileReader = 2byte씩 읽음
			FileWriter fw = new FileWriter("d:/test1.txt");
			long before = System.currentTimeMillis();
			while ((temp = fr.read()) != -1) {
				System.out.print((char) temp);
				fw.write(temp);
			}
			System.out.println();
			long amount = System.currentTimeMillis() - before;			
			System.out.println("FileReader while문이 걸린시간" + amount);
			fr.close();
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void test2() {
		String tempStr;
		try {
			BufferedReader br = new BufferedReader(new FileReader("c:/dev/git/kopo.Network/JavaStudy/src/stream/FileInput.java"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("d:/test2.txt"));
			while ((tempStr = br.readLine()) != null) {
				System.out.println(tempStr);
				bw.write(tempStr + "\r\n");
			}
			br.close();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//

	public void test3() { // .close()를 안해도 자동닫힘
		String tempStr;
//		BufferedReader br = null; 1.9부터는 됨
//		BufferedWriter bw = null;

		try (BufferedReader br = new BufferedReader(new FileReader("d:/a.txt"));
			 BufferedWriter bw = new BufferedWriter(new FileWriter("d:/test3.txt"))) {
			while ((tempStr = br.readLine()) != null) {
				System.out.println(tempStr);
				bw.write(tempStr + "\r\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		StreamTest st = new StreamTest();
//		st.test();
//		st.test1();
		st.test2();
//		st.test3();
	}

}
