package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import db.DBConnection;
import model.Item;

import java.net.URL;
import java.util.ResourceBundle;

public class AddItemFormController implements Initializable {
    public TextField txtItemName;
    public TextField txtQty;
    public TextField txtPrice;
    public TextArea txtDescription;
    public Label lblId;
    private static int itemIdCount=1;

    public void btnAddItemOnAction(ActionEvent actionEvent) {
        try {
//            String itemId = String.valueOf(itemIdCount++);
//            String itemName = txtItemName.getText();
//            Integer qty = Integer.parseInt(txtQty.getText());
//            Double price = Double.parseDouble(txtPrice.getText());
//            String description = txtDescription.getText();

            lblId.setText(String.valueOf(itemIdCount++));

            boolean isAdded = DBConnection.getInstance().getConnection().add(new Item(String.valueOf(itemIdCount++), txtItemName.getText(), Integer.parseInt(txtQty.getText()), Double.parseDouble(txtPrice.getText()), txtDescription.getText()));

            if (isAdded) {
                Alert addSucsess  = new Alert(Alert.AlertType.INFORMATION);
                addSucsess.setTitle("Add Item Controller");
                addSucsess.setHeaderText("Success");
                addSucsess.setContentText("Item Added Successful");
                addSucsess.show();
            } else {
                Alert notSucsess = new Alert(Alert.AlertType.INFORMATION);
                notSucsess.setTitle("Add Item Controller");
                notSucsess.setHeaderText("Failed");
                notSucsess.setContentText("Item Added Failed");
                notSucsess.show();
            }

            generateId();
            txtItemName.clear();
            txtQty.clear();
            txtPrice.clear();
            txtDescription.clear();

        } catch (NumberFormatException ex) {
            System.out.println("Entered is not a number" + ex.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        generateId();
    }
    private void generateId() {
        itemIdCount = DBConnection.getInstance().getConnection().size() + 1;
        lblId.setText("D" + String.format("%03d", itemIdCount));
    }
}
