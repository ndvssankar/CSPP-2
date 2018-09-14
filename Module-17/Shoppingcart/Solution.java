import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			String[] words = scan.nextLine().split(" ");
			switch(words[0]) {
				case "Item":
					String[] tokens = words[1].split(",");
					cart.addItemToCatalog(new Item(
						tokens[0],
						Integer.parseInt(tokens[1]),
						Float.parseFloat(tokens[2])));
					break;
				case "catalog":
					cart.showCatalog();
					break;
				case "show":
					cart.showCart();
					break;
				case "totalAmount":
					System.out.println("totalAmount: " + cart.getTotalAmount());
					break;
				case "add":
					tokens = words[1].split(",");
					cart.addItemToCart(new Item(tokens[0],
						Integer.parseInt(tokens[1]),
						0.0f));
					break;
				case "remove":
					tokens = words[1].split(",");
					cart.removeItemFromCart(new Item(
						tokens[0],
						Integer.parseInt(tokens[1]),
						0.0f));
					break;
				case "payableAmount":
					System.out.println("PayableAmount: " + cart.getPayableAmount());
					break;
				case "print":
					cart.printInvoice();
					break;
				default:
					break;
			}
		}
	}
}