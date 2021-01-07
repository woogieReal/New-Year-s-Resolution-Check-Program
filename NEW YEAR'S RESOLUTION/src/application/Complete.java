package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Complete {
	
	Connection con;
	Statement st;
	ResultSet rs;
	
	public Complete() {
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
	
	public void SQLStart(String SQL1, String SQL2, String SQL3) {
		try {
			st.executeUpdate(SQL1);
			st.executeUpdate(SQL2);
			st.executeUpdate(SQL3);
		} catch (SQLException e) {
			System.out.println("SQL실행실패: "+e.getMessage());
			e.printStackTrace();
		}
		System.out.println("성공");
	}
	
	public void complete(String dateTmp, int number) {
		
		String[] str = dateTmp.split("-");
		int year = Integer.parseInt(str[0]);
		int month = Integer.parseInt(str[1]);
		int dayOfMonth = Integer.parseInt(str[2]);
		LocalDate today = LocalDate.of(year, month, dayOfMonth);
		DayOfWeek dayOfWeek = today.getDayOfWeek();
		
		String todayDate = str[0] + "y" + str[1] + "m" + str[2] + "d";
		
		try {
			
			String SQL = "SELECT simple_name FROM all_goals WHERE no = "+number;
			rs = st.executeQuery(SQL);
			String simpleName = "";
			while(rs.next()) {
				simpleName = rs.getString(1);
			}
			
			String dayOfWeekToday ="";
			switch(dayOfWeek) {
			case MONDAY: dayOfWeekToday = "mon"; break;
			case TUESDAY: dayOfWeekToday = "tue"; break;
			case WEDNESDAY: dayOfWeekToday = "wed"; break;
			case THURSDAY: dayOfWeekToday = "thu"; break;
			case FRIDAY: dayOfWeekToday = "fri"; break;
			case SATURDAY: dayOfWeekToday = "sat"; break;
			case SUNDAY: dayOfWeekToday = "sun"; break; }
			
			String SQL2 = "SELECT complete FROM all_goals WHERE no = "+number;
			rs = st.executeQuery(SQL2);
			int newComplete = 0;
			while(rs.next()) {
				newComplete = Integer.parseInt(rs.getString(1)) + 1;
			}
			
			switch(month) {
				case 1: 
					if(dayOfMonth >= 4 && dayOfMonth < 11) {
						String SQL3 = "UPDATE 2021y01m04dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 11 && dayOfMonth < 18) {
						String SQL3 = "UPDATE 2021y01m11dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 18 && dayOfMonth < 25) {
						String SQL3 = "UPDATE 2021y01m18dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 25 && dayOfMonth < 32) {
						String SQL3 = "UPDATE 2021y01m25dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} 
					break;
				case 2:
					if(dayOfMonth >= 1 && dayOfMonth < 8) {
						String SQL3 = "UPDATE 2021y02m01dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 8 && dayOfMonth < 15) {
						String SQL3 = "UPDATE 2021y02m08dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >=15 && dayOfMonth < 22) {
						String SQL3 = "UPDATE 2021y02m15dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 22 && dayOfMonth < 29) {
						String SQL3 = "UPDATE 2021y02m22dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} 
				case 3:
					if(dayOfMonth >= 1 && dayOfMonth < 8) {
						String SQL3 = "UPDATE 2021y03m01dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 8 && dayOfMonth < 15) {
						String SQL3 = "UPDATE 2021y03m08dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >=15 && dayOfMonth < 22) {
						String SQL3 = "UPDATE 2021y03m15dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 22 && dayOfMonth < 29) {
						String SQL3 = "UPDATE 2021y03m22dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 29 && dayOfMonth < 32) {
						String SQL3 = "UPDATE 2021y03m29dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} 
				case 4:
					if(dayOfMonth >= 1 && dayOfMonth < 5) {
						String SQL3 = "UPDATE 2021y03m29dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 5 && dayOfMonth < 12) {
						String SQL3 = "UPDATE 2021y04m05dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >=12 && dayOfMonth < 19) {
						String SQL3 = "UPDATE 2021y04m12dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 19 && dayOfMonth < 26) {
						String SQL3 = "UPDATE 2021y04m19dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 26 && dayOfMonth < 31) {
						String SQL3 = "UPDATE 2021y04m26dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} 
				case 5:
					if(dayOfMonth >= 1 && dayOfMonth < 3) {
						String SQL3 = "UPDATE 2021y04m26dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 3 && dayOfMonth < 10) {
						String SQL3 = "UPDATE 2021y05m03dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 10 && dayOfMonth < 17) {
						String SQL3 = "UPDATE 2021y05m10dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 17 && dayOfMonth < 24) {
						String SQL3 = "UPDATE 2021y05m17dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 24 && dayOfMonth < 31) {
						String SQL3 = "UPDATE 2021y05m24dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 31 && dayOfMonth < 33) {
						String SQL3 = "UPDATE 2021y05m31dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} 
				case 6:
					if(dayOfMonth >= 1 && dayOfMonth < 7) {
						String SQL3 = "UPDATE 2021y05m31dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 7 && dayOfMonth < 14) {
						String SQL3 = "UPDATE 2021y06m07dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 14 && dayOfMonth < 21) {
						String SQL3 = "UPDATE 2021y06m14dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 21 && dayOfMonth < 28) {
						String SQL3 = "UPDATE 2021y06m21dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 28 && dayOfMonth < 31) {
						String SQL3 = "UPDATE 2021y06m28dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} 
				case 7:
					if(dayOfMonth >= 1 && dayOfMonth < 5) {
						String SQL3 = "UPDATE 2021y06m28dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 5 && dayOfMonth < 12) {
						String SQL3 = "UPDATE 2021y07m05dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 12 && dayOfMonth < 19) {
						String SQL3 = "UPDATE 2021y07m12dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 19 && dayOfMonth < 26) {
						String SQL3 = "UPDATE 2021y07m19dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 26 && dayOfMonth < 32) {
						String SQL3 = "UPDATE 2021y07m26dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					}
				case 8:
					if(dayOfMonth >= 1 && dayOfMonth < 2) {
						String SQL3 = "UPDATE 2021y07m26dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 2 && dayOfMonth < 9) {
						String SQL3 = "UPDATE 2021y08m02dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 9 && dayOfMonth < 16) {
						String SQL3 = "UPDATE 2021y08m09dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 16 && dayOfMonth < 23) {
						String SQL3 = "UPDATE 2021y08m16dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 23 && dayOfMonth < 30) {
						String SQL3 = "UPDATE 2021y08m23dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 30 && dayOfMonth < 32) {
						String SQL3 = "UPDATE 2021y08m30dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					}
				case 9:
					if(dayOfMonth >= 1 && dayOfMonth < 6) {
						String SQL3 = "UPDATE 2021y08m30dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 6 && dayOfMonth < 13) {
						String SQL3 = "UPDATE 2021y09m06dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 13 && dayOfMonth < 20) {
						String SQL3 = "UPDATE 2021y09m13dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 20 && dayOfMonth < 27) {
						String SQL3 = "UPDATE 2021y09m20dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 27 && dayOfMonth < 31) {
						String SQL3 = "UPDATE 2021y09m27dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					}
				case 10:
					if(dayOfMonth >= 1 && dayOfMonth < 4) {
						String SQL3 = "UPDATE 2021y09m27dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 4 && dayOfMonth < 11) {
						String SQL3 = "UPDATE 2021y10m04dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 11 && dayOfMonth < 18) {
						String SQL3 = "UPDATE 2021y10m11dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 18 && dayOfMonth < 25) {
						String SQL3 = "UPDATE 2021y10m18dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 25 && dayOfMonth < 32) {
						String SQL3 = "UPDATE 2021y10m25dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					}
				case 11:
					if(dayOfMonth >= 1 && dayOfMonth < 8) {
						String SQL3 = "UPDATE 2021y11m01dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 8 && dayOfMonth < 15) {
						String SQL3 = "UPDATE 2021y11m08dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 15 && dayOfMonth < 22) {
						String SQL3 = "UPDATE 2021y11m15dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 22 && dayOfMonth < 29) {
						String SQL3 = "UPDATE 2021y11m22dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					}  else if(dayOfMonth >= 29 && dayOfMonth < 31) {
						String SQL3 = "UPDATE 2021y11m29dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					}
				case 12:
					if(dayOfMonth >= 1 && dayOfMonth < 6) {
						String SQL3 = "UPDATE 2021y11m29dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 6 && dayOfMonth < 13) {
						String SQL3 = "UPDATE 2021y12m06dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 13 && dayOfMonth < 20) {
						String SQL3 = "UPDATE 2021y12m13dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} else if(dayOfMonth >= 20 && dayOfMonth < 27) {
						String SQL3 = "UPDATE 2021y12m20dweek SET "+ dayOfWeekToday + " = '"+simpleName+"' WHERE no = "+number;
						String SQL4 = "UPDATE all_goals SET complete = " + newComplete + " WHERE no = "+number;
						String SQL5 = "UPDATE "+todayDate+" SET complete = '완료' WHERE num ="+number;
						SQLStart(SQL3,SQL4,SQL5); break;
					} 
			}//--switch

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
