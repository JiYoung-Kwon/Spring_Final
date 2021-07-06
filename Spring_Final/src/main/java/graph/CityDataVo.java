package graph;

public class CityDataVo {
	String num;
	String oneplu;
	String onesum;
	String twoplu;
	String twosum;
	
	public CityDataVo() {}
	public CityDataVo(String num,String oneplu,String onesum,String twoplu,String twosum) {
		this.num = num;
		this.oneplu = oneplu;
		this.onesum = onesum;
		this.twoplu = twoplu;
		this.twosum = twosum;
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getOneplu() {
		return oneplu;
	}
	public void setOneplu(String oneplu) {
		this.oneplu = oneplu;
	}
	public String getOnesum() {
		return onesum;
	}
	public void setOnesum(String onesum) {
		this.onesum = onesum;
	}
	public String getTwoplu() {
		return twoplu;
	}
	public void setTwoplu(String twoplu) {
		this.twoplu = twoplu;
	}
	public String getTwosum() {
		return twosum;
	}
	public void setTwosum(String twosum) {
		this.twosum = twosum;
	}

	
}
