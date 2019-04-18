package stream;

import java.io.FileInputStream;

public class FileInput {
	public static void main(String[] args) {
		
		try {
			FileInputStream fs1 = new FileInputStream("d:/a.txt");
			int temp1 = fs1.read();
			System.out.println((char) temp1 );
			int temp2 = fs1.read();
			System.out.println((char) temp2 );
			int temp3 = fs1.read();
			System.out.println((char) temp3 );
			fs1.close();
			System.out.println("---- fs1 ----");
			System.out.println();
			
			FileInputStream fs2 = new FileInputStream("d:/a.txt");
			int temp = 0;
			while ((temp = fs2.read()) != -1) {
				System.out.print((char) temp);
			}
			fs2.close();
			
		} catch (Exception e) {

		}
	}
}
