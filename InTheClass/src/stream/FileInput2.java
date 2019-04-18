package stream;

import java.io.FileInputStream;

public class FileInput2 {
	public static void main(String[] args) {
		try {
			FileInputStream fs = new FileInputStream("c:/dev/git/kopo.Network/JavaStudy/src/stream/FileInput.java");
			
			int data;
			
			while( (data = fs.read()) != -1) {
				System.out.write(data);
				
			} 
			fs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
