package javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ContactController implements Initializable {
    public TextField txtName;
    public TextField txtEmail;
    public ListView<Contact> lv;

    private ObservableList<Contact> ls = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ls.add(new Contact("Nguyễn Trường Giang","giang@gmail.com"));
        ls.add(new Contact("Nguyễn Hoàng Long","long@gmail.com"));
        print();
    }

    public void submit(ActionEvent actionEvent) {
        String name = txtName.getText();
        String email = txtEmail.getText();
       // System.out.println("Submitted..."+name);
        Contact ct = new Contact(name,email);
        ls.add(ct);
        print();
    }

    public void print(){
        lv.setItems(ls);
    }
}
