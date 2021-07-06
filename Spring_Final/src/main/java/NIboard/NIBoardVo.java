package NIboard;

public class NIBoardVo {
	int serial;
	int pserial;
	String mId;
	String mDate;
	String title;
	String doc;
	String oriAtt = "";
	String sysAtt = "";
	int hit;
	int rno;
	
	
	
	
	public int getSerial() {
		return serial;
	}
	public int getPserial() {
		return pserial;
	}
	public String getmId() {
		return mId;
	}
	public String getmDate() {
		return mDate;
	}
	public String getTitle() {
		return title;
	}
	public String getDoc() {
		return doc;
	}
	public int getHit() {
		return hit;
	}
	public void setSerial(int serial) {
		this.serial = serial;
	}
	public void setPserial(int pserial) {
		this.pserial = pserial;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public void setmDate(String mDate) {
		this.mDate = mDate;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDoc(String doc) {
		this.doc = doc;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getOriAtt() {
		return oriAtt;
	}
	public String getSysAtt() {
		return sysAtt;
	}
	public void setOriAtt(String oriAtt) {
		this.oriAtt = oriAtt;
	}
	public void setSysAtt(String sysAtt) {
		this.sysAtt = sysAtt;
	}
	
	
	
	
}
