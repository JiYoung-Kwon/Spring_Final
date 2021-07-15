package account;

public class accountVo {
	int rno;
	String mid;
	String password;
	String newPwd;
	String mname;
	String mdate;
	String mjob;
	String mposition;
	
	public accountVo() {}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	public String getMjob() {
		return mjob;
	}

	public void setMjob(String mjob) {
		this.mjob = mjob;
	}

	public String getMposition() {
		return mposition;
	}

	public void setMposition(String mposition) {
		this.mposition = mposition;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	
	
}