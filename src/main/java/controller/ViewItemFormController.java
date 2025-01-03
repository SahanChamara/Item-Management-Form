package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import db.DBConnection;
import model.Item;

public class ViewItemFormController {
    public TableView tblItem;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colQty;
    public TableColumn colPrice;
    public TableColumn colDescription;

    public void btnReloadOnAction(ActionEvent actionEvent) {
        loadTable();
        System.out.println("btn click");
    }

    private void loadTable() {
        ObservableList<Item> itemObservableList = FXCollections.observableArrayList();
        colId.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

        DBConnection.getInstance().getConnection().forEach(items -> {
            itemObservableList.add(items);
        });

        tblItem.setItems(itemObservableList);
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        Item selecItem = (Item) tblItem.getSelectionModel().getSelectedItem();

        if (selecItem != null) {
            DBConnection.getInstance().getConnection().remove(selecItem);
            tblItem.getItems().remove(selecItem);
        } else {
            System.out.println("Item Is Not Selected");
        }
    }
}
