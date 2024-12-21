package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.db.DBConnection;
import org.example.model.Item;

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
            String itemId = String.valueOf(itemIdCount++);
            String itemName = txtItemName.getText();
            Integer qty = Integer.parseInt(txtQty.getText());
            Double price = Double.parseDouble(txtPrice.getText());
            String description = txtDescription.getText();

            lblId.setText(itemId);

            boolean isAdded = DBConnection.getInstance().getConnection().add(new Item(itemId, itemName, qty, price, description));
            System.out.println(new Item(itemId, itemName, qty, price, description));
            if (isAdded) {

                System.out.println("item added Succesfull");
            } else {
                System.out.println("item Not Add");
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
        lblId.setText("ITM" + String.format("%04d", itemIdCount));
    }
}
