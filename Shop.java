public class Shop {
	public String[] products;

	public Shop(String[] products) {
		this.products = products;
	}

	public void printProducts() {
		System.out.println("--Products--");
		for (int i = 0; i < products.length; i++) {
			System.out.print("ID " + i + ": ");
			System.out.println(products[i]);
		}
	}

	public int findProduct(String searchText) {
		int id = -1;
		for (int i = 0; i < products.length; i++) {
			if (searchText.equals(products[i]))
				id = i;
		}
		return id;
	}
}