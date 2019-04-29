package web_crawling;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class PloyTech_01 {

	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("http://news.naver.com/").get();

		/*
		 * doc.select(".main_hotissu"); // class = "main_hotissu", element ��ȯ, ��� ���� 1��
		 * �� �� doc.select("#main"); // id = "main" doc.select(".main_hotissu a"); //
		 * class = "main_hotissu"���� <a> �Ľ� doc.select(".main_hotissu").get(0); //
		 * Elements ��ȯ, �Ľ��� �±��� ��� ���� �������϶� ���
		 */

//		Element.toString()
		Document doc = Jsoup.connect("http://news.naver.com/").get();
		Element hotNews = doc.select("ul.mlist2").get(0);
		System.out.println(hotNews.toString());
		
		/*
		 * ������ <ul> �±� Element �Ѱ�, �Ľ��� �� ��ü�� ��ȯ�ȴ�.

<ul class="mlist2"> 

     <li> <a href="http://news.naver.com/main/hotissue/sectionList.nhn?mid=hot&amp;sid1=100&amp;cid=1064070&amp;iid=26055409&amp;ptype=1064256#1064256" class="nclicks(hot.text)" title="[�̳��� �Ѹ��ĺ��� ������]
    �ѱ��� &quot;������ �湮..�̳��� ���ؾ� ���� öȸ �䱸�� ��&quot;">[�̳��� �Ѹ��ĺ��� ������] �ѱ��� "������ �湮..�̳��� ���ؾ� ��...</a><img src="http://static.news.naver.net/image/news/2009/ico_photo.gif" width="13" height="13" alt="����" title="����"><span class="writing">�̵��ϸ�</span> </li> 
     <li> <a href="http://news.naver.com/main/hotissue/sectionList.nhn?mid=hot&amp;sid1=100&amp;cid=1064070&amp;iid=2133041&amp;ptype=1064968#1064968" class="nclicks(hot.text)" title="['������ �����' �ຸ]
    ������� &quot;�����ؾ�&quot;..'����ȣ' '������' '�ؿ���' ����">['������ �����' �ຸ] ������� "�����ؾ�"..'����ȣ' '������' '�ؿ���...</a><span class="writing">�̵��ϸ�</span> </li> 
     <li> <a href="http://news.naver.com/main/hotissue/sectionList.nhn?mid=hot&amp;sid1=100&amp;cid=1064070&amp;iid=49397904&amp;ptype=1064407#1064407" class="nclicks(hot.text)" title="['�� ����' ������ȹ�ڹ���]
    ������ȹ�� &quot;�������� ö���� ���� �ֹ������� Ȯ��&quot; (����2��)">['�� ����' ������ȹ�ڹ���] ������ȹ�� "�������� ö���� ���� �ֹ�...</a><img src="http://static.news.naver.net/image/news/2009/ico_photo.gif" width="13" height="13" alt="����" title="����"><span class="writing">����1</span> </li> 
     <li> <a href="http://news.naver.com/main/hotissue/sectionList.nhn?mid=hot&amp;sid1=100&amp;cid=1064070&amp;iid=24864819&amp;ptype=1064552#1064552" class="nclicks(hot.text)" title="['�λ�û��������' ����ȭ]
    �赿�� �������Ѹ� �ĺ��� �λ�û��ȸ 6�� 7�� �ǽ�">['�λ�û��������' ����ȭ] �赿�� �������Ѹ� �ĺ��� �λ�û��ȸ 6...</a><img src="http://static.news.naver.net/image/news/2009/ico_photo.gif" width="13" height="13" alt="����" title="����"><span class="writing">����1</span> </li> 
     <li> <a href="http://news.naver.com/main/hotissue/sectionList.nhn?mid=hot&amp;sid1=100&amp;cid=1064070&amp;iid=49513458&amp;ptype=1065003#1065003" class="nclicks(hot.text)" title="[�������, ��� �ĺ��� 4�� ��ǥ]
    '�ǿ� 4��' ��� ��Ź�� �λ� ���� ���� ����">[�������, ��� �ĺ��� 4�� ��ǥ] '�ǿ� 4��' ��� ��Ź�� �λ� ����...</a><img src="http://static.news.naver.net/image/news/2009/ico_photo.gif" width="13" height="13" alt="����" title="����"><span class="writing">����Ź�</span> </li> 
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
		 * ������ : �� ���� �κ��� ���� �Ľ��� ���

[�̳��� �Ѹ��ĺ��� ������] '�̳��� ����' ��ȸ ��ȸ�� �������ѱ���...����1

['�� ����' ���� �μ�] ������ ù ���� �μ������硤���������䡤�ܱ�...����1

['������ �����' �ຸ] ������� "�����ؾ�"..'����ȣ' '������' '�ؿ���...�̵��ϸ�

['�� ����' ������ȹ�ڹ���] ������ȹ�� "�������� ö���� ���� �ֹ�...����1

['�λ�û��������' ����ȭ] �赿��������ȭ �λ�û��ȸ, ���� 7�� ...�Ӵ�������
		 * 
		 * 
		 * */
		
		
		
	}
}
