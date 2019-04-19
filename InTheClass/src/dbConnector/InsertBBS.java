package dbConnector;

import java.util.ArrayList;

public class InsertBBS { // 글쓰기 클릭하면
//	입력한 값 받아서 BBSDaoimpl로 넘김

	public void insertBBS() {
		BBSDto article = new BBSDto(); // 임의로 값을 넣음
		article.setID("humanarrayList");
		article.setTITLE("테스트arrayList");
		article.setCONTENT("공부해요arrayList");

		BBSDaoImpl.getDBObject().insertBBS(article);// insertBBS는

	}

	public void insertBBSAll() {
		ArrayList<BBSDto> articleList = new ArrayList<BBSDto>();

		BBSDto article;
		
		int i = 0;

		while (i < 1) {
			article = new BBSDto();; // 임의로 값을 넣음
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
