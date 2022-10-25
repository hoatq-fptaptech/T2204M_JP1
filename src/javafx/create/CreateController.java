package javafx.create;

import javafx.Main;
import javafx.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CreateController {
    public static Student editedStudent;

    public void backToList(ActionEvent event) throws Exception{
        Parent listScene = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        Scene sc = new Scene(listScene,800,600);
        Main.rootStage.setScene(sc);
    }

    public void submit(ActionEvent event) throws Exception{
        // them sv
        // xong
        backToList(null);
    }
}
