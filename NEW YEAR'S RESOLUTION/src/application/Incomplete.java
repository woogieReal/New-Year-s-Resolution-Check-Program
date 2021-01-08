package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class Incomplete {

	Connection con;
	Statement st;
	ResultSet rs;
	
	public Incomplete() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/resolution?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "barames123");
			st = con.createStatement();
		} catch (Exception e) {
			System.out.println("데이터베이스 연결오류(DBConnection()) : " + e.getMessage());
		}
	}
	
	public void incomplete() {
		String yesterday = LocalDate.now().minusDays(1).toString();
		String[] str2 = yesterday.split("-");
		String result2 = str2[0]+"y"+str2[1]+"m"+str2[2]+"d";
		String SQL = "SELECT complete FROM "+ result2;
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("zero");
		
		try {
			rs = st.executeQuery(SQL);
			while(rs.next()) {
				arr.add(rs.getString(1));
			}
			for(int i = 1; i < arr.size(); i++) {
				if(arr.get(i).equals("미완료")) {
					
					String SQL2 = "UPDATE "+ result2 +" SET complete = '종료' WHERE num = "+ i;
					st.executeUpdate(SQL2);
					
					String SQL3 = "SELECT incomplete FROM all_goals WHERE no = "+i;
					rs = st.executeQuery(SQL3);
					int newIncomplete = 0;
					while(rs.next()) {
						newIncomplete = Integer.parseInt(rs.getString(1)) + 1;
					}
					
					String SQL4 = "UPDATE all_goals SET incomplete = " + newIncomplete + " WHERE no = "+i;
					st.executeUpdate(SQL4);
					System.out.println("update 종료 성공");
					MainController main = new MainController();
					main.updateTable();
				}
			}
		} catch (SQLException e) {
			System.out.println("incomplete 처리실패: "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
}
