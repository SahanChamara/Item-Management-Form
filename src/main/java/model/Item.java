package model;

import java.util.Objects;

public class Item {
    private String itemId;
    private String itemName;
    private Integer qty;
    private Double price;
    private String description;

    public Item() {
    }

    public Item(String itemId, String itemName, Integer qty, Double price, String description) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.qty = qty;
        this.price = price;
        this.description = description;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(itemId, item.itemId) && Objects.equals(itemName, item.itemName) && Objects.equals(qty, item.qty) && Objects.equals(price, item.price) && Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, itemName, qty, price, description);
    }


}
