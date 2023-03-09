import java.util.ArrayList;

public class Cart {
	private ArrayList<Product> items = new ArrayList<Product>();
	private double total = 0;
	// private double taxRate;

	public void addItem(Product product) {
		items.add(product);
		total += product.getPrice();
		System.out.println("The total is " + total);
	}
	// public void showDetails() {}
	// public boolean checkout() {}
}