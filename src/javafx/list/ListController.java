package javafx.list;

import javafx.Main;
import javafx.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.create.CreateController;
import javafx.edit.EditController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ListController implements Initializable {
    public static ObservableList<Student> ls = FXCollections.observableArrayList();

    public TableView<Student> tbStudents;
    public TableColumn<Student,String> cName;
    public TableColumn<Student,String> cEmail;
    public TableColumn<Student,Integer> cMark;
    public TableColumn<Student,String> cGender;
    public TableColumn<Student, Button> cAction;
    public TextField txtSearch;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        cMark.setCellValueFactory(new PropertyValueFactory<>("mark"));
        cGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        cAction.setCellValueFactory(new PropertyValueFactory<>("edit"));

        if(ls.size() == 0){
            ls.add(new Student("Nguyễn Hoàng Long","longnh@gmail.com",2,"Nam"));
            ls.add(new Student("Phan Hoàng Anh","anhph@gmail.com",4,"Nam"));
            ls.add(new Student("Vũ Thế Anh","anhvt@gmail.com",4,"Nam"));
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
