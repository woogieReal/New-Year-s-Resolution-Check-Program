package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DropTable365 {

	static Connection con;
	static Statement st;
	
	public DropTable365() {
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
	
	public static void dropTable() {
		
		try {
			for(int i = 1; i <= 12; i++) {
				for(int j = 1; j <= 31; j++ ) {
					if(i <= 9) {
						if(j <= 9) {
							StringBuilder sb3 = new StringBuilder();
							String SQL3 = sb3.append("DROP TABLE 2021y0")
									.append(i+"m0")
									.append(j+"d")
									.toString();
							st.execute(SQL3);
							System.out.println(+i+"월"+j+"일 성공");					
						} else {
							StringBuilder sb3 = new StringBuilder();
							String SQL3 = sb3.append("DROP TABLE 2021y0")
									.append(i+"m")
									.append(j+"d")
									.toString();
							st.execute(SQL3);
							System.out.println(+i+"월"+j+"일 성공");		
						}
					} else {
						if(j <= 9) {
							StringBuilder sb3 = new StringBuilder();
							String SQL3 = sb3.append("DROP TABLE 2021y")
									.append(i+"m0")
									.append(j+"d")
									.toString();
							st.execute(SQL3);
							System.out.println(+i+"월"+j+"일 성공");					
						} else {
							StringBuilder sb3 = new StringBuilder();
							String SQL3 = sb3.append("DROP TABLE 2021y")
									.append(i+"m")
									.append(j+"d")
									.toString();
							st.execute(SQL3);
							System.out.println(+i+"월"+j+"일 성공");		
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
