package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.scene.control.Button;

public class HideCompleteButton {

	Connection con;
	Statement st;
	ResultSet rs;
	
	public HideCompleteButton() {
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
	
	public void hideButton(Button a, Button b, Button c,Button d,Button e,Button f,Button g,Button h,Button i) {
		String todayTmp = LocalDate.now().toString();
		String[] str = todayTmp.split("-");
		String today = str[0] + "y" + str[1] + "m" + str[2] + "d";
		String SQL = "SELECT complete FROM "+today;
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("zero");
		
		try {
			rs = st.executeQuery(SQL);
			while(rs.next()) {
				arr.add(rs.getString(1));
			}
		} catch (Exception e1) {
			System.out.println("hideButton: "+e1.getMessage());
			e1.printStackTrace();
		}
		
		for(int j = 1; j < arr.size(); j++) {
			if(arr.get(j).equals("완료")) {
				switch(j) {
				case 1: a.setVisible(false); break;
				case 2: b.setVisible(false); break;
				case 3: c.setVisible(false); break;
				case 4: d.setVisible(false); break;
				case 5: e.setVisible(false); break;
				case 6: f.setVisible(false); break;
				case 7: g.setVisible(false); break;
				case 8: h.setVisible(false); break;
				case 9: i.setVisible(false); break;		
				}
			}
		}
		
	}
	
	
}
