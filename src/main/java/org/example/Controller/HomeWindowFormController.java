package org.example.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeWindowFormController {
    public void btnAddItemOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/add_item_form.fxml"))));
        stage.show();
    }

    public void btnViewItemOnAction(ActionEvent actionEvent) {
    }

    public void btnRemoveItemOnAction(ActionEvent actionEvent) {

    }
}
