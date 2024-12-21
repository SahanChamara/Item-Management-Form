package org.example.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.db.DBConnection;
import org.example.model.Item;

import java.util.List;

public class AddItemFormController {
    public TextField txtItemName;
    public TextField txtQty;
    public TextField txtPrice;
    public TextArea txtDescription;
    public Label lblId;

    public void btnAddItemOnAction(ActionEvent actionEvent) {
        String itemId = lblId.getText();
        String itemName = txtItemName.getText();
        Integer qty = Integer.parseInt(txtQty.getText());
        Double price = Double.parseDouble(txtPrice.getText());
        String description = txtDescription.getText();


        DBConnection.getInstance().getConnetion().add(new Item(itemId,itemName,qty,price,description));

    }
}
