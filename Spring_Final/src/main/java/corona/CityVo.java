package corona;

public class CityVo {
	String stdDay; // 기준 날짜
	String stdTime; // 기준 시간
	
	String cityNm; // 시도명

	int defCnt; // 확진자 수
	int deathCnt; // 사망자 수
	int isolClearCnt; // 격리해제 수
	int isolIngCnt; // 격리중 수
	int incDec; // 전일대비 증감수
	float qurRate; // 10만명당 발생률
	int overFlowCnt; // 해외유입 수
	int localOccCnt; // 지역발생 수
	
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
	public String getCityNm() {
		return cityNm;
	}
	public void setCityNm(String cityNm) {
		this.cityNm = cityNm;
	}
	public int getDefCnt() {
		return defCnt;
	}
	public void setDefCnt(int defCnt) {
		this.defCnt = defCnt;
	}
	public int getDeathCnt() {
		return deathCnt;
	}
	public void setDeathCnt(int deathCnt) {
		this.deathCnt = deathCnt;
	}
	public int getIsolClearCnt() {
		return isolClearCnt;
	}
	public void setIsolClearCnt(int isolClearCnt) {
		this.isolClearCnt = isolClearCnt;
	}
	public int getIsolIngCnt() {
		return isolIngCnt;
	}
	public void setIsolIngCnt(int isolIngCnt) {
		this.isolIngCnt = isolIngCnt;
	}
	public int getIncDec() {
		return incDec;
	}
	public void setIncDec(int incDec) {
		this.incDec = incDec;
	}
	public float getQurRate() {
		return qurRate;
	}
	public void setQurRate(float qurRate) {
		this.qurRate = qurRate;
	}
	public int getOverFlowCnt() {
		return overFlowCnt;
	}
	public void setOverFlowCnt(int overFlowCnt) {
		this.overFlowCnt = overFlowCnt;
	}
	public int getLocalOccCnt() {
		return localOccCnt;
	}
	public void setLocalOccCnt(int localOccCnt) {
		this.localOccCnt = localOccCnt;
	}

}
  