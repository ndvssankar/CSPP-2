import java.util.Scanner;

/**
 * Solution class for Shopping Cart.
 * @author Siva Sankar
 */
public final class Solution {
    /**
     * private constructor.
     */
    private Solution() {

    }

    /**
     * main method to demonstrate shopping cart.
     * @param args command line args.
     */
    public static void main(final String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String[] words = scan.nextLine().split(" ");
            switch (words[0]) {
            case "Item":
                String[] vals = words[1].split(",");
                cart.addToCatalog(new Item(
                                      vals[0], Integer.parseInt(vals[1]),
                                      Float.parseFloat(vals[2])));
                break;
            case "catalog":
                cart.showCatalog();
                break;
            case "add":
                vals = words[1].split(",");
                cart.addToCart(new Item(
                                   vals[0], Integer.parseInt(vals[1]), 0.0f));
                break;
            case "show":
                cart.showCart();
                break;
            case "totalAmount":
                System.out.println("totalAmount: " + cart.getTotalAmount());
                break;
            case "payableAmount":
                System.out.println("Payable amount: "
                                   + cart.getPayableAmount());
                break;
            case "remove":
                vals = words[1].split(",");
                cart.removeFromCart(new Item(
                                        vals[0], Integer.parseInt(vals[1]),
                                        0.0f));
                break;
            case "print":
                cart.printInvoice();
                break;
            case "coupon":
                cart.applyCoupon(words[1]);
                break;
            default:
                break;
            }
        }
    }
}

