package notice;

public class NoticeVo {
	int rno;
	int serial;
	String title;
	String mid;
	String mdate;
	int hit;
	String doc;
	
	public NoticeVo() {}
	public NoticeVo(String title, String mid, String mdate, int hit, String doc) {
		this.title = title;
		this.mid = mid;
		this.mdate = mdate;
		this.hit = hit;
		this.doc = doc;
	}
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getSerial() {
		return serial;
	}
	public void setSerial(int serial) {
		this.serial = serial;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getDoc() {
		return doc;
	}
	public void setDoc(String doc) {
		this.doc = doc;
	}
}