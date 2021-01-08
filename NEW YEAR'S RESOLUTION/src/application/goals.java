package application;

public class goals {

	int no;
	String goal_detail;
	String simple_name;
	String registration_date;
	int complete;
	int incomplete;
	int rate;
	
	public goals(int no, String goal_detail, String simple_name, String registration_date, int complete, int incomplete,
			int rate) {
		super();
		this.no = no;
		this.goal_detail = goal_detail;
		this.simple_name = simple_name;
		this.registration_date = registration_date;
		this.complete = complete;
		this.incomplete = incomplete;
		this.rate = rate;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getGoal_detail() {
		return goal_detail;
	}
	public void setGoal_detail(String goal_detail) {
		this.goal_detail = goal_detail;
	}
	public String getSimple_name() {
		return simple_name;
	}
	public void setSimple_name(String simple_name) {
		this.simple_name = simple_name;
	}
	public String getRegistration_date() {
		return registration_date;
	}
	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}
	public int getComplete() {
		return complete;
	}
	public void setComplete(int complete) {
		this.complete = complete;
	}
	public int getIncomplete() {
		return incomplete;
	}
	public void setIncomplete(int incomplete) {
		this.incomplete = incomplete;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
		
}
