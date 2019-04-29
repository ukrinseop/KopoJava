package web_crawling;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class PloyTech_01 {

	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("http://news.naver.com/").get();

		/*
		 * doc.select(".main_hotissu"); // class = "main_hotissu", element 반환, 결과 값이 1개
		 * 일 때 doc.select("#main"); // id = "main" doc.select(".main_hotissu a"); //
		 * class = "main_hotissu"에서 <a> 파싱 doc.select(".main_hotissu").get(0); //
		 * Elements 반환, 파싱한 태그의 결과 값이 여러개일때 사용
		 */

//		Element.toString()
		Document doc = Jsoup.connect("http://news.naver.com/").get();
		Element hotNews = doc.select("ul.mlist2").get(0);
		System.out.println(hotNews.toString());
		
		/*
		 * 실행결과 <ul> 태그 Element 한개, 파싱한 값 전체가 반환된다.

<ul class="mlist2"> 

     <li> <a href="http://news.naver.com/main/hotissue/sectionList.nhn?mid=hot&amp;sid1=100&amp;cid=1064070&amp;iid=26055409&amp;ptype=1064256#1064256" class="nclicks(hot.text)" title="[이낙연 총리후보자 인준은]
    한국당 &quot;丁의장 방문..이낙연 인준안 상정 철회 요구할 것&quot;">[이낙연 총리후보자 인준은] 한국당 "丁의장 방문..이낙연 인준안 상...</a><img src="http://static.news.naver.net/image/news/2009/ico_photo.gif" width="13" height="13" alt="포토" title="포토"><span class="writing">이데일리</span> </li> 
     <li> <a href="http://news.naver.com/main/hotissue/sectionList.nhn?mid=hot&amp;sid1=100&amp;cid=1064070&amp;iid=2133041&amp;ptype=1064968#1064968" class="nclicks(hot.text)" title="['문재인 대통령' 행보]
    文대통령 &quot;재조해양&quot;..'세월호' '새만금' '해운산업' 강조">['문재인 대통령' 행보] 文대통령 "재조해양"..'세월호' '새만금' '해운산업...</a><span class="writing">이데일리</span> </li> 
     <li> <a href="http://news.naver.com/main/hotissue/sectionList.nhn?mid=hot&amp;sid1=100&amp;cid=1064070&amp;iid=49397904&amp;ptype=1064407#1064407" class="nclicks(hot.text)" title="['文 정부' 국정기획자문위]
    국정기획위 &quot;국정원에 철저한 개혁 주문…의지 확인&quot; (종합2보)">['文 정부' 국정기획자문위] 국정기획위 "국정원에 철저한 개혁 주문...</a><img src="http://static.news.naver.net/image/news/2009/ico_photo.gif" width="13" height="13" alt="포토" title="포토"><span class="writing">뉴스1</span> </li> 
     <li> <a href="http://news.naver.com/main/hotissue/sectionList.nhn?mid=hot&amp;sid1=100&amp;cid=1064070&amp;iid=24864819&amp;ptype=1064552#1064552" class="nclicks(hot.text)" title="['인사청문·검증' 본격화]
    김동연 경제부총리 후보자 인사청문회 6월 7일 실시">['인사청문·검증' 본격화] 김동연 경제부총리 후보자 인사청문회 6...</a><img src="http://static.news.naver.net/image/news/2009/ico_photo.gif" width="13" height="13" alt="포토" title="포토"><span class="writing">뉴스1</span> </li> 
     <li> <a href="http://news.naver.com/main/hotissue/sectionList.nhn?mid=hot&amp;sid1=100&amp;cid=1064070&amp;iid=49513458&amp;ptype=1065003#1065003" class="nclicks(hot.text)" title="[文대통령, 장관 후보자 4명 발표]
    '의원 4명' 장관 발탁… 인사 암초 정면 돌파">[文대통령, 장관 후보자 4명 발표] '의원 4명' 장관 발탁… 인사 암초...</a><img src="http://static.news.naver.net/image/news/2009/ico_photo.gif" width="13" height="13" alt="포토" title="포토"><span class="writing">서울신문</span> </li> 
</ul> 
		 * */
		
		

//		Element.text()
		Document doc = Jsoup.connect("http://news.naver.com/").get();
		Element hotNews = doc.select("ul.mlist2").get(0);
		Elements news = hotNews.select("li");
		
		for (Element e : news) {
			System.out.println(e.text());
		}	
		System.out.println(e.getElementsByAttribute("href").attr("href"));
		
		/*
		 * 실행결과 : 핫 뉴스 부분의 제목만 파싱한 결과

[이낙연 총리후보자 인준은] '이낙연 인준' 국회 본회의 지연…한국당...뉴스1

['文 정부' 차관 인선] 文정부 첫 차관 인선…기재·교육·국토·외교...뉴스1

['문재인 대통령' 행보] 文대통령 "재조해양"..'세월호' '새만금' '해운산업...이데일리

['文 정부' 국정기획자문위] 국정기획위 "국정원에 철저한 개혁 주문...뉴스1

['인사청문·검증' 본격화] 김동연·강경화 인사청문회, 내달 7일 ...머니투데이
		 * 
		 * 
		 * */
		
		
		
	}
}
