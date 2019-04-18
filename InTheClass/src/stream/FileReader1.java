package stream;

import java.io.FileReader;

public class FileReader1 {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("c:/dev/git/kopo.Network/JavaStudy/src/stream/FileInput.java");
			
			int data;
			
			while( (data = fr.read()) != -1) {
				System.out.write(data);
				
			}
			fr.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
