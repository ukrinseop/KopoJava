package dbConnector;

import java.util.ArrayList;

public class InsertBBS { // �۾��� Ŭ���ϸ�
//	�Է��� �� �޾Ƽ� BBSDaoimpl�� �ѱ�

	public void insertBBS() {
		BBSDto article = new BBSDto(); // ���Ƿ� ���� ����
		article.setID("humanarrayList");
		article.setTITLE("�׽�ƮarrayList");
		article.setCONTENT("�����ؿ�arrayList");

		BBSDaoImpl.getDBObject().insertBBS(article);// insertBBS��

	}

	public void insertBBSAll() {
		ArrayList<BBSDto> articleList = new ArrayList<BBSDto>();

		BBSDto article;
		
		int i = 0;

		while (i < 1) {
			article = new BBSDto();; // ���Ƿ� ���� ����
			article.setID("bb");
			article.setTITLE("bb");
			article.setCONTENT("bb");
			articleList.add(article);
			i++;
		}
		
		BBSDaoImpl.getDBObject().insertBBSAll(articleList);
		
	}

	public static void main(String[] args) {
		InsertBBS ib = new InsertBBS();
//		ib.insertBBS();
		ib.insertBBSAll();
	}
}
