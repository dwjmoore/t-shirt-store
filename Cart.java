import java.util.ArrayList;

public class Cart {
	private ArrayList<Product> items = new ArrayList<Product>();
	private double total = 0;
	private double taxRate = 0.1;

	public void addItem(Product product) {
		items.add(product);
		total += product.getPrice();
	}
	
	public void showDetails() {
		System.out.println("--Cart--");
		System.out.println("Item Count: " + (int)items.size());
		System.out.println("Items:");
		for (Product item : items) {
			System.out.printf("%s: $%.2f%n", item.getName(), item.getPrice());
		}
		System.out.println();
		System.out.printf("Pre-Tax Total: $%.2f%n", total);
		System.out.printf("Post-Tax Total: $%.2f%n", total * (1 + taxRate));
	}
	// public boolean checkout() {}
}

// total = preTaxTotal + preTaxTotal * taxRate = preTaxTotal * (1 + taxRate)

// preTaxTotal = total / (1 + taxRate)