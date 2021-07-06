package sanghwal;

import java.util.List;

public class sanghwalVo {
	int serial;
	int pSerial;
	int hit;
	
	String mId="";
	String title="";
	String doc="";
	String mdate="";
	
	List<sanghwalAttVo> attList;
	List<sanghwalAttVo> delList;
	
	
	
	public List<sanghwalAttVo> getAttList() {
		return attList;
	}
	public void setAttList(List<sanghwalAttVo> attList) {
		this.attList = attList;
	}
	public List<sanghwalAttVo> getDelList() {
		return delList;
	}
	public void setDelList(List<sanghwalAttVo> delList) {
		this.delList = delList;
	}
	
	public int getSerial() {
		return serial;
	}
	public void setSerial(int serial) {
		this.serial = serial;
	}
	public int getpSerial() {
		return pSerial;
	}
	public void setpSerial(int pSerial) {
		this.pSerial = pSerial;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDoc() {
		return doc;
	}
	public void setDoc(String doc) {
		this.doc = doc;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	
	
}
