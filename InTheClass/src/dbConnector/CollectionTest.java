package dbConnector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CollectionTest {
	
	public void testArrayList(){
		//jdk1.6까지의 사용법
//		ArrayList<Mp3> al = new ArrayList<Mp3>();
		//jdk 1.7부터는 아래와 같이 사용가능
		ArrayList<Elec> al = new ArrayList<>();
		ArrayList<Integer> al1 = new ArrayList<>();
		Mp3 m = new Mp3();
		Mp3 n = new Mp3();
		al.add(m);
		al.add(new Radio());
		al.add(new Tv());		
		for(Elec temp:al) {
			temp.volumeUp();
			temp.volumeDown();			
		}			
		if(al.contains(m)) {
			System.out.println("해당객체는 있습니다");			
		}		
		if(al.contains(n)) {
			System.out.println("1: 해당객체는 있습니다");			
		}else {
			System.out.println("2 :해당객체는 없습니다");
		}
	}
	
	public void testHashMapList() {
		HashMap<String, Elec> hm = new HashMap<>();
		hm.put("1st", new Mp3());
		hm.put("2st", new Radio());
		hm.put("3st", new Tv());
		hm.put("4st", new Elec() {
			@Override
			public void volumeUp() {
				System.out.println("Cell의 볼륨업");
			}
			@Override
			public void volumeDown() {
				System.out.println("Cell의 볼륨다운");				
			}			
		});
		
		System.out.println(hm);
		System.out.println("toString 메소드 : "+new Mp3());
		
		//key값만 출력
		Set<String> ss=hm.keySet();
		for(String temp: ss) {
			System.out.println(temp);
		}
		
		//value값만 출력
		Collection<Elec> co=hm.values();
		for(Elec temp: co) {
			temp.volumeDown();
			temp.volumeUp();
		}
		
		//key와 value 출력
		Set<String> ss1=hm.keySet();
		for(String temp: ss1) {
			System.out.print("키 값은  :"+temp+" ");
			System.out.println("value 값은  :"+hm.get(temp));
		}
		
//		entrySet()을 이용하여 key와 value를 같이 가져옴
		Set<Map.Entry<String, Elec>> es=hm.entrySet();
		for(Map.Entry<String, Elec> entry:es) {
			System.out.println("키값은 :"+entry.getKey());
			System.out.println("value값은 :"+entry.getValue());
			
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		CollectionTest colt = new CollectionTest();
//		colt.testArrayList();
		colt.testHashMapList();
	}

}
