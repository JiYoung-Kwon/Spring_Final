package graph;

public class GraphVo {
	String name;
	String percent;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}

	public GraphVo(){}
	public GraphVo(String name, String percent) {
		this.name = name;
		this.percent = percent;

	}
}
