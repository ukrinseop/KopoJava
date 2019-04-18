package com.kopo.human;

public class StringBuilderTest {

	void test() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT *");
		sb.append("FROM BBS");
		sb.append("WHERE ID=?");
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) {
		StringBuilderTest sbt = new StringBuilderTest();
		sbt.test();
	}
	
	
}
