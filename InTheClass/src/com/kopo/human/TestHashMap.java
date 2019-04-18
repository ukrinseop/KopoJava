package com.kopo.human;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import testing.Elec;
import testing.Mp3;
import testing.Tv;
import testing.Radio;

public class TestHashMap {
	public static void main(String[] args) {
		testHashMap();
	}
	
	public static void testHashMap() {
		HashMap<String, Elec> hm = new HashMap<String, Elec>();
		hm.put("1st", new Mp3());
		hm.put("2st", new Tv());
		hm.put("3st", new Radio());
		System.out.println("hm을 출력하면 hashmap instance의 주소가 나타납니다");
		System.out.println(hm);
		System.out.println();
		
		System.out.println("key를 출력하려면 .keySet()을 사용합니다");
		Set<String> set = hm.keySet();
		for (String temp : set) {
			System.out.println(temp);
		}
		System.out.println();
		
		System.out.println("value를 출력하려면 .values()를 사용합니다");
		Collection<Elec> co = hm.values();
		for (Elec temp : co) {
			temp.volumeUp();
			temp.volumeDown();
		}
	}
}
