import java.util.ArrayList;

public class Shop {
	private String name;
	private ArrayList<Product> products;

	public Shop(String name, ArrayList<Product> products) {
		this.name = name;
		this.products = products;
	}

	public String getName() {
		return name;
	}

	public void printProducts() {
		StringBuilder printSB = new StringBuilder(String.format("--Products--%n"));
		for (Product product : products) {
			printSB.append(String.format("ID %d: %s - $%.2f%n" , product.getID(), product.getName(), product.getPrice()));
		}
		System.out.print(printSB);
	}
	
	public int findProduct(String searchText) {
		for (Product product : products) {
			if (searchText.equals(product.getName()))
				return product.getID();
		}
		return -1;
	}

	public Product getProductByID(int id) {
		for (Product product : products) {
			if (id == product.getID()) {
				return products.get(id);
			}
		}
		return null;
	}
}