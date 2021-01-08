package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Rate {

	Connection con;
	Statement st;
	ResultSet rs;
	
	public Rate() {
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
	
	public void rate() {
		System.out.println("시작");
		try {
			String SQLComplete = "SELECT complete from all_goals";
			int cnt = 0;
			ArrayList<Integer> arrComp = new ArrayList<Integer>();
			arrComp.add(0);
			rs = st.executeQuery(SQLComplete);
			while(rs.next()) {
				arrComp.add(Integer.parseInt(rs.getString(1)));
				cnt++;
			}
			System.out.println(arrComp);
			
			String SQLIncomplete = "SELECT incomplete from all_goals";
			ArrayList<Integer> arrIncomp = new ArrayList<Integer>();
			arrIncomp.add(0);
			rs = st.executeQuery(SQLIncomplete);
			while(rs.next()) {
				arrIncomp.add(Integer.parseInt(rs.getString(1)));
			}
			System.out.println(arrIncomp);
			
			ArrayList<Integer> arrRate = new ArrayList<Integer>();
			arrRate.add(0);
			for(int i = 1; i <= cnt; i++) {
				int devideResult = (int)((double)arrComp.get(i)/((double)arrComp.get(i)+(double)arrIncomp.get(i))*100);
				arrRate.add(devideResult);
				String SQLRate = "UPDATE all_goals SET rate = " + arrRate.get(i) +" WHERE no = " + i;
				try {
					st.executeUpdate(SQLRate);
					System.out.println("성공");
				} catch(Exception e) {
					System.out.println("SQLRate: "+e.getMessage());
					e.printStackTrace();
				}
			}
			

			
		} catch(Exception e) {
			System.out.println("rate: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
}
