
public class ShoppingCart {
    List<Item> catalog;
    List<Item> cart;
    float couponCode;
    boolean isCouponApplied;

    public ShoppingCart() {
        catalog = new List<Item>();
        cart =  new List<Item>();
        isCouponApplied = false;
    }

    public void addToCatalog(Item item) {
        int index = catalog.indexOf(item);
        if (index == -1) {
            catalog.add(item);
        }
    }

    public void showCatalog() {
        for (int i = 0; i < catalog.size(); i++) {
            System.out.println(catalog.get(i));
        }
    }

    public void showCart() {
        for (int i = 0; i < cart.size(); i++) {
            Item item = cart.get(i);
            System.out.println(item.getProductName() + " " + item.getQuantity());
        }
    }

    // catalog :
    //  milk 100 10.0
    //  panneer 120 50.0
    //  
    //  cart :
    //   
    //  add milk 30

    public void addToCart(Item item) {
                            //  add milk 30
        int index = catalog.indexOf(item);
        Item catalogItem = catalog.get(index);
        //  milk 70 10.0

        index = cart.indexOf(item);
        Item cartItem = cart.get(index);
        // milk 20 10.0

        if (cartItem != null) {
            cartItem.setQuantity(cartItem.getQuantity() + item.getQuantity());
            catalogItem.setQuantity(catalogItem.getQuantity() - item.getQuantity());
            return;
        }
        if (catalogItem.getQuantity() >= item.getQuantity()) {
            item.setUnitPrice(catalogItem.getUnitPrice());
            cart.add(item);
            catalogItem.setQuantity(catalogItem.getQuantity() - item.getQuantity());
            return;
        }
    }

    public float getTotalAmount() {
        float totalAmount = 0.0f;
        for (int i = 0; i < cart.size(); i++) {
            Item item = cart.get(i);
            totalAmount = totalAmount + item.getQuantity() * item.getUnitPrice();
        }
        return totalAmount;
    }

    public float getPayableAmount() {
        float totalAmount = getTotalAmount();
        float disc = totalAmount * couponCode;
        totalAmount = totalAmount - disc;
        float payableAmount = totalAmount + (totalAmount * 0.15f);
        return payableAmount;
    }

    public void removeFromCart(Item item) {
        int index = catalog.indexOf(item);
        Item catalogItem = catalog.get(index);

        index = cart.indexOf(item);
        Item cartItem = cart.get(index);

        if (cartItem != null) {
            if (cartItem.getQuantity() == item.getQuantity()) {
                cart.remove(index);
            } else {
                cartItem.setQuantity(cartItem.getQuantity() - item.getQuantity());
                catalogItem.setQuantity(catalogItem.getQuantity() + item.getQuantity());
            }
        }
    }

    public void applyCoupon(String coupon) {
        if (isCouponApplied == false) {
            if (coupon.equals("IND10"))
                couponCode = 0.1f;
            else if (coupon.equals("IND20"))
                couponCode = 0.2f;
            else if (coupon.equals("IND30"))
                couponCode = 0.3f;
            else if (coupon.equals("IND50"))
                couponCode = 0.5f;
            else {
                System.out.println("Invalid coupon");
                return;
            }
            isCouponApplied = true;
        }
    }

    public void printInvoice() {
        System.out.println("Name   quantity   Price");
        for (int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i));
        }
        System.out.println("Total:" + getTotalAmount());
        if (isCouponApplied == true) {
            float totalAmount = getTotalAmount();
            float disc = (totalAmount * couponCode);
            System.out.println("Disc%:" + disc);
            totalAmount = totalAmount - disc;
            float tax = totalAmount * 15 / 100;
            System.out.println("Tax:" + tax);
            totalAmount = totalAmount + tax;
            System.out.println("Payable amount: " + totalAmount);
        } else {
            float totalAmount = getTotalAmount();
            System.out.println("Disc%:" + 0.0);
            float tax = totalAmount * 0.15f;
            System.out.println("Tax:" + tax);
            totalAmount = totalAmount + (totalAmount * 0.15f);
            System.out.println("Payable amount: " + totalAmount);
        }
    }
}

