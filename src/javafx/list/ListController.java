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
import java.util.ResourceBundle;

public class ListController implements Initializable {
    public static ObservableList<Student> ls = FXCollections.observableArrayList();

    public TableView<Student> tbStudents;
    public TableColumn<Student,String> cName;
    public TableColumn<Student,String> cEmail;
    public TableColumn<Student,Integer> cMark;
    public TableColumn<Student,String> cGender;
    public TableColumn<Student, Button> cAction;

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
        }
        tbStudents.setItems(ls);
    }

    public void createStudent(ActionEvent event) throws Exception{
        Parent createForm = FXMLLoader.load(getClass().getResource("../create/create.fxml"));
        Scene sc = new Scene(createForm,800,600);
        Main.rootStage.setScene(sc);
    }

    public void edit(){
        try {
            if(tbStudents.getSelectionModel().getSelectedItem() == null){
                throw new Exception("Vui lòng chọn sinh viên muốn sửa!");
            }
            EditController.editedStudent = tbStudents.getSelectionModel().getSelectedItem();
            Parent editForm = FXMLLoader.load(getClass().getResource("../edit/edit.fxml"));
            Scene sc = new Scene(editForm,800,600);
            Main.rootStage.setScene(sc);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }

    }
}
