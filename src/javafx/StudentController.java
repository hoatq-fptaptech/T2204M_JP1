package javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

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
            ls.add(new Student(name,email,mark));
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
}
