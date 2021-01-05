package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable365 {
	
	static Connection con;
	static Statement st;
	
	public CreateTable365() {
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
	
	public static void CreateTable() {
		
		try {
			for(int i = 1; i <= 12; i++) {
				for(int j = 1; j <= 31; j++ ) {
					if(i <= 9) {
						if(j <= 9) {
							StringBuilder sb = new StringBuilder();
							String SQL = sb.append("CREATE TABLE 2021y0")
									.append(i+"m0")
									.append(j+"d (num int not null auto_increment primary key, goal_detail varchar(40) not null, complete varchar(5))")
									.toString();
							st.execute(SQL);
							System.out.println(+i+"월"+j+"일 성공");					
						} else {
							StringBuilder sb = new StringBuilder();
							String SQL = sb.append("CREATE TABLE 2021y0")
									.append(i+"m")
									.append(j+"d (num int not null auto_increment primary key, goal_detail varchar(40) not null, complete varchar(5))")
									.toString();
							st.execute(SQL);
							System.out.println(+i+"월"+j+"일 성공");		
						}
					} else {
						if(j <= 9) {
							StringBuilder sb = new StringBuilder();
							String SQL = sb.append("CREATE TABLE 2021y")
									.append(i+"m0")
									.append(j+"d (num int not null auto_increment primary key, goal_detail varchar(40) not null, complete varchar(5))")
									.toString();
							st.execute(SQL);
							System.out.println(+i+"월"+j+"일 성공");					
						} else {
							StringBuilder sb = new StringBuilder();
							String SQL = sb.append("CREATE TABLE 2021y")
									.append(i+"m")
									.append(j+"d (num int not null auto_increment primary key, goal_detail varchar(40) not null, complete varchar(5))")
									.toString();
							st.execute(SQL);
							System.out.println(+i+"월"+j+"일 성공");		
						}
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
