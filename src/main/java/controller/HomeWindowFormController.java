package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeWindowFormController {
    public void btnAddItemOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/add_item_form.fxml"))));
        stage.setX(500);
        stage.setY(500);
        stage.setTitle("Add Item Form");
        stage.show();
    }

    public void btnViewItemOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/view_item_form.fxml"))));
        stage.setX(1300);
        stage.setY(500);
        stage.setTitle("View Item Form");
        stage.show();
    }

    public void btnRemoveItemOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/remove_item_form.fxml"))));
        stage.setX(1300);
        stage.setY(500);
        stage.setTitle("Remove Item Form");
        stage.show();
    }
}
