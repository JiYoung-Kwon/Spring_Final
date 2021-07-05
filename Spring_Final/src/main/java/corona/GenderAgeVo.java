package corona;

public class GenderAgeVo {
	String stdDay; // 기준 날짜
	String gubun; // 구분(성별, 연령별)

	int confCase; // 확진자 수
	float confCaseRate; // 확진률
	int death; // 사망자 수
	float deathRate; // 사망률
	float criticalRate; // 치명률
	
	
	public String getStdDay() {
		return stdDay;
	}
	public void setStdDay(String stdDay) {
		this.stdDay = stdDay;
	}
	public String getGubun() {
		return gubun;
	}
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	public int getConfCase() {
		return confCase;
	}
	public void setConfCase(int confCase) {
		this.confCase = confCase;
	}
	public float getConfCaseRate() {
		return confCaseRate;
	}
	public void setConfCaseRate(float confCaseRate) {
		this.confCaseRate = confCaseRate;
	}
	public int getDeath() {
		return death;
	}
	public void setDeath(int death) {
		this.death = death;
	}
	public float getDeathRate() {
		return deathRate;
	}
	public void setDeathRate(float deathRate) {
		this.deathRate = deathRate;
	}
	public float getCriticalRate() {
		return criticalRate;
	}
	public void setCriticalRate(float criticalRate) {
		this.criticalRate = criticalRate;
	}

	
}
