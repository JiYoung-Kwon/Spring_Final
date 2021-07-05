package corona;

public class GlobalVo {
	String stdDay; // 기준 날짜
	String stdTime; // 기준 시간
	
	String areaNm; // 지역명
	String nationNm; // 국가명

	int natDefCnt; // 국가별 확진자 수
	int natDeathCnt; // 국가별 사망자 수
	float natDeathRate; // 확진률 대비 사망률
	public String getStdDay() {
		return stdDay;
	}
	public void setStdDay(String stdDay) {
		this.stdDay = stdDay;
	}
	public String getStdTime() {
		return stdTime;
	}
	public void setStdTime(String stdTime) {
		this.stdTime = stdTime;
	}
	public String getAreaNm() {
		return areaNm;
	}
	public void setAreaNm(String areaNm) {
		this.areaNm = areaNm;
	}
	public String getNationNm() {
		return nationNm;
	}
	public void setNationNm(String nationNm) {
		this.nationNm = nationNm;
	}
	public int getNatDefCnt() {
		return natDefCnt;
	}
	public void setNatDefCnt(int natDefCnt) {
		this.natDefCnt = natDefCnt;
	}
	public int getNatDeathCnt() {
		return natDeathCnt;
	}
	public void setNatDeathCnt(int natDeathCnt) {
		this.natDeathCnt = natDeathCnt;
	}
	public float getNatDeathRate() {
		return natDeathRate;
	}
	public void setNatDeathRate(float natDeathRate) {
		this.natDeathRate = natDeathRate;
	}
	
	
}
