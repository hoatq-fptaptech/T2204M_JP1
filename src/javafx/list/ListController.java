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
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class ListController implements Initializable {
    public ListView<Student> lv;

    public static ObservableList<Student> ls = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lv.setItems(ls);
    }

    public void createStudent(ActionEvent event) throws Exception{
        Parent createForm = FXMLLoader.load(getClass().getResource("../create/create.fxml"));
        Scene sc = new Scene(createForm,800,600);
        Main.rootStage.setScene(sc);
    }

    public void edit(){
        try {
            if(lv.getSelectionModel().getSelectedItem() == null){
                throw new Exception("Vui lòng chọn sinh viên muốn sửa!");
            }
            EditController.editedStudent = lv.getSelectionModel().getSelectedItem();
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
