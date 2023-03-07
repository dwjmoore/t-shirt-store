import java.util.ArrayList;

public class Shop {
	private String name;
	private ArrayList<Product> products;

	public Shop() {
		
	}

	public Shop(String name, ArrayList<Product> products) {
		this.name = name;
		this.products = products;
	}

	public String getName() {
		return name;
	}

	public void printProducts() {
		System.out.println("--Products--");
		for (Product product : products) {
			System.out.printf("ID %d: %s - $%.2f%n" , product.getID(), product.getName(), product.getPrice());
		}
	}
	
	public int findProduct(String searchText) {
		int id = -1;
		for (Product product : products) {
			if (searchText.equals(product.getName()))
				id = product.getID();
		}
		return id;
	}
	
}