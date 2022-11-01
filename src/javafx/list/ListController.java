package javafx.list;

import javafx.Main;
import javafx.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.sql.*;

public class ListController implements Initializable {
    public ObservableList<Student> ls = FXCollections.observableArrayList();

    public TableView<Student> tbStudents;
    public TableColumn<Student,String> cName;
    public TableColumn<Student,String> cEmail;
    public TableColumn<Student,Integer> cMark;
    public TableColumn<Student,String> cGender;
    public TableColumn<Student, Button> cAction;
    public TextField txtSearch;

    public final static String connectionString = "jdbc:mysql://localhost:3306/t2204m";
    public final static String user = "root";
    public final static String pwd = "root"; // xampp: ""   mamp: "root"

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        cMark.setCellValueFactory(new PropertyValueFactory<>("mark"));
        cGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        cAction.setCellValueFactory(new PropertyValueFactory<>("edit"));

         // lay data tu database cho vao list
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectionString,user,pwd);
            Statement stt = conn.createStatement();
            String sql_txt = "select * from students";
            ResultSet rs = stt.executeQuery(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int mark = rs.getInt("mark");
                String gender = rs.getString("gender");
                Student s = new Student(id,name,email,mark,gender);
                ls.add(s);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        tbStudents.setItems(ls);
    }

    public void createStudent(ActionEvent event) throws Exception{
        Parent createForm = FXMLLoader.load(getClass().getResource("../create/create.fxml"));
        Scene sc = new Scene(createForm,800,600);
        Main.rootStage.setScene(sc);
    }

    public void search(ActionEvent actionEvent) {
        try {
            String s = txtSearch.getText();
            if(s.isEmpty()){
                tbStudents.setItems(ls);
                throw new Exception("Vui lòng nhập từ cần tìm kiếm");
            }

            ObservableList<Student> results = ls.stream()
                    .filter(student -> student.getName().toLowerCase().contains(s.toLowerCase()))
                    .collect(Collectors.toCollection(FXCollections::observableArrayList));
            tbStudents.setItems(results);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }

    }
}
