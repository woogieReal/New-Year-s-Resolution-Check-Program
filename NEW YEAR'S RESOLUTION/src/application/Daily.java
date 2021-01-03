package application;

public class Daily {

	String goal_detail;
	String complete;
	
	public Daily(String goal_detail, String complete) {
		super();
		this.goal_detail = goal_detail;
		this.complete = complete;
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
