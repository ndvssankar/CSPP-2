
public class ShoppingCart {
    List<Item> catalog;
    List<Item> cart;
    boolean applyCoupon = false;
    float couponCode;
    public ShoppingCart() {
        catalog = new List<Item>();
        cart = new List<Item>();
    }

    public void addItemToCatalog(Item item) {
        catalog.add(item);
    }

    public Item getItem(String itemName) {
        for (int i = 0; i < catalog.size(); i++) {
            if (itemName.equals(catalog.get(i).getItemName())) {
                return catalog.get(i);
            }
        }
        return null;
    }

    public void removeItemFromCart(Item item) {
        Item cartItem = getItemFromCart(item.getItemName());
        Item catalogItem = getItem(item.getItemName());
        if (cartItem != null) {
            if (cartItem.getQuantity() == item.getQuantity()) {
                int index = cart.indexOf(item);
                cart.remove(index);
                catalogItem.setQuantity(catalogItem.getQuantity() + item.getQuantity());
            } else {
                catalogItem.setQuantity(catalogItem.getQuantity() + item.getQuantity());
                cartItem.setQuantity(cartItem.getQuantity() - item.getQuantity());
                // cartItem.setPrice(catalogItem.getPrice() * cartItem.getQuantity());
            }
        }
    }

    public Item getItemFromCart(String itemName) {
        for(int i=0; i<cart.size(); i++) {
            if(itemName.equals(cart.get(i).getItemName())) {
                return cart.get(i);
            }
        }
        return null;
    }

    public void addItemToCart(Item item) {
        Item catalogItem = getItem(item.getItemName());
        if(catalogItem != null) {
            if (catalogItem.getQuantity() >= item.getQuantity()) {
                catalogItem.setQuantity(catalogItem.getQuantity() - item.getQuantity());
                // item.setPrice(catalogItem.getPrice() * item.getQuantity());
                item.setPrice(catalogItem.getPrice());
                cart.add(item);
            }
        }
    }

    public void showCatalog() {
        for(int i=0; i<catalog.size(); i++) {
            System.out.println(catalog.get(i));
        }
    }
    
    public void showCart() {
        for(int i=0; i<cart.size(); i++) {
            Item item = cart.get(i);
            System.out.println(item.getItemName() + " " +item.getQuantity());
        }
    }

    public float getPayableAmount() {
        float totalAmount = getTotalAmount();
        totalAmount += (totalAmount * 0.15f);
        return totalAmount;
    }

    public float getTotalAmount() {
        float totalAmount = 0.0f;
        for(int i=0; i<cart.size(); i++) {
            Item item = cart.get(i);
            totalAmount += item.getPrice() * item.getQuantity();
        }
        return totalAmount;
    }

    public void applyCoupon(String couponCode) {
        if(applyCoupon == false) {
            if (couponCode.equals("IND10"))
                this.couponCode = 0.1f;
            else if (couponCode.equals("IND20"))
                this.couponCode = 0.2f;
            else if (couponCode.equals("IND30"))
                this.couponCode = 0.3f;
            else if (couponCode.equals("IND50"))
                this.couponCode = 0.5f;
            applyCoupon = true;
        }
    }

    public void printInvoice() {
        float totalAmount = 0.0f;
        System.out.println("Name   quantity   Price");
        for(int i=0; i<cart.size(); i++) {
            Item item = cart.get(i);
            System.out.println(item.getItemName() + " " + item.getQuantity() + " " + item.getPrice());
        }
        System.out.println("totalAmount: " + getTotalAmount());
        System.out.println("Total:" + getTotalAmount());
        if (applyCoupon) {
            totalAmount = getTotalAmount();
            totalAmount = totalAmount - (totalAmount * couponCode);
            System.out.println("Tax: " +  totalAmount * 0.15);
        } else {
            System.out.println("Disc%:" + 0.0);
            System.out.println("Tax:" + getTotalAmount() * 0.15);
        }
        System.out.println("Payable amount: " + getPayableAmount());
    }
}