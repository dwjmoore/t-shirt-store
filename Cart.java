import java.util.ArrayList;

public class Cart {
	private Shop shop;
	
	private ArrayList<Product> items = new ArrayList<Product>();
	private double total = 0;
	private double taxRate = 0.1;

	public Cart(Shop shop) {
		this.shop = shop;
	}

	public void addItem(Product product) {
		items.add(product);
		total += product.getPrice();
	}

	public void showDetails() {
		if (items.isEmpty()) {
			System.out.println("The cart is empty. Please add at least one product to see it in the cart.");
		} else {
			System.out.println("--Cart--");
			System.out.println("Item Count: " + (int) items.size());
			System.out.println("Items:");
			for (Product item : items) {
				System.out.printf("%s: $%.2f%n", item.getName(), item.getPrice());
			}
			System.out.println();
			System.out.printf("Pre-Tax Total: $%.2f%n", total);
			System.out.printf("Post-Tax Total (%.2f%% Tax): $%.2f%n", taxRate * 100, total * (1 + taxRate));
		}
	}

	public void checkout() {
		if (items.isEmpty()) {
			System.out.println("The cart is currently empty. Please add at least one product to check out.");
		} else {
			System.out.printf("Your total is $%.2f%n%n", total * (1 + taxRate));
			System.out.printf("Thank you for shopping at %s.%n", shop.getName());
			total = 0;
			items.removeAll(items);
		}
	}
}