package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

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
	
	public static ObservableList<goals> getDataGoals(Button a, Button b, Button c,Button d,Button e,Button f,Button g,Button h,Button i){
		
		Connection conn = connectDB();
		ObservableList<goals> list = FXCollections.observableArrayList();
		
		try {
			String SQL = "SELECT * FROM all_goals";
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			int count = 0;
			
			while(rs.next()) {
				
				list.add(new goals(Integer.parseInt(rs.getString("no")),rs.getString("goal_detail"),rs.getString("simple_name"),rs.getString("registration_date"), Integer.parseInt(rs.getString("complete")),Integer.parseInt(rs.getString("incomplete")),Integer.parseInt(rs.getString("rate"))));
				count++;
				System.out.println("목표 의 개수: "+count);
				
				}
			
			switch(count) {
			case 1: a.setVisible(true); break;
			case 2: a.setVisible(true); b.setVisible(true);break;
			case 3: a.setVisible(true); b.setVisible(true); c.setVisible(true); break;
			case 4: a.setVisible(true); b.setVisible(true); c.setVisible(true); d.setVisible(true); break;
			case 5: a.setVisible(true); b.setVisible(true); c.setVisible(true); d.setVisible(true); e.setVisible(true); break;
			case 6: a.setVisible(true); b.setVisible(true); c.setVisible(true); d.setVisible(true); e.setVisible(true); f.setVisible(true); break;
			case 7: a.setVisible(true); b.setVisible(true); c.setVisible(true); d.setVisible(true); e.setVisible(true); f.setVisible(true); g.setVisible(true); break;
			case 8: a.setVisible(true); b.setVisible(true); c.setVisible(true); d.setVisible(true); e.setVisible(true); f.setVisible(true); g.setVisible(true); h.setVisible(true); break;
			case 9: a.setVisible(true); b.setVisible(true); c.setVisible(true); d.setVisible(true); e.setVisible(true); f.setVisible(true); g.setVisible(true); h.setVisible(true); i.setVisible(true); break;
			
			}
		} catch(Exception ie) {
			System.out.println("goals" + ie.getMessage());

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
				
				list.add(new Daily(Integer.parseInt(rs.getString("num")),rs.getString("goal_detail"),rs.getString("complete")));
				
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
				
				list.add(new Weekly(Integer.parseInt(rs.getString("no")),rs.getString("mon"),rs.getString("tue"),rs.getString("wed"),rs.getString("thu"),rs.getString("fri"),rs.getString("sat"),rs.getString("sun")));
				
			}
		} catch(Exception e) {
			System.out.println("Weekly" + e.getMessage());

		}
		
		return list;
		
	}
	
}
