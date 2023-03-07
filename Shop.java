public class Shop {
	private Product[] products;

	public Shop() {
		
	}

	public Shop(Product[] products) {
		this.products = products;
	}

	public void printProducts() {
		System.out.println("--Products--");
		for (int i = 0; i < products.length; i++) {
			System.out.print("ID " + i + ": ");
			System.out.printf("%s - $%.2f%n" , products[i].getName(), products[i].getPrice());
		}
	}
	
	public int findProduct(String searchText) {
		int id = -1;
		for (int i = 0; i < products.length; i++) {
			if (searchText.equals(products[i].getName()))
				id = i;
		}
		return id;
	}
	
}