
public class Item {

    private String itemName;
    private int quantity;
    private float price;

    public Item() {

    }

    public Item(final String itemName,
        final int quantity,
        final float price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }
     
    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }
     
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
     
    public String getItemName() {
        return itemName;
    }
     
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String toString() {
        return this.getItemName() + " " +
        this.getQuantity() + " " +
        this.getPrice();
    }
}