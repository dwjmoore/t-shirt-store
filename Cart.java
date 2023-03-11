import java.util.ArrayList;

public class Cart {
	private ArrayList<Product> items = new ArrayList<Product>();
	private double total = 0;
	private double taxRate = 0.1;

	public Cart() {}

	public void addItem(Product product) {
		items.add(product);
		total += product.getPrice();
		System.out.printf("%s has been added to your cart.%n", product.getName());
	}

	public void showDetails() {
		StringBuilder detailsSB = new StringBuilder();
		if (items.isEmpty()) {
			detailsSB.append(String.format("The cart is empty. Please add at least one product to see it in the cart.%n"));
		} else {
			appendCartHeaderToStringBuilder(detailsSB);
			appendItemsWithPricesToStringBuilder(detailsSB);
			appendCartTotalsToStringBuilder(detailsSB);
		}
		System.out.print(detailsSB);
	}

	public boolean checkout() {
		if (items.isEmpty()) {
			return false;
		} else {
			System.out.printf("Your total is $%.2f%n", total * (1 + taxRate));
			total = 0;
			items.clear();
			return true;
		}
	}

	private void appendCartHeaderToStringBuilder(StringBuilder sb) {
		sb.append(String.format("--Cart--%n"));
		sb.append(String.format("Item Count: %d%n", items.size()));
	}

	private void appendItemsWithPricesToStringBuilder(StringBuilder sb) {
		sb.append(String.format("Items:%n"));
		for (Product item : items) {
			sb.append(String.format("%s: $%.2f%n", item.getName(), item.getPrice()));
		}
		sb.append(String.format("%n"));
	}

	private void appendCartTotalsToStringBuilder(StringBuilder sb) {
		sb.append(String.format("Pre-Tax Total: $%.2f%n", total));
		sb.append(String.format("Post-Tax Total (%.2f%% Tax): $%.2f%n", taxRate * 100, total * (1 + taxRate)));
	}
}