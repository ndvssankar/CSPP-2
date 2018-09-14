
public class Item {
    private String productName;
    private int quantity;
    private float unitPrice;

    public Item(final String productName,
        final int quantity,
        final float unitPrice) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }
     
    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }
     
    public int getQuantity() {
        return quantity;
    }
     
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
     
    public String getProductName() {
        return productName;
    }
     
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean equals(Object item) {
        Item myItem = (Item)item;
        return this.getProductName().equals(myItem.getProductName());
    }

    public String toString() {
        return this.getProductName() + " " + this.getQuantity() + " " + this.getUnitPrice();
    }
}