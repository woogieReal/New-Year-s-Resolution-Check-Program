package application;

import java.time.LocalDate;

public class prac {

	public static void main(String[] args) {
		String newGoal = "이거 잘되나";
		String simpleName = "이거";
		String today = LocalDate.now().toString();
		int defaultComplete = 0;
		int defaultIncomplete = 0;
		
		StringBuilder sb = new StringBuilder();
		String SQL = sb.append("INSERT INTO all_goals VALUES(")
				.append("'"+newGoal+"',")
				.append("'"+simpleName+"',")
				.append("'"+today+"',")
				.append(defaultComplete+",")
				.append(defaultIncomplete+")")
				.toString();
		System.out.println(SQL);
	}

}
