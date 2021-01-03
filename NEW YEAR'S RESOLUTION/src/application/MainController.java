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
	private TableColumn<Daily, String> goal_detailInDailyColumn;
	@FXML
	private TableColumn<Daily, String> completeOrNotColumn;
	@FXML
	private Button incomplete1Button;
	@FXML
	private ImageView leftInDailyButton;
	@FXML
	private ImageView rigthtInDailyButton;

	// weekly page
	@FXML
	private AnchorPane weeklyAnchorPane;
	@FXML
	private Label dateInWeeklyLabel;
	@FXML
	private TableView<?> viewInWeeklyTabel;
	@FXML
    private TableColumn<?, ?> monColumn;
    @FXML
    private TableColumn<?, ?> tueColumn;
    @FXML
    private TableColumn<?, ?> wedColumn;
    @FXML
    private TableColumn<?, ?> thuColumn;
    @FXML
    private TableColumn<?, ?> friColumn;
    @FXML
    private TableColumn<?, ?> satColumn;
    @FXML
    private TableColumn<?, ?> sunColumn;
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
    private TableColumn<goals, String> goal_detailColumn;
    @FXML
    private TableColumn<goals, String> simple_nameColumn;
    @FXML
    private TableColumn<goals, String> registration_dateColumn;
    @FXML
    private TableColumn<goals, Integer> completeColumn;
    @FXML
    private TableColumn<goals, Integer> incompleteColumn;


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
		goal_detailColumn.setCellValueFactory(new PropertyValueFactory<goals, String>("goal_detail"));
		simple_nameColumn.setCellValueFactory(new PropertyValueFactory<goals, String>("simple_name"));
		registration_dateColumn.setCellValueFactory(new PropertyValueFactory<goals, String>("registration_date"));
		completeColumn.setCellValueFactory(new PropertyValueFactory<goals, Integer>("complete"));
		incompleteColumn.setCellValueFactory(new PropertyValueFactory<goals, Integer>("incomplete"));
		
		list = MySQLConnect.getDataGoals();
		viewInGoalManageTabel.setItems(list);
		
		
		//일간화면 페이지
		String today = LocalDate.now().toString();
		String[] str = today.split("-");
		String result = str[0]+"y"+str[1]+"m"+str[2]+"d";
		
		ObservableList<Daily> list2;
		goal_detailInDailyColumn.setCellValueFactory(new PropertyValueFactory<Daily, String>("goal_detail"));
		completeOrNotColumn.setCellValueFactory(new PropertyValueFactory<Daily, String>("complete"));
		list2 = MySQLConnect.getDataDaily(result);
		viewInDailyTabel.setItems(list2);
		
		dateInDailyLabel.setText(today);
		
	}
	
	public void updateTable() {
		ObservableList<goals> list;
		
		goal_detailColumn.setCellValueFactory(new PropertyValueFactory<goals, String>("goal_detail"));
		simple_nameColumn.setCellValueFactory(new PropertyValueFactory<goals, String>("simple_name"));
		registration_dateColumn.setCellValueFactory(new PropertyValueFactory<goals, String>("registration_date"));
		completeColumn.setCellValueFactory(new PropertyValueFactory<goals, Integer>("complete"));
		incompleteColumn.setCellValueFactory(new PropertyValueFactory<goals, Integer>("incomplete"));
		
		list = MySQLConnect.getDataGoals();
		viewInGoalManageTabel.setItems(list);
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
			String newGoal = newGoalTextField.getText();
			String simpleName = simpleNameTextField.getText();
			String today = LocalDate.now().toString();
			int defaultComplete = 0;
			int defaultIncomplete = 0;
			
			StringBuilder sb = new StringBuilder();
			String SQL = sb.append("INSERT INTO all_goals VALUES(")
					.append("'"+newGoal+"',")
					.append("'"+simpleName+"',")
					.append("'"+today+"',")
					.append(defaultComplete+",")
					.append(defaultIncomplete+")")
					.toString();
			st.executeUpdate(SQL);
			newGoalTextField.setText("");
			simpleNameTextField.setText("");
			updateTable();
			InfoTextField.setText("성공적으로 목표를 등록하였습니다.");
			infoAnchorPane.setVisible(true);
		} catch (Exception e) {
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
	
	public void incomplete1Button(ActionEvent event) {
		try {
			incomplete1Button.setText("완료");
			incomplete1Button.setStyle("-fx-background-color: blue");
			
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
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
