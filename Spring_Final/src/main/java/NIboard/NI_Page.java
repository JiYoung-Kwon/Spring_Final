package NIboard;

public class NI_Page {
	int totList;
	int listSize=10;
	int blockSize=5;
	int totPage;
	int startNo;
	int endNo;
	int startPage;
	int endPage;
	int nowPage=1;
	String findStr="";
	String gubun="";
	String tabGubun="";
	String findSort;
	
	public NI_Page() {}
	public NI_Page(String gubun, String findStr,int totList, int nowPage) {
		this.gubun = gubun;
		this.findStr = findStr;
		this.totList = totList;
		this.nowPage = nowPage;
		
		// 페이징 연산
		compute();
	}
	public void compute() {
		totPage = (int)Math.ceil(totList/(double)listSize);
		endNo = nowPage*listSize;
		startNo = endNo-listSize+1;
		if(endNo>totList) endNo = totList;
		
		endPage = (int)Math.ceil(nowPage/(double)blockSize)*blockSize;
		startPage = endPage-blockSize+1;
		if(endPage>totPage) endPage = totPage;
	}
	
	
	
	public int getTotList() {
		return totList;
	}
	public int getListSize() {
		return listSize;
	}
	public int getBlockSize() {
		return blockSize;
	}
	public int getTotPage() {
		return totPage;
	}
	public int getStartNo() {
		return startNo;
	}
	public int getEndNo() {
		return endNo;
	}
	public int getStartPage() {
		return startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public int getNowPage() {
		return nowPage;
	}
	public String getFindStr() {
		return findStr;
	}
	public String getGubun() {
		return gubun;
	}
	public String getTabGubun() {
		return tabGubun;
	}
	public String getFindSort() {
		return findSort;
	}
	public void setTotList(int totList) {
		this.totList = totList;
	}
	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}
	public void setTotPage(int totPage) {
		this.totPage = totPage;
	}
	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}
	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public void setFindStr(String findStr) {
		this.findStr = findStr;
	}
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	public void setTabGubun(String tabGubun) {
		this.tabGubun = tabGubun;
	}
	public void setFindSort(String findSort) {
		this.findSort = findSort;
	}
	
	
	
	
	

}
