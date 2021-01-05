package application;

import java.time.LocalDate;

import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class WeeklyController {

	public static void WeeklyTable(Label label, TableView<Weekly> tableView, TableColumn<Weekly, Integer> n ,TableColumn<Weekly, String> a, TableColumn<Weekly, String> b, TableColumn<Weekly, String> c,TableColumn<Weekly, String> d, TableColumn<Weekly, String> e, TableColumn<Weekly, String> f,TableColumn<Weekly, String> g) {
		
		//주간화면 페이지
				ObservableList<Weekly> list;
				n.setCellValueFactory(new PropertyValueFactory<Weekly, Integer>("no"));
				a.setCellValueFactory(new PropertyValueFactory<Weekly, String>("mon"));
				b.setCellValueFactory(new PropertyValueFactory<Weekly, String>("tue"));
				c.setCellValueFactory(new PropertyValueFactory<Weekly, String>("wed"));
				d.setCellValueFactory(new PropertyValueFactory<Weekly, String>("thu"));
				e.setCellValueFactory(new PropertyValueFactory<Weekly, String>("fri"));
				f.setCellValueFactory(new PropertyValueFactory<Weekly, String>("sat"));
				g.setCellValueFactory(new PropertyValueFactory<Weekly, String>("sun"));
				
				LocalDate present = LocalDate.now();
				int year = present.getYear();
				int month = present.getMonthValue();
				int dayOfMonth = present.getDayOfMonth();
				
				switch(month) {
					case 1:
						if(dayOfMonth >= 4 && dayOfMonth < 11) {
							String thisWeekStart = LocalDate.of(year, month, 04).toString();
							String thisWeekEnd = LocalDate.of(year, month, 04).plusDays(6).toString();
							label.setText(thisWeekStart+" ~ "+thisWeekEnd);
							String[] str2 = thisWeekStart.split("-");
							String result2 = str2[0]+"y"+str2[1]+"m"+str2[2]+"d";
							list = MySQLConnect.getDataWeekly(result2);
							tableView.setItems(list);
							break;
						} else if(dayOfMonth >= 11 && dayOfMonth < 18) {
							String thisWeekStart = LocalDate.of(year, month, 11).toString();
							String thisWeekEnd = LocalDate.of(year, month, 11).plusDays(6).toString();
							label.setText(thisWeekStart+" ~ "+thisWeekEnd);
							String[] str2 = thisWeekStart.split("-");
							String result2 = str2[0]+"y"+str2[1]+"m"+str2[2]+"d";
							list = MySQLConnect.getDataWeekly(result2);
							tableView.setItems(list);
							break;
						} else if(dayOfMonth >= 18 && dayOfMonth < 25) {
							String thisWeekStart = LocalDate.of(year, month, 18).toString();
							String thisWeekEnd = LocalDate.of(year, month, 18).plusDays(6).toString();
							label.setText(thisWeekStart+" ~ "+thisWeekEnd);
							String[] str2 = thisWeekStart.split("-");
							String result2 = str2[0]+"y"+str2[1]+"m"+str2[2]+"d";
							list = MySQLConnect.getDataWeekly(result2);
							tableView.setItems(list);
							break;
						} else if(dayOfMonth >= 25 && dayOfMonth < 31) {
							String thisWeekStart = LocalDate.of(year, month, 25).toString();
							String thisWeekEnd = LocalDate.of(year, month, 25).plusDays(6).toString();
							label.setText(thisWeekStart+" ~ "+thisWeekEnd);
							String[] str2 = thisWeekStart.split("-");
							String result2 = str2[0]+"y"+str2[1]+"m"+str2[2]+"d";
							list = MySQLConnect.getDataWeekly(result2);
							tableView.setItems(list);
							break;
						}
					case 2:
						if(dayOfMonth >= 1 && dayOfMonth < 8) {
							String thisWeekStart = LocalDate.of(year, month, 01).toString();
							String thisWeekEnd = LocalDate.of(year, month, 01).plusDays(6).toString();
							label.setText(thisWeekStart+" ~ "+thisWeekEnd);
							String[] str2 = thisWeekStart.split("-");
							String result2 = str2[0]+"y"+str2[1]+"m"+str2[2]+"d";
							list = MySQLConnect.getDataWeekly(result2);
							tableView.setItems(list);
							break;
						} else if(dayOfMonth >= 8 && dayOfMonth < 15) {
							String thisWeekStart = LocalDate.of(year, month, 8).toString();
							String thisWeekEnd = LocalDate.of(year, month, 8).plusDays(6).toString();
							label.setText(thisWeekStart+" ~ "+thisWeekEnd);
							String[] str2 = thisWeekStart.split("-");
							String result2 = str2[0]+"y"+str2[1]+"m"+str2[2]+"d";
							list = MySQLConnect.getDataWeekly(result2);
							tableView.setItems(list);
							break;
						} else if(dayOfMonth >= 15 && dayOfMonth < 22) {
							String thisWeekStart = LocalDate.of(year, month, 15).toString();
							String thisWeekEnd = LocalDate.of(year, month, 15).plusDays(6).toString();
							label.setText(thisWeekStart+" ~ "+thisWeekEnd);
							String[] str2 = thisWeekStart.split("-");
							String result2 = str2[0]+"y"+str2[1]+"m"+str2[2]+"d";
							list = MySQLConnect.getDataWeekly(result2);
							tableView.setItems(list);
							break;
						} else if(dayOfMonth >= 22 && dayOfMonth < 29) {
							String thisWeekStart = LocalDate.of(year, month, 22).toString();
							String thisWeekEnd = LocalDate.of(year, month, 22).plusDays(6).toString();
							label.setText(thisWeekStart+" ~ "+thisWeekEnd);
							String[] str2 = thisWeekStart.split("-");
							String result2 = str2[0]+"y"+str2[1]+"m"+str2[2]+"d";
							list = MySQLConnect.getDataWeekly(result2);
							tableView.setItems(list);
							break;
						}
					case 3:
						if(dayOfMonth >= 1 && dayOfMonth < 8) {
							String thisWeekStart = LocalDate.of(year, month, 01).toString();
							String thisWeekEnd = LocalDate.of(year, month, 01).plusDays(6).toString();
							label.setText(thisWeekStart+" ~ "+thisWeekEnd);
							String[] str2 = thisWeekStart.split("-");
							String result2 = str2[0]+"y"+str2[1]+"m"+str2[2]+"d";
							list = MySQLConnect.getDataWeekly(result2);
							tableView.setItems(list);
							break;
						} else if(dayOfMonth >= 8 && dayOfMonth < 15) {
							String thisWeekStart = LocalDate.of(year, month, 8).toString();
							String thisWeekEnd = LocalDate.of(year, month, 8).plusDays(6).toString();
							label.setText(thisWeekStart+" ~ "+thisWeekEnd);
							String[] str2 = thisWeekStart.split("-");
							String result2 = str2[0]+"y"+str2[1]+"m"+str2[2]+"d";
							list = MySQLConnect.getDataWeekly(result2);
							tableView.setItems(list);
							break;
						} else if(dayOfMonth >= 15 && dayOfMonth < 22) {
							String thisWeekStart = LocalDate.of(year, month, 15).toString();
							String thisWeekEnd = LocalDate.of(year, month, 15).plusDays(6).toString();
							label.setText(thisWeekStart+" ~ "+thisWeekEnd);
							String[] str2 = thisWeekStart.split("-");
							String result2 = str2[0]+"y"+str2[1]+"m"+str2[2]+"d";
							list = MySQLConnect.getDataWeekly(result2);
							tableView.setItems(list);
							break;
						} else if(dayOfMonth >= 22 && dayOfMonth < 29) {
							String thisWeekStart = LocalDate.of(year, month, 22).toString();
							String thisWeekEnd = LocalDate.of(year, month, 22).plusDays(6).toString();
							label.setText(thisWeekStart+" ~ "+thisWeekEnd);
							String[] str2 = thisWeekStart.split("-");
							String result2 = str2[0]+"y"+str2[1]+"m"+str2[2]+"d";
							list = MySQLConnect.getDataWeekly(result2);
							tableView.setItems(list);
							break;
						} else if(dayOfMonth >= 29 && dayOfMonth < 32) {
							String thisWeekStart = LocalDate.of(year, month, 29).toString();
							String thisWeekEnd = LocalDate.of(year, month, 29).plusDays(6).toString();
							label.setText(thisWeekStart+" ~ "+thisWeekEnd);
							String[] str2 = thisWeekStart.split("-");
							String result2 = str2[0]+"y"+str2[1]+"m"+str2[2]+"d";
							list = MySQLConnect.getDataWeekly(result2);
							tableView.setItems(list);
							break;
						} 
					case 4:
						if(dayOfMonth >= 1 && dayOfMonth < 5) {
							String thisWeekStart = LocalDate.of(year, month-1, 29).toString();
							String thisWeekEnd = LocalDate.of(year, month-1, 29).plusDays(6).toString();
							label.setText(thisWeekStart+" ~ "+thisWeekEnd);
							String[] str2 = thisWeekStart.split("-");
							String result2 = str2[0]+"y"+str2[1]+"m"+str2[2]+"d";
							list = MySQLConnect.getDataWeekly(result2);
							tableView.setItems(list);
							break;
						} else if(dayOfMonth >= 5 && dayOfMonth < 12) {
							String thisWeekStart = LocalDate.of(year, month, 05).toString();
							String thisWeekEnd = LocalDate.of(year, month, 05).plusDays(6).toString();
							label.setText(thisWeekStart+" ~ "+thisWeekEnd);
							String[] str2 = thisWeekStart.split("-");
							String result2 = str2[0]+"y"+str2[1]+"m"+str2[2]+"d";
							list = MySQLConnect.getDataWeekly(result2);
							tableView.setItems(list);
							break;
						} else if(dayOfMonth >= 12 && dayOfMonth < 19) {
							String thisWeekStart = LocalDate.of(year, month, 12).toString();
							String thisWeekEnd = LocalDate.of(year, month, 12).plusDays(6).toString();
							label.setText(thisWeekStart+" ~ "+thisWeekEnd);
							String[] str2 = thisWeekStart.split("-");
							String result2 = str2[0]+"y"+str2[1]+"m"+str2[2]+"d";
							list = MySQLConnect.getDataWeekly(result2);
							tableView.setItems(list);
							break;
						} else if(dayOfMonth >= 19 && dayOfMonth < 26) {
							String thisWeekStart = LocalDate.of(year, month, 19).toString();
							String thisWeekEnd = LocalDate.of(year, month, 19).plusDays(6).toString();
							label.setText(thisWeekStart+" ~ "+thisWeekEnd);
							String[] str2 = thisWeekStart.split("-");
							String result2 = str2[0]+"y"+str2[1]+"m"+str2[2]+"d";
							list = MySQLConnect.getDataWeekly(result2);
							tableView.setItems(list);
							break;
						} else if(dayOfMonth >= 26 && dayOfMonth < 31) {
							String thisWeekStart = LocalDate.of(year, month, 26).toString();
							String thisWeekEnd = LocalDate.of(year, month, 26).plusDays(6).toString();
							label.setText(thisWeekStart+" ~ "+thisWeekEnd);
							String[] str2 = thisWeekStart.split("-");
							String result2 = str2[0]+"y"+str2[1]+"m"+str2[2]+"d";
							list = MySQLConnect.getDataWeekly(result2);
							tableView.setItems(list);
							break;
						}
					case 5:
						if(dayOfMonth >= 1 && dayOfMonth < 3) {
							String thisWeekStart = LocalDate.of(year, month-1, 26).toString();
							String thisWeekEnd = LocalDate.of(year, month-1, 26).plusDays(6).toString();
							label.setText(thisWeekStart+" ~ "+thisWeekEnd);
							String[] str2 = thisWeekStart.split("-");
							String result2 = str2[0]+"y"+str2[1]+"m"+str2[2]+"d";
							list = MySQLConnect.getDataWeekly(result2);
							tableView.setItems(list);
							break;
						} else if(dayOfMonth >= 3 && dayOfMonth < 10) {
							String thisWeekStart = LocalDate.of(year, month, 3).toString();
							String thisWeekEnd = LocalDate.of(year, month, 3).plusDays(6).toString();
							label.setText(thisWeekStart+" ~ "+thisWeekEnd);
							String[] str2 = thisWeekStart.split("-");
							String result2 = str2[0]+"y"+str2[1]+"m"+str2[2]+"d";
							list = MySQLConnect.getDataWeekly(result2);
							tableView.setItems(list);
							break;
						} else if(dayOfMonth >= 10 && dayOfMonth < 17) {
							String thisWeekStart = LocalDate.of(year, month, 10).toString();
							String thisWeekEnd = LocalDate.of(year, month, 10).plusDays(6).toString();
							label.setText(thisWeekStart+" ~ "+thisWeekEnd);
							String[] str2 = thisWeekStart.split("-");
							String result2 = str2[0]+"y"+str2[1]+"m"+str2[2]+"d";
							list = MySQLConnect.getDataWeekly(result2);
							tableView.setItems(list);
							break;
						} else if(dayOfMonth >= 17 && dayOfMonth < 24) {
							String thisWeekStart = LocalDate.of(year, month, 17).toString();
							String thisWeekEnd = LocalDate.of(year, month, 17).plusDays(6).toString();
							label.setText(thisWeekStart+" ~ "+thisWeekEnd);
							String[] str2 = thisWeekStart.split("-");
							String result2 = str2[0]+"y"+str2[1]+"m"+str2[2]+"d";
							list = MySQLConnect.getDataWeekly(result2);
							tableView.setItems(list);
							break;
						} else if(dayOfMonth >= 24 && dayOfMonth < 31) {
							String thisWeekStart = LocalDate.of(year, month, 24).toString();
							String thisWeekEnd = LocalDate.of(year, month, 24).plusDays(6).toString();
							label.setText(thisWeekStart+" ~ "+thisWeekEnd);
							String[] str2 = thisWeekStart.split("-");
							String result2 = str2[0]+"y"+str2[1]+"m"+str2[2]+"d";
							list = MySQLConnect.getDataWeekly(result2);
							tableView.setItems(list);
							break;
						}
						
				} //--switch
		
	}
	
}
