package org.example.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddItemFormController {
    public TextField txtItemName;
    public TextField txtQty;
    public TextField txtPrice;
    public TextArea txtDescription;
    public Label lblId;

    public void btnAddItemOnAction(ActionEvent actionEvent) {
        String ItemName = txtItemName.getText();
        Integer qty = Integer.parseInt(txtItemName.getText());
        Double price = Double.parseDouble(txtPrice.getText());
        String description = txtDescription.getText();




    }
}
