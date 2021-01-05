package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

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
	
	@SuppressWarnings("incomplete-switch")
	public void complete(String dateTmp, int number) {
		
		String[] str = dateTmp.split("-");
		int year = Integer.parseInt(str[0]);
		int month = Integer.parseInt(str[1]);
		int dayOfMonth = Integer.parseInt(str[2]);
		LocalDate today = LocalDate.of(year, month, dayOfMonth);
		DayOfWeek dayOfWeek = today.getDayOfWeek();
		System.out.println(dayOfWeek);
		
//		String date = str[0] + "y" + str[1] + "m" + str[2] + "d";
		
		try {
			
			String SQL = "SELECT simple_name FROM all_goals";
			rs = st.executeQuery(SQL);
			ArrayList<String> arr = new ArrayList<String>();
			arr.add("zero");
			while(rs.next()) {
				arr.add(rs.getString(1));
			}
			System.out.println(arr);
			
			switch(month) {
				case 1: 
					if(dayOfMonth >= 4 && dayOfMonth < 11) {
						switch(dayOfWeek) {
							case MONDAY:
								String SQL1 = "UPDATE 2021y01m04dweek SET mon = '"+arr.get(number)+"' WHERE no = "+number;
								st.executeUpdate(SQL1);
								break;
							case TUESDAY:
								String SQL2 = "UPDATE 2021y01m04dweek SET tue = '"+arr.get(number)+"' WHERE no = "+number;
								st.executeUpdate(SQL2);
								break;
							case WEDNESDAY:
								String SQL3 = "UPDATE 2021y01m04dweek SET wed = '"+arr.get(number)+"' WHERE no = "+number;
								st.executeUpdate(SQL3);
								break;
							case THURSDAY:
								String SQL4 = "UPDATE 2021y01m04dweek SET thu = '"+arr.get(number)+"' WHERE no = "+number;
								st.executeUpdate(SQL4);
								break;
							case FRIDAY:
								String SQL5 = "UPDATE 2021y01m04dweek SET fri = '"+arr.get(number)+"' WHERE no = "+number;
								st.executeUpdate(SQL5);
								break;
							case SATURDAY:
								String SQL6 = "UPDATE 2021y01m04dweek SET sat = '"+arr.get(number)+"' WHERE no = "+number;
								st.executeUpdate(SQL6);
								break;
							case SUNDAY:
								String SQL7 = "UPDATE 2021y01m04dweek SET sun = '"+arr.get(number)+"' WHERE no = "+number;
								st.executeUpdate(SQL7);
								break;	
						} //-- switch	
					} else if(dayOfMonth >= 11 && dayOfMonth < 18) {
						switch(dayOfWeek) {
						case MONDAY:
							String SQL1 = "UPDATE 2021y01m11dweek SET mon = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL1);
							break;
						case TUESDAY:
							String SQL2 = "UPDATE 2021y01m11dweek SET tue = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL2);
							break;
						case WEDNESDAY:
							String SQL3 = "UPDATE 2021y01m11dweek SET wed = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL3);
							break;
						case THURSDAY:
							String SQL4 = "UPDATE 2021y01m11dweek SET thu = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL4);
							break;
						case FRIDAY:
							String SQL5 = "UPDATE 2021y01m11dweek SET fri = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL5);
							break;
						case SATURDAY:
							String SQL6 = "UPDATE 2021y01m11dweek SET sat = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL6);
							break;
						case SUNDAY:
							String SQL7 = "UPDATE 2021y01m11dweek SET sun = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL7);
							break;	
					} //-- switch	
					} else if(dayOfMonth >= 18 && dayOfMonth < 25) {
						switch(dayOfWeek) {
						case MONDAY:
							String SQL1 = "UPDATE 2021y01m18dweek SET mon = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL1);
							break;
						case TUESDAY:
							String SQL2 = "UPDATE 2021y01m18dweek SET tue = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL2);
							break;
						case WEDNESDAY:
							String SQL3 = "UPDATE 2021y01m18dweek SET wed = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL3);
							break;
						case THURSDAY:
							String SQL4 = "UPDATE 2021y01m18dweek SET thu = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL4);
							break;
						case FRIDAY:
							String SQL5 = "UPDATE 2021y01m18dweek SET fri = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL5);
							break;
						case SATURDAY:
							String SQL6 = "UPDATE 2021y01m18dweek SET sat = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL6);
							break;
						case SUNDAY:
							String SQL7 = "UPDATE 2021y01m18dweek SET sun = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL7);
							break;	
					} //-- switch	
					} else if(dayOfMonth >= 25 && dayOfMonth < 32) {
						switch(dayOfWeek) {
						case MONDAY:
							String SQL1 = "UPDATE 2021y01m25dweek SET mon = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL1);
							break;
						case TUESDAY:
							String SQL2 = "UPDATE 2021y01m25dweek SET tue = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL2);
							break;
						case WEDNESDAY:
							String SQL3 = "UPDATE 2021y01m25dweek SET wed = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL3);
							break;
						case THURSDAY:
							String SQL4 = "UPDATE 2021y01m25dweek SET thu = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL4);
							break;
						case FRIDAY:
							String SQL5 = "UPDATE 2021y01m25dweek SET fri = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL5);
							break;
						case SATURDAY:
							String SQL6 = "UPDATE 2021y01m25dweek SET sat = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL6);
							break;
						case SUNDAY:
							String SQL7 = "UPDATE 2021y01m25dweek SET sun = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL7);
							break;	
					} //-- switch	
					} 
				case 2:
					if(dayOfMonth >= 1 && dayOfMonth < 8) {
						switch(dayOfWeek) {
							case MONDAY:
								String SQL1 = "UPDATE 2021y02m01dweek SET mon = '"+arr.get(number)+"' WHERE no = "+number;
								st.executeUpdate(SQL1);
								break;
							case TUESDAY:
								String SQL2 = "UPDATE 2021y02m01dweek SET tue = '"+arr.get(number)+"' WHERE no = "+number;
								st.executeUpdate(SQL2);
								break;
							case WEDNESDAY:
								String SQL3 = "UPDATE 2021y02m01dweek SET wed = '"+arr.get(number)+"' WHERE no = "+number;
								st.executeUpdate(SQL3);
								break;
							case THURSDAY:
								String SQL4 = "UPDATE 2021y02m01dweek SET thu = '"+arr.get(number)+"' WHERE no = "+number;
								st.executeUpdate(SQL4);
								break;
							case FRIDAY:
								String SQL5 = "UPDATE 2021y02m01dweek SET fri = '"+arr.get(number)+"' WHERE no = "+number;
								st.executeUpdate(SQL5);
								break;
							case SATURDAY:
								String SQL6 = "UPDATE 2021y02m01dweek SET sat = '"+arr.get(number)+"' WHERE no = "+number;
								st.executeUpdate(SQL6);
								break;
							case SUNDAY:
								String SQL7 = "UPDATE 2021y02m01dweek SET sun = '"+arr.get(number)+"' WHERE no = "+number;
								st.executeUpdate(SQL7);
								break;	
						} //-- switch	
					} else if(dayOfMonth >= 8 && dayOfMonth < 15) {
						switch(dayOfWeek) {
						case MONDAY:
							String SQL1 = "UPDATE 2021y02m08dweek SET mon = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL1);
							break;
						case TUESDAY:
							String SQL2 = "UPDATE 2021y02m08dweek SET tue = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL2);
							break;
						case WEDNESDAY:
							String SQL3 = "UPDATE 2021y02m08dweek SET wed = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL3);
							break;
						case THURSDAY:
							String SQL4 = "UPDATE 2021y02m08dweek SET thu = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL4);
							break;
						case FRIDAY:
							String SQL5 = "UPDATE 2021y02m08dweek SET fri = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL5);
							break;
						case SATURDAY:
							String SQL6 = "UPDATE 2021y02m08dweek SET sat = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL6);
							break;
						case SUNDAY:
							String SQL7 = "UPDATE 2021y02m08dweek SET sun = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL7);
							break;	
					} //-- switch	
					} else if(dayOfMonth >=15 && dayOfMonth < 22) {
						switch(dayOfWeek) {
						case MONDAY:
							String SQL1 = "UPDATE 2021y02m15dweek SET mon = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL1);
							break;
						case TUESDAY:
							String SQL2 = "UPDATE 2021y02m15dweek SET tue = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL2);
							break;
						case WEDNESDAY:
							String SQL3 = "UPDATE 2021y02m15dweek SET wed = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL3);
							break;
						case THURSDAY:
							String SQL4 = "UPDATE 2021y02m15dweek SET thu = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL4);
							break;
						case FRIDAY:
							String SQL5 = "UPDATE 2021y02m15dweek SET fri = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL5);
							break;
						case SATURDAY:
							String SQL6 = "UPDATE 2021y02m15dweek SET sat = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL6);
							break;
						case SUNDAY:
							String SQL7 = "UPDATE 2021y02m15dweek SET sun = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL7);
							break;	
					} //-- switch	
					} else if(dayOfMonth >= 22 && dayOfMonth < 29) {
						switch(dayOfWeek) {
						case MONDAY:
							String SQL1 = "UPDATE 2021y02m22dweek SET mon = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL1);
							break;
						case TUESDAY:
							String SQL2 = "UPDATE 2021y02m22dweek SET tue = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL2);
							break;
						case WEDNESDAY:
							String SQL3 = "UPDATE 2021y02m22dweek SET wed = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL3);
							break;
						case THURSDAY:
							String SQL4 = "UPDATE 2021y02m22dweek SET thu = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL4);
							break;
						case FRIDAY:
							String SQL5 = "UPDATE 2021y02m22dweek SET fri = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL5);
							break;
						case SATURDAY:
							String SQL6 = "UPDATE 2021y02m22dweek SET sat = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL6);
							break;
						case SUNDAY:
							String SQL7 = "UPDATE 2021y02m22dweek SET sun = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL7);
							break;	
					} //-- switch	
					} 
				case 3:
					if(dayOfMonth >= 1 && dayOfMonth < 8) {
						switch(dayOfWeek) {
							case MONDAY:
								String SQL1 = "UPDATE 2021y03m01dweek SET mon = '"+arr.get(number)+"' WHERE no = "+number;
								st.executeUpdate(SQL1);
								break;
							case TUESDAY:
								String SQL2 = "UPDATE 2021y03m01dweek SET tue = '"+arr.get(number)+"' WHERE no = "+number;
								st.executeUpdate(SQL2);
								break;
							case WEDNESDAY:
								String SQL3 = "UPDATE 2021y03m01dweek SET wed = '"+arr.get(number)+"' WHERE no = "+number;
								st.executeUpdate(SQL3);
								break;
							case THURSDAY:
								String SQL4 = "UPDATE 2021y03m01dweek SET thu = '"+arr.get(number)+"' WHERE no = "+number;
								st.executeUpdate(SQL4);
								break;
							case FRIDAY:
								String SQL5 = "UPDATE 2021y03m01dweek SET fri = '"+arr.get(number)+"' WHERE no = "+number;
								st.executeUpdate(SQL5);
								break;
							case SATURDAY:
								String SQL6 = "UPDATE 2021y03m01dweek SET sat = '"+arr.get(number)+"' WHERE no = "+number;
								st.executeUpdate(SQL6);
								break;
							case SUNDAY:
								String SQL7 = "UPDATE 2021y03m01dweek SET sun = '"+arr.get(number)+"' WHERE no = "+number;
								st.executeUpdate(SQL7);
								break;	
						} //-- switch	
					} else if(dayOfMonth >= 8 && dayOfMonth < 15) {
						switch(dayOfWeek) {
						case MONDAY:
							String SQL1 = "UPDATE 2021y03m08dweek SET mon = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL1);
							break;
						case TUESDAY:
							String SQL2 = "UPDATE 2021y03m08dweek SET tue = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL2);
							break;
						case WEDNESDAY:
							String SQL3 = "UPDATE 2021y03m08dweek SET wed = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL3);
							break;
						case THURSDAY:
							String SQL4 = "UPDATE 2021y03m08dweek SET thu = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL4);
							break;
						case FRIDAY:
							String SQL5 = "UPDATE 2021y03m08dweek SET fri = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL5);
							break;
						case SATURDAY:
							String SQL6 = "UPDATE 2021y03m08dweek SET sat = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL6);
							break;
						case SUNDAY:
							String SQL7 = "UPDATE 2021y03m08dweek SET sun = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL7);
							break;	
					} //-- switch	
					} else if(dayOfMonth >=15 && dayOfMonth < 22) {
						switch(dayOfWeek) {
						case MONDAY:
							String SQL1 = "UPDATE 2021y03m15dweek SET mon = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL1);
							break;
						case TUESDAY:
							String SQL2 = "UPDATE 2021y03m15dweek SET tue = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL2);
							break;
						case WEDNESDAY:
							String SQL3 = "UPDATE 2021y03m15dweek SET wed = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL3);
							break;
						case THURSDAY:
							String SQL4 = "UPDATE 2021y03m15dweek SET thu = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL4);
							break;
						case FRIDAY:
							String SQL5 = "UPDATE 2021y03m15dweek SET fri = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL5);
							break;
						case SATURDAY:
							String SQL6 = "UPDATE 2021y03m15dweek SET sat = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL6);
							break;
						case SUNDAY:
							String SQL7 = "UPDATE 2021y03m15dweek SET sun = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL7);
							break;	
					} //-- switch	
					} else if(dayOfMonth >= 22 && dayOfMonth < 29) {
						switch(dayOfWeek) {
						case MONDAY:
							String SQL1 = "UPDATE 2021y03m22dweek SET mon = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL1);
							break;
						case TUESDAY:
							String SQL2 = "UPDATE 2021y03m22dweek SET tue = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL2);
							break;
						case WEDNESDAY:
							String SQL3 = "UPDATE 2021y03m22dweek SET wed = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL3);
							break;
						case THURSDAY:
							String SQL4 = "UPDATE 2021y03m22dweek SET thu = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL4);
							break;
						case FRIDAY:
							String SQL5 = "UPDATE 2021y03m22dweek SET fri = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL5);
							break;
						case SATURDAY:
							String SQL6 = "UPDATE 2021y03m22dweek SET sat = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL6);
							break;
						case SUNDAY:
							String SQL7 = "UPDATE 2021y03m22dweek SET sun = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL7);
							break;	
					} //-- switch	
					} else if(dayOfMonth >= 29 && dayOfMonth < 32) {
						switch(dayOfWeek) {
						case MONDAY:
							String SQL1 = "UPDATE 2021y03m29dweek SET mon = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL1);
							break;
						case TUESDAY:
							String SQL2 = "UPDATE 2021y03m29dweek SET tue = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL2);
							break;
						case WEDNESDAY:
							String SQL3 = "UPDATE 2021y03m29dweek SET wed = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL3);
							break;
						case THURSDAY:
							String SQL4 = "UPDATE 2021y03m29dweek SET thu = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL4);
							break;
						case FRIDAY:
							String SQL5 = "UPDATE 2021y03m29dweek SET fri = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL5);
							break;
						case SATURDAY:
							String SQL6 = "UPDATE 2021y03m29dweek SET sat = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL6);
							break;
						case SUNDAY:
							String SQL7 = "UPDATE 2021y03m29dweek SET sun = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL7);
							break;	
					} //-- switch	
					} 
				case 4:
					if(dayOfMonth >= 1 && dayOfMonth < 5) {
						switch(dayOfWeek) {
							case MONDAY:
								String SQL1 = "UPDATE 2021y03m29dweek SET mon = '"+arr.get(number)+"' WHERE no = "+number;
								st.executeUpdate(SQL1);
								break;
							case TUESDAY:
								String SQL2 = "UPDATE 2021y03m29dweek SET tue = '"+arr.get(number)+"' WHERE no = "+number;
								st.executeUpdate(SQL2);
								break;
							case WEDNESDAY:
								String SQL3 = "UPDATE 2021y03m29dweek SET wed = '"+arr.get(number)+"' WHERE no = "+number;
								st.executeUpdate(SQL3);
								break;
							case THURSDAY:
								String SQL4 = "UPDATE 2021y03m29dweek SET thu = '"+arr.get(number)+"' WHERE no = "+number;
								st.executeUpdate(SQL4);
								break;
							case FRIDAY:
								String SQL5 = "UPDATE 2021y03m29dweek SET fri = '"+arr.get(number)+"' WHERE no = "+number;
								st.executeUpdate(SQL5);
								break;
							case SATURDAY:
								String SQL6 = "UPDATE 2021y03m29dweek SET sat = '"+arr.get(number)+"' WHERE no = "+number;
								st.executeUpdate(SQL6);
								break;
							case SUNDAY:
								String SQL7 = "UPDATE 2021y03m29dweek SET sun = '"+arr.get(number)+"' WHERE no = "+number;
								st.executeUpdate(SQL7);
								break;	
						} //-- switch	
					} else if(dayOfMonth >= 5 && dayOfMonth < 12) {
						switch(dayOfWeek) {
						case MONDAY:
							String SQL1 = "UPDATE 2021y04m05dweek SET mon = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL1);
							break;
						case TUESDAY:
							String SQL2 = "UPDATE 2021y04m05dweek SET tue = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL2);
							break;
						case WEDNESDAY:
							String SQL3 = "UPDATE 2021y04m05dweek SET wed = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL3);
							break;
						case THURSDAY:
							String SQL4 = "UPDATE 2021y04m05dweek SET thu = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL4);
							break;
						case FRIDAY:
							String SQL5 = "UPDATE 2021y04m05dweek SET fri = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL5);
							break;
						case SATURDAY:
							String SQL6 = "UPDATE 2021y04m05dweek SET sat = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL6);
							break;
						case SUNDAY:
							String SQL7 = "UPDATE 2021y04m05dweek SET sun = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL7);
							break;	
					} //-- switch	
					} else if(dayOfMonth >=12 && dayOfMonth < 19) {
						switch(dayOfWeek) {
						case MONDAY:
							String SQL1 = "UPDATE 2021y04m12dweek SET mon = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL1);
							break;
						case TUESDAY:
							String SQL2 = "UPDATE 2021y04m12dweek SET tue = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL2);
							break;
						case WEDNESDAY:
							String SQL3 = "UPDATE 2021y04m12dweek SET wed = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL3);
							break;
						case THURSDAY:
							String SQL4 = "UPDATE 2021y04m12dweek SET thu = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL4);
							break;
						case FRIDAY:
							String SQL5 = "UPDATE 2021y04m12dweek SET fri = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL5);
							break;
						case SATURDAY:
							String SQL6 = "UPDATE 2021y04m12dweek SET sat = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL6);
							break;
						case SUNDAY:
							String SQL7 = "UPDATE 2021y04m12dweek SET sun = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL7);
							break;	
					} //-- switch	
					} else if(dayOfMonth >= 19 && dayOfMonth < 26) {
						switch(dayOfWeek) {
						case MONDAY:
							String SQL1 = "UPDATE 2021y04m19dweek SET mon = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL1);
							break;
						case TUESDAY:
							String SQL2 = "UPDATE 2021y04m19dweek SET tue = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL2);
							break;
						case WEDNESDAY:
							String SQL3 = "UPDATE 2021y04m19dweek SET wed = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL3);
							break;
						case THURSDAY:
							String SQL4 = "UPDATE 2021y04m19dweek SET thu = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL4);
							break;
						case FRIDAY:
							String SQL5 = "UPDATE 2021y04m19dweek SET fri = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL5);
							break;
						case SATURDAY:
							String SQL6 = "UPDATE 2021y04m19dweek SET sat = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL6);
							break;
						case SUNDAY:
							String SQL7 = "UPDATE 2021y04m19dweek SET sun = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL7);
							break;	
					} //-- switch	
					} else if(dayOfMonth >= 26 && dayOfMonth < 31) {
						switch(dayOfWeek) {
						case MONDAY:
							String SQL1 = "UPDATE 2021y04m26dweek SET mon = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL1);
							break;
						case TUESDAY:
							String SQL2 = "UPDATE 2021y04m26dweek SET tue = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL2);
							break;
						case WEDNESDAY:
							String SQL3 = "UPDATE 2021y04m26dweek SET wed = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL3);
							break;
						case THURSDAY:
							String SQL4 = "UPDATE 2021y04m26dweek SET thu = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL4);
							break;
						case FRIDAY:
							String SQL5 = "UPDATE 2021y04m26dweek SET fri = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL5);
							break;
						case SATURDAY:
							String SQL6 = "UPDATE 2021y04m26dweek SET sat = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL6);
							break;
						case SUNDAY:
							String SQL7 = "UPDATE 2021y04m26dweek SET sun = '"+arr.get(number)+"' WHERE no = "+number;
							st.executeUpdate(SQL7);
							break;	
					} //-- switch	
					} 
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
