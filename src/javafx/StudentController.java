package javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.Comparator;

public class StudentController {
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtMark;
    public ListView<Student> lvStudents;

    ObservableList<Student> ls = FXCollections.observableArrayList();

    private boolean sortName = true;


    public void submit(ActionEvent event) {
        try{
            String name = txtName.getText();
            String email = txtEmail.getText();
            Integer mark = Integer.parseInt(txtMark.getText());
            if(mark < 0 || mark > 10)
                throw new Exception("Vui lòng nhập điểm trong khoảng 0 -> 10");
            //ls.add(new Student(name,email,mark));
            lvStudents.setItems(ls);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }

    }

    public void sortByName(ActionEvent event) {
        Collections.sort(ls, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return sortName?o1.getName().compareTo(o2.getName()):o2.getName().compareTo(o1.getName());
            }
        });
        sortName = !sortName;
        lvStudents.refresh();
    }

    public void goToContact(ActionEvent event) throws Exception{
        Parent contactPage = FXMLLoader.load(getClass().getResource("contact.fxml"));
        Scene sc = new Scene(contactPage,800,600);
        Main.rootStage.setTitle("Contact JavaFX");
        Main.rootStage.setScene(sc);
    }
}
