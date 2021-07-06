package graph;

public class koDataVo {
	 String oneplu;
	 String onesum;
	 String twoplu;
	 String twosum;
	 String oneday;
	 String twoday;
	 
	public koDataVo(){}
	public koDataVo( String oneplu,String onesum,String twoplu,String twosum,String oneday,String twoday){
		this.oneplu = oneplu;
		this.onesum = onesum;
		this.twoplu = twoplu;
		this.twosum = twosum;
		this.oneday = oneday;
		this.twoday = twoday;
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
	public String getOneday() {
		return oneday;
	}
	public void setOneday(String oneday) {
		this.oneday = oneday;
	}
	public String getTwoday() {
		return twoday;
	}
	public void setTwoday(String twoday) {
		this.twoday = twoday;
	}
}
