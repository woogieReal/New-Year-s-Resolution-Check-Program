package application;

public class Daily {

	int num;
	String goal_detail;
	String complete;
	
	public Daily(int num, String goal_detail, String complete) {
		super();
		this.num = num;
		this.goal_detail = goal_detail;
		this.complete = complete;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getGoal_detail() {
		return goal_detail;
	}

	public void setGoal_detail(String goal_detail) {
		this.goal_detail = goal_detail;
	}

	public String getComplete() {
		return complete;
	}

	public void setComplete(String complete) {
		this.complete = complete;
	}
	
	
	
	
	
}
