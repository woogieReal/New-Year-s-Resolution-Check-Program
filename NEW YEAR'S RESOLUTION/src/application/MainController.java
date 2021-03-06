package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MainController {

	Connection con;
	Statement st;
	ResultSet rs;

	// left box
	@FXML
	private Button dailyButton;
	@FXML
	private Button weeklyButton;
	@FXML
	private Button goalAddButton;
	@FXML
	private Button goalManageButton;

	// daily page
	@FXML
	private AnchorPane dailyAnchorPane;
	@FXML
	private Label dateInDailyLabel;
	@FXML
	private TableView<Daily> viewInDailyTabel;
	@FXML
	private TableColumn<Daily, Integer> numColumn;
	@FXML
	private TableColumn<Daily, String> goal_detailInDailyColumn;
	@FXML
	private TableColumn<Daily, String> completeOrNotColumn;
	@FXML
	private ImageView leftInDailyButton;
	@FXML
	private ImageView rigthtInDailyButton;
	@FXML
    private Button complete1Button;
    @FXML
    private Button complete2Button;
    @FXML
    private Button complete3Button;
    @FXML
    private Button complete4Button;
    @FXML
    private Button complete5Button;
    @FXML
    private Button complete6Button;
    @FXML
    private Button complete7Button;
    @FXML
    private Button complete8Button;
    @FXML
    private Button complete9Button;

	// weekly page
	@FXML
	private AnchorPane weeklyAnchorPane;
	@FXML
	private Label dateInWeeklyLabel;
	@FXML
	private TableView<Weekly> viewInWeeklyTabel;
	@FXML
    private TableColumn<Weekly, Integer> noInWeeklyColumn;
	@FXML
    private TableColumn<Weekly, String> monColumn;
    @FXML
    private TableColumn<Weekly, String> tueColumn;
    @FXML
    private TableColumn<Weekly, String> wedColumn;
    @FXML
    private TableColumn<Weekly, String> thuColumn;
    @FXML
    private TableColumn<Weekly, String> friColumn;
    @FXML
    private TableColumn<Weekly, String> satColumn;
    @FXML
    private TableColumn<Weekly, String> sunColumn;
	@FXML
	private ImageView leftInWeeklyButton;
	@FXML
	private ImageView rightInWeeklyButton;

	// goal manage page
	@FXML
	private AnchorPane goalManageAnchorPane;
	@FXML
	private TableView<goals> viewInGoalManageTabel;
	@FXML
    private TableColumn<goals, Integer> noColumn;
	@FXML
    private TableColumn<goals, String> goal_detailColumn;
    @FXML
    private TableColumn<goals, String> simple_nameColumn;
    @FXML
    private TableColumn<goals, String> registration_dateColumn;
    @FXML
    private TableColumn<goals, Integer> completeColumn;
    @FXML
    private TableColumn<goals, Integer> incompleteColumn;
    @FXML
    private TableColumn<goals, Integer> rateColumn;


	// goal add page
	@FXML
	private AnchorPane goalAddAnchorPane;
	@FXML
	private TextField newGoalTextField;
	@FXML
	private TextField simpleNameTextField;
	@FXML
	private Button registerButton;
	@FXML
	private Button cancelButton;

	//info page
	@FXML
	private AnchorPane infoAnchorPane;
	@FXML
	private Button cancelInInfoButton;
	@FXML
	private TextField InfoTextField;
	
	public void initialize() {
		//목표관리 페이지
		ObservableList<goals> list;	
		noColumn.setCellValueFactory(new PropertyValueFactory<goals, Integer>("no"));
		goal_detailColumn.setCellValueFactory(new PropertyValueFactory<goals, String>("goal_detail"));
		simple_nameColumn.setCellValueFactory(new PropertyValueFactory<goals, String>("simple_name"));
		registration_dateColumn.setCellValueFactory(new PropertyValueFactory<goals, String>("registration_date"));
		completeColumn.setCellValueFactory(new PropertyValueFactory<goals, Integer>("complete"));
		incompleteColumn.setCellValueFactory(new PropertyValueFactory<goals, Integer>("incomplete"));
		rateColumn.setCellValueFactory(new PropertyValueFactory<goals, Integer>("rate"));
		list = MySQLConnect.getDataGoals(complete1Button, complete2Button, complete3Button, complete4Button, complete5Button, complete6Button, complete7Button, complete8Button, complete9Button);
		viewInGoalManageTabel.setItems(list);
		
		
		//일간화면 페이지
		String today = LocalDate.now().toString();
		dateInDailyLabel.setText(today);
		String[] str = today.split("-");
		String result = str[0]+"y"+str[1]+"m"+str[2]+"d";
		ObservableList<Daily> list2;
		numColumn.setCellValueFactory(new PropertyValueFactory<Daily, Integer>("num"));
		goal_detailInDailyColumn.setCellValueFactory(new PropertyValueFactory<Daily, String>("goal_detail"));
		completeOrNotColumn.setCellValueFactory(new PropertyValueFactory<Daily, String>("complete"));
		list2 = MySQLConnect.getDataDaily(result);
		viewInDailyTabel.setItems(list2);
		
		//주간 페이지
		WeeklyController.WeeklyTable(dateInWeeklyLabel, viewInWeeklyTabel, noInWeeklyColumn ,monColumn, tueColumn, wedColumn, thuColumn, friColumn, satColumn, sunColumn);
		
		//incomplete처리
		Incomplete incomp = new Incomplete();
		incomp.incomplete();
		
		//달성률처리
		Rate rat = new Rate();
		rat.rate();
		
		//버튼없애기
		HideCompleteButton hide = new HideCompleteButton();
		hide.hideButton(complete1Button, complete2Button, complete3Button, complete4Button, complete5Button, complete6Button, complete7Button, complete8Button, complete9Button);
	}
	
	public MainController() {
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

	public void dailyButton(ActionEvent event) {
		try {
			dailyAnchorPane.setVisible(true);
			weeklyAnchorPane.setVisible(false);
			goalManageAnchorPane.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void weeklyButton(ActionEvent event) {
		try {
			weeklyAnchorPane.setVisible(true);
			dailyAnchorPane.setVisible(false);
			goalManageAnchorPane.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goalManageButton(ActionEvent event) {
		try {
			goalManageAnchorPane.setVisible(true);
			weeklyAnchorPane.setVisible(false);
			dailyAnchorPane.setVisible(false);
			initialize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void goalAddButton(ActionEvent event) {
		try {
			goalAddAnchorPane.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cancelButton(ActionEvent event) {
		try {
			goalAddAnchorPane.setVisible(false);
			newGoalTextField.setText("");
			simpleNameTextField.setText("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void registerButton(ActionEvent event) {
		try {
			InfoTextField.setText("목표를 등록중 입니다.");
			infoAnchorPane.setVisible(true);
			String newGoal = newGoalTextField.getText();
			String simpleName = simpleNameTextField.getText();
			String today = LocalDate.now().toString();
			int defaultComplete = 0;
			int defaultIncomplete = 0;
			int defaultRate = 0;
			
			StringBuilder sb = new StringBuilder();
			String SQL = sb.append("INSERT INTO all_goals(goal_detail, simple_name, registration_date, complete, incomplete, rate) VALUES(")
					.append("'"+newGoal+"',")
					.append("'"+simpleName+"',")
					.append("'"+today+"',")
					.append(defaultComplete+",")
					.append(defaultIncomplete+",")
					.append(defaultRate+")")
					.toString();
			st.executeUpdate(SQL);
			newGoalTextField.setText("");
			simpleNameTextField.setText("");
			initialize();
			
			for(int i = 1; i <= 12; i++) {
				for(int j = 1; j <= 31; j++ ) {
					if(i <= 9) {
						if(j <= 9) {
							StringBuilder sb3 = new StringBuilder();
							String SQL3 = sb3.append("INSERT INTO 2021y0")
									.append(i+"m0")
									.append(j+"d(goal_detail, complete) VALUES(")
									.append("'"+newGoal+"', '미완료' )")
									.toString();
							st.execute(SQL3);
							System.out.println(+i+"월"+j+"일 성공");					
						} else {
							StringBuilder sb3 = new StringBuilder();
							String SQL3 = sb3.append("INSERT INTO 2021y0")
									.append(i+"m")
									.append(j+"d(goal_detail, complete) VALUES(")
									.append("'"+newGoal+"', '미완료')")
									.toString();
							st.execute(SQL3);
							System.out.println(+i+"월"+j+"일 성공");		
						}
					} else {
						if(j <= 9) {
							StringBuilder sb3 = new StringBuilder();
							String SQL3 = sb3.append("INSERT INTO 2021y")
									.append(i+"m0")
									.append(j+"d(goal_detail, complete) VALUES(")
									.append("'"+newGoal+"', '미완료')")
									.toString();
							st.execute(SQL3);
							System.out.println(+i+"월"+j+"일 성공");					
						} else {
							StringBuilder sb3 = new StringBuilder();
							String SQL3 = sb3.append("INSERT INTO 2021y")
									.append(i+"m")
									.append(j+"d(goal_detail, complete) VALUES(")
									.append("'"+newGoal+"', '미완료')")
									.toString();
							st.execute(SQL3);
							System.out.println(+i+"월"+j+"일 성공");		
						}
					}
				}
			}
					
			String todayTmp = LocalDate.now().toString();
			String[] str = todayTmp.split("-");
			int month = Integer.parseInt(str[1]);
			int dayOfMonth = Integer.parseInt(str[2]);
			String todayDate = str[0] + "y" + str[1] + "m" + str[2] + "d";
			String goalNum = "SELECT num FROM "+todayDate;
			int cnt = 0;
			rs = st.executeQuery(goalNum);
			
			while(rs.next()) {
				cnt++;
				System.out.println("cnt: "+cnt);
			}
			
			for(int i = 1; i <= month; i++) {
				for(int j = 1; j < dayOfMonth; j++) {
					if(i <= 9) {
						if(j <= 9) {
							StringBuilder sb3 = new StringBuilder();
							String SQL3 = sb3.append("DELETE FROM 2021y0")
									.append(i+"m0")
									.append(j+"d WHERE num = ")
									.append(cnt)
									.toString();
							st.execute(SQL3);
							System.out.println(+i+"월"+j+"일 성공");					
						} else {
							StringBuilder sb3 = new StringBuilder();
							String SQL3 = sb3.append("DELETE FROM 2021y0")
									.append(i+"m")
									.append(j+"d WHERE num = ")
									.append(cnt)
									.toString();
							st.execute(SQL3);
							System.out.println(+i+"월"+j+"일 성공");		
						}
					} else {
						if(j <= 9) {
							StringBuilder sb3 = new StringBuilder();
							String SQL3 = sb3.append("DELETE FROM 2021y")
									.append(i+"m0")
									.append(j+"d WHERE num = ")
									.append(cnt)
									.toString();
							st.execute(SQL3);
							System.out.println(+i+"월"+j+"일 성공");					
						} else {
							StringBuilder sb3 = new StringBuilder();
							String SQL3 = sb3.append("DELETE FROM 2021y")
									.append(i+"m")
									.append(j+"d WHERE num = ")
									.append(cnt)
									.toString();
							st.execute(SQL3);
							System.out.println(+i+"월"+j+"일 성공");		
						}
					}
				}
			}
			
			
			initialize();
			
			InfoTextField.setText("성공적으로 목표를 등록하였습니다.");
		} catch (Exception e) {
			System.out.println("register: "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void cancelInInfoButton(ActionEvent event) {
		try {
			infoAnchorPane.setVisible(false);
			InfoTextField.setText("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void leftInDailyButton(MouseEvent event) {
		try {
			String today = dateInDailyLabel.getText();
			String[] str = today.split("-");
			int year = Integer.parseInt(str[0]);
			int month = Integer.parseInt(str[1]);
			int dayOfMonth = Integer.parseInt(str[2]);
			LocalDate today2 = LocalDate.of(year, month, dayOfMonth);
			String yesterday = today2.minusDays(1).toString();
			dateInDailyLabel.setText(yesterday);
			
			String[] str2 = yesterday.split("-");
			String result = str2[0]+"y"+str2[1]+"m"+str2[2]+"d";
			
			ObservableList<Daily> list2;
			goal_detailInDailyColumn.setCellValueFactory(new PropertyValueFactory<Daily, String>("goal_detail"));
			completeOrNotColumn.setCellValueFactory(new PropertyValueFactory<Daily, String>("complete"));
			list2 = MySQLConnect.getDataDaily(result);
			viewInDailyTabel.setItems(list2);
			
			String SQL = "SELECT no FROM all_goals";
			int cnt = 0;
			rs = st.executeQuery(SQL);
			while(rs.next()) {
				cnt++;
			}
			LocalDate realToday = LocalDate.now();
			LocalDate fakeYesterday = today2.minusDays(1);
			
			if(!realToday.equals(fakeYesterday)) {
				switch(cnt) {
				case 1: complete1Button.setVisible(false); break;
				case 2: complete1Button.setVisible(false); complete2Button.setVisible(false);break;
				case 3: complete1Button.setVisible(false); complete2Button.setVisible(false); complete3Button.setVisible(false); break;
				case 4: complete1Button.setVisible(false); complete2Button.setVisible(false); complete3Button.setVisible(false); complete4Button.setVisible(false); break;
				case 5: complete1Button.setVisible(false); complete2Button.setVisible(false); complete3Button.setVisible(false); complete4Button.setVisible(false); complete5Button.setVisible(false); break;
				case 6: complete1Button.setVisible(false); complete2Button.setVisible(false); complete3Button.setVisible(false); complete4Button.setVisible(false); complete5Button.setVisible(false); complete6Button.setVisible(false); break;
				case 7: complete1Button.setVisible(false); complete2Button.setVisible(false); complete3Button.setVisible(false); complete4Button.setVisible(false); complete5Button.setVisible(false); complete6Button.setVisible(false); complete7Button.setVisible(false); break;
				case 8: complete1Button.setVisible(false); complete2Button.setVisible(false); complete3Button.setVisible(false); complete4Button.setVisible(false); complete5Button.setVisible(false); complete6Button.setVisible(false); complete7Button.setVisible(false); complete8Button.setVisible(false); break;
				case 9: complete1Button.setVisible(false); complete2Button.setVisible(false); complete3Button.setVisible(false); complete4Button.setVisible(false); complete5Button.setVisible(false); complete6Button.setVisible(false); complete7Button.setVisible(false); complete8Button.setVisible(false); complete9Button.setVisible(false); break;		
				}
			} else if(realToday.equals(fakeYesterday)){
				switch(cnt) {
				case 1: complete1Button.setVisible(true); break;
				case 2: complete1Button.setVisible(true); complete2Button.setVisible(true);break;
				case 3: complete1Button.setVisible(true); complete2Button.setVisible(true); complete3Button.setVisible(true); break;
				case 4: complete1Button.setVisible(true); complete2Button.setVisible(true); complete3Button.setVisible(true); complete4Button.setVisible(true); break;
				case 5: complete1Button.setVisible(true); complete2Button.setVisible(true); complete3Button.setVisible(true); complete4Button.setVisible(true); complete5Button.setVisible(true); break;
				case 6: complete1Button.setVisible(true); complete2Button.setVisible(true); complete3Button.setVisible(true); complete4Button.setVisible(true); complete5Button.setVisible(true); complete6Button.setVisible(true); break;
				case 7: complete1Button.setVisible(true); complete2Button.setVisible(true); complete3Button.setVisible(true); complete4Button.setVisible(true); complete5Button.setVisible(true); complete6Button.setVisible(true); complete7Button.setVisible(true); break;
				case 8: complete1Button.setVisible(true); complete2Button.setVisible(true); complete3Button.setVisible(true); complete4Button.setVisible(true); complete5Button.setVisible(true); complete6Button.setVisible(true); complete7Button.setVisible(true); complete8Button.setVisible(true); break;
				case 9: complete1Button.setVisible(true); complete2Button.setVisible(true); complete3Button.setVisible(true); complete4Button.setVisible(true); complete5Button.setVisible(true); complete6Button.setVisible(true); complete7Button.setVisible(true); complete8Button.setVisible(true); complete9Button.setVisible(true); break;		
				}
			}
			
			HideCompleteButton hide = new HideCompleteButton();
			hide.hideButton(complete1Button, complete2Button, complete3Button, complete4Button, complete5Button, complete6Button, complete7Button, complete8Button, complete9Button);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void rightInDailyButton(MouseEvent event) {
		try {
			String today = dateInDailyLabel.getText();
			String[] str = today.split("-");
			int year = Integer.parseInt(str[0]);
			int month = Integer.parseInt(str[1]);
			int dayOfMonth = Integer.parseInt(str[2]);
			LocalDate today2 = LocalDate.of(year, month, dayOfMonth);
			String tomorrow = today2.plusDays(1).toString();
			dateInDailyLabel.setText(tomorrow);
			
			String[] str2 = tomorrow.split("-");
			String result = str2[0]+"y"+str2[1]+"m"+str2[2]+"d";
			
			ObservableList<Daily> list2;
			goal_detailInDailyColumn.setCellValueFactory(new PropertyValueFactory<Daily, String>("goal_detail"));
			completeOrNotColumn.setCellValueFactory(new PropertyValueFactory<Daily, String>("complete"));
			list2 = MySQLConnect.getDataDaily(result);
			viewInDailyTabel.setItems(list2);

			String SQL = "SELECT no FROM all_goals";
			int cnt = 0;
			rs = st.executeQuery(SQL);
			while(rs.next()) {
				cnt++;
			}
			LocalDate realToday = LocalDate.now();
			LocalDate fakeTomorrow = today2.plusDays(1);
			
			if(!realToday.equals(fakeTomorrow)) {
				switch(cnt) {
				case 1: complete1Button.setVisible(false); break;
				case 2: complete1Button.setVisible(false); complete2Button.setVisible(false);break;
				case 3: complete1Button.setVisible(false); complete2Button.setVisible(false); complete3Button.setVisible(false); break;
				case 4: complete1Button.setVisible(false); complete2Button.setVisible(false); complete3Button.setVisible(false); complete4Button.setVisible(false); break;
				case 5: complete1Button.setVisible(false); complete2Button.setVisible(false); complete3Button.setVisible(false); complete4Button.setVisible(false); complete5Button.setVisible(false); break;
				case 6: complete1Button.setVisible(false); complete2Button.setVisible(false); complete3Button.setVisible(false); complete4Button.setVisible(false); complete5Button.setVisible(false); complete6Button.setVisible(false); break;
				case 7: complete1Button.setVisible(false); complete2Button.setVisible(false); complete3Button.setVisible(false); complete4Button.setVisible(false); complete5Button.setVisible(false); complete6Button.setVisible(false); complete7Button.setVisible(false); break;
				case 8: complete1Button.setVisible(false); complete2Button.setVisible(false); complete3Button.setVisible(false); complete4Button.setVisible(false); complete5Button.setVisible(false); complete6Button.setVisible(false); complete7Button.setVisible(false); complete8Button.setVisible(false); break;
				case 9: complete1Button.setVisible(false); complete2Button.setVisible(false); complete3Button.setVisible(false); complete4Button.setVisible(false); complete5Button.setVisible(false); complete6Button.setVisible(false); complete7Button.setVisible(false); complete8Button.setVisible(false); complete9Button.setVisible(false); break;		
				}
			} else if(realToday.equals(fakeTomorrow)){
				switch(cnt) {
				case 1: complete1Button.setVisible(true); break;
				case 2: complete1Button.setVisible(true); complete2Button.setVisible(true);break;
				case 3: complete1Button.setVisible(true); complete2Button.setVisible(true); complete3Button.setVisible(true); break;
				case 4: complete1Button.setVisible(true); complete2Button.setVisible(true); complete3Button.setVisible(true); complete4Button.setVisible(true); break;
				case 5: complete1Button.setVisible(true); complete2Button.setVisible(true); complete3Button.setVisible(true); complete4Button.setVisible(true); complete5Button.setVisible(true); break;
				case 6: complete1Button.setVisible(true); complete2Button.setVisible(true); complete3Button.setVisible(true); complete4Button.setVisible(true); complete5Button.setVisible(true); complete6Button.setVisible(true); break;
				case 7: complete1Button.setVisible(true); complete2Button.setVisible(true); complete3Button.setVisible(true); complete4Button.setVisible(true); complete5Button.setVisible(true); complete6Button.setVisible(true); complete7Button.setVisible(true); break;
				case 8: complete1Button.setVisible(true); complete2Button.setVisible(true); complete3Button.setVisible(true); complete4Button.setVisible(true); complete5Button.setVisible(true); complete6Button.setVisible(true); complete7Button.setVisible(true); complete8Button.setVisible(true); break;
				case 9: complete1Button.setVisible(true); complete2Button.setVisible(true); complete3Button.setVisible(true); complete4Button.setVisible(true); complete5Button.setVisible(true); complete6Button.setVisible(true); complete7Button.setVisible(true); complete8Button.setVisible(true); complete9Button.setVisible(true); break;		
				}
			}

			HideCompleteButton hide = new HideCompleteButton();
			hide.hideButton(complete1Button, complete2Button, complete3Button, complete4Button, complete5Button, complete6Button, complete7Button, complete8Button, complete9Button);
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void leftInWeeklyButton(MouseEvent event) {
		try {
			String thisWeek = dateInWeeklyLabel.getText();
			String[] strtmp = thisWeek.split(" ~ ");
			String strtmp2 = strtmp[0];
			String[] str = strtmp2.split("-");
			int year = Integer.parseInt(str[0]);
			int month = Integer.parseInt(str[1]);
			int dayOfMonth = Integer.parseInt(str[2]);
			LocalDate thisWeekStart = LocalDate.of(year, month, dayOfMonth);
			LocalDate lastWeekStart = thisWeekStart.minusDays(7);
			LocalDate lastWeekEndDate = thisWeekStart.minusDays(1);
			dateInWeeklyLabel.setText(lastWeekStart.toString() +" ~ "+ lastWeekEndDate.toString());
			
			ObservableList<Weekly> list;
			monColumn.setCellValueFactory(new PropertyValueFactory<Weekly, String>("mon"));
			tueColumn.setCellValueFactory(new PropertyValueFactory<Weekly, String>("tue"));
			wedColumn.setCellValueFactory(new PropertyValueFactory<Weekly, String>("wed"));
			thuColumn.setCellValueFactory(new PropertyValueFactory<Weekly, String>("thu"));
			friColumn.setCellValueFactory(new PropertyValueFactory<Weekly, String>("fri"));
			satColumn.setCellValueFactory(new PropertyValueFactory<Weekly, String>("sat"));
			sunColumn.setCellValueFactory(new PropertyValueFactory<Weekly, String>("sun"));
			
			String nextWeek = lastWeekStart.toString();
			String[] str2 = nextWeek.split("-");
			String result = str2[0]+"y"+str2[1]+"m"+str2[2]+"d";
			list = MySQLConnect.getDataWeekly(result);
			viewInWeeklyTabel.setItems(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void rightInWeeklyButton(MouseEvent event) {
		try {
			String thisWeek = dateInWeeklyLabel.getText();
			String[] strtmp = thisWeek.split(" ~ ");
			String strtmp2 = strtmp[0];
			String[] str = strtmp2.split("-");
			int year = Integer.parseInt(str[0]);
			int month = Integer.parseInt(str[1]);
			int dayOfMonth = Integer.parseInt(str[2]);
			LocalDate thisWeekStart = LocalDate.of(year, month, dayOfMonth);
			LocalDate nextWeekStart = thisWeekStart.plusDays(7);
			LocalDate nextWeekEndDate = thisWeekStart.plusDays(13);
			dateInWeeklyLabel.setText(nextWeekStart.toString() +" ~ "+ nextWeekEndDate.toString());
			
			ObservableList<Weekly> list;
			monColumn.setCellValueFactory(new PropertyValueFactory<Weekly, String>("mon"));
			tueColumn.setCellValueFactory(new PropertyValueFactory<Weekly, String>("tue"));
			wedColumn.setCellValueFactory(new PropertyValueFactory<Weekly, String>("wed"));
			thuColumn.setCellValueFactory(new PropertyValueFactory<Weekly, String>("thu"));
			friColumn.setCellValueFactory(new PropertyValueFactory<Weekly, String>("fri"));
			satColumn.setCellValueFactory(new PropertyValueFactory<Weekly, String>("sat"));
			sunColumn.setCellValueFactory(new PropertyValueFactory<Weekly, String>("sun"));
			
			String nextWeek = nextWeekStart.toString();
			String[] str2 = nextWeek.split("-");
			String result = str2[0]+"y"+str2[1]+"m"+str2[2]+"d";
			list = MySQLConnect.getDataWeekly(result);
			viewInWeeklyTabel.setItems(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void complete1Button(ActionEvent event) {	
		String dateTmp = dateInDailyLabel.getText();
		int number = 1;
		Complete com = new Complete();
		com.complete(dateTmp, number);
		initialize();
	}
	public void complete2Button(ActionEvent event) {
		String dateTmp = dateInDailyLabel.getText();
		int number = 2;
		Complete com = new Complete();
		com.complete(dateTmp, number);
		initialize();
	}
	public void complete3Button(ActionEvent event) {
		String dateTmp = dateInDailyLabel.getText();
		int number = 3;
		Complete com = new Complete();
		com.complete(dateTmp, number);
		initialize();
	}
	public void complete4Button(ActionEvent event) {
		String dateTmp = dateInDailyLabel.getText();
		int number = 4;
		Complete com = new Complete();
		com.complete(dateTmp, number);
		initialize();
	}
	public void complete5Button(ActionEvent event) {
		String dateTmp = dateInDailyLabel.getText();
		int number = 5;
		Complete com = new Complete();
		com.complete(dateTmp, number);
		initialize();
	}
	public void complete6Button(ActionEvent event) {
		String dateTmp = dateInDailyLabel.getText();
		int number = 6;
		Complete com = new Complete();
		com.complete(dateTmp, number);
		initialize();
	}
	public void complete7Button(ActionEvent event) {
		String dateTmp = dateInDailyLabel.getText();
		int number = 7;
		Complete com = new Complete();
		com.complete(dateTmp, number);
		initialize();
	}
	public void complete8Button(ActionEvent event) {
		String dateTmp = dateInDailyLabel.getText();
		int number = 8;
		Complete com = new Complete();
		com.complete(dateTmp, number);
		initialize();
	}
	public void complete9Button(ActionEvent event) {
		String dateTmp = dateInDailyLabel.getText();
		int number = 9;
		Complete com = new Complete();
		com.complete(dateTmp, number);
		initialize();
	}
}
