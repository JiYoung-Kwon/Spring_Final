package corona;

public class KoreaVo {
	String stdDay; // 기준 날짜
	String stdTime; // 기준 시간

	int decideCnt; // 확진자 수
	int clearCnt;// 격리해제 수
	int examCnt;// 검사진행 수
	int deathCnt;// 사망자 수
	int careCnt;// 격리중 수
	int resultNegCnt; // 결과 음성 수
	int accExamCompCnt; // 누적 검사 수
	float accDefRate;// 누적 확진율
	
	int todayDecide; // 일일 확진자 수
	int todayClear; // 일일 격리해제 수
	int todayCare; // 일일 격리중 수
	int todayDeath; // 일일 사망자 수
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
	public int getDecideCnt() {
		return decideCnt;
	}
	public void setDecideCnt(int decideCnt) {
		this.decideCnt = decideCnt;
	}
	public int getClearCnt() {
		return clearCnt;
	}
	public void setClearCnt(int clearCnt) {
		this.clearCnt = clearCnt;
	}
	public int getExamCnt() {
		return examCnt;
	}
	public void setExamCnt(int examCnt) {
		this.examCnt = examCnt;
	}
	public int getDeathCnt() {
		return deathCnt;
	}
	public void setDeathCnt(int deathCnt) {
		this.deathCnt = deathCnt;
	}
	public int getCareCnt() {
		return careCnt;
	}
	public void setCareCnt(int careCnt) {
		this.careCnt = careCnt;
	}
	public int getResultNegCnt() {
		return resultNegCnt;
	}
	public void setResultNegCnt(int resultNegCnt) {
		this.resultNegCnt = resultNegCnt;
	}
	public int getAccExamCompCnt() {
		return accExamCompCnt;
	}
	public void setAccExamCompCnt(int accExamCompCnt) {
		this.accExamCompCnt = accExamCompCnt;
	}
	public float getAccDefRate() {
		return accDefRate;
	}
	public void setAccDefRate(float accDefRate) {
		this.accDefRate = accDefRate;
	}
	public int getTodayDecide() {
		return todayDecide;
	}
	public void setTodayDecide(int todayDecide) {
		this.todayDecide = todayDecide;
	}
	public int getTodayClear() {
		return todayClear;
	}
	public void setTodayClear(int todayClear) {
		this.todayClear = todayClear;
	}
	public int getTodayCare() {
		return todayCare;
	}
	public void setTodayCare(int todayCare) {
		this.todayCare = todayCare;
	}
	public int getTodayDeath() {
		return todayDeath;
	}
	public void setTodayDeath(int todayDeath) {
		this.todayDeath = todayDeath;
	}
	
	
}
