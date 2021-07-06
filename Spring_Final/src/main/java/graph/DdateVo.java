package graph;

public class DdateVo {
	String Ddate;
	String name;
	public String getDdate() {
		return Ddate;
	}
	public void setDdate(String ddate) {
		Ddate = ddate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DdateVo() {}
	public DdateVo(String name,String Ddate) {
		this.name = name;
		this.Ddate = Ddate;
	}
}
