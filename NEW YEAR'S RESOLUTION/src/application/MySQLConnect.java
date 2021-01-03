package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MySQLConnect {

	Connection conn = null;
	
	public static Connection connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/resolution?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "barames123");
			return conn;
		} catch (Exception e) {
			System.out.println("데이터베이스 연결오류(DBConnection()) : " + e.getMessage());
			return null;
		}
	}
	
	public static ObservableList<goals> getDataGoals(){
		
		Connection conn = connectDB();
		ObservableList<goals> list = FXCollections.observableArrayList();
		
		try {
			String SQL = "SELECT * FROM all_goals";
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				list.add(new goals(rs.getString("goal_detail"),rs.getString("simple_name"),rs.getString("registration_date"), Integer.parseInt(rs.getString("complete")),Integer.parseInt(rs.getString("incomplete"))));
				
			}
		} catch(Exception e) {
			System.out.println("goals" + e.getMessage());

		}
		
		return list;
		
	}
	
	public static ObservableList<Daily> getDataDaily(String date){
		
		Connection conn = connectDB();
		ObservableList<Daily> list = FXCollections.observableArrayList();
		
		try {
			String SQL = "SELECT * FROM " + date;
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				list.add(new Daily(rs.getString("goal_detail"),rs.getString("complete")));
				
			}
		} catch(Exception e) {
			System.out.println("Daily" + e.getMessage());

		}
		
		return list;
		
	}
	
public static ObservableList<Weekly> getDataWeekly(String date){
		
		Connection conn = connectDB();
		ObservableList<Weekly> list = FXCollections.observableArrayList();
		
		try {
			String SQL = "SELECT * FROM " + date +"week";
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				list.add(new Weekly(rs.getString("mon"),rs.getString("tue"),rs.getString("wed"),rs.getString("thu"),rs.getString("fri"),rs.getString("sat"),rs.getString("sun")));
				
			}
		} catch(Exception e) {
			System.out.println("Weekly" + e.getMessage());

		}
		
		return list;
		
	}
	
}
