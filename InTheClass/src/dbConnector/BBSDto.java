package dbConnector;

import java.sql.Timestamp;

public class BBSDto { // 
	private int ARTICLENUM;
	private String ID;
	private String TITLE;
	private String CONTENT;
	private Timestamp WRITEDATE; // (java.sql)
	private String FNAME;
	
	public int getARTICLENUM() {
		return ARTICLENUM;
	}
	public void setARTICLENUM(int aRTICLENUM) {
		ARTICLENUM = aRTICLENUM;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}
	public Timestamp getWRITEDATE() {
		return WRITEDATE;
	}
	public void setWRITEDATE(Timestamp wRITEDATE) {
		WRITEDATE = wRITEDATE;
	}
	public String getFNAME() {
		return FNAME;
	}
	public void setFNAME(String fNAME) {
		FNAME = fNAME;
	}
	@Override
	public String toString() { // syso(BBSDto) 의 내용을 출력해줌
		return "BBSDto [ARTICLENUM=" + ARTICLENUM + ", ID=" + ID + ", TITLE=" + TITLE + ", CONTENT=" + CONTENT
				+ ", WRITEDATE=" + WRITEDATE + ", FNAME=" + FNAME + "]";
	}
	
	
	
	
	
}
