import java.util.Scanner;

public class Menu {
	private Shop shop;
	private Cart cart;

	private String[] menuOptions = {
			"Exit",
			"List Products",
			"Buy Product",
			"Find Product",
			"Show Cart",
			"Checkout"
	};

	private Scanner scanner;

	public Menu(Scanner scanner, Shop shop, Cart cart) {
		this.scanner = scanner;
		this.shop = shop;
		this.cart = cart;
	}

	public void executeMenu() {
		printMenu();
		int option = getNextIntFromUser();
		while (option != 0) {
			handleShopperOptionSelection(option);
			printMenu();
			option = getNextIntFromUser();
		}
		exit();
	}

	public void greet() {
		System.out.println("Hello. Please enter your name:");
		String name = scanner.nextLine();
		System.out.printf("%nWelcome %s to %s%n", name, shop.getName());
	}

	private void printMenu() {
		StringBuilder printMenuSB = new StringBuilder();
		printMenuSB.append(String.format("%n--Main Menu--%n"));
		printMenuSB.append(String.format("Select an option using one of the numbers shown%n%n"));
		for (int i = 0; i < menuOptions.length; i++) {
			printMenuSB.append(String.format("%d: %s%n", i, menuOptions[i]));
		}
		System.out.print(printMenuSB);
	}

	private void handleShopperOptionSelection(int option) {
		if (option == 1) {
			shop.printProducts();
		} else if (option == 2) {
			addItemToCart();
		} else if (option == 3) {
			findProduct();
		} else if (option == 4) {
			cart.showDetails();
		} else if (option == 5) {
			checkout();
		} else {
			System.out.println("Selection not valid.");
		}
	}

	private void addItemToCart() {
		System.out.println("Please enter the ID of the product you would like to purchase:");
		int productID = getNextIntFromUser();
		Product product = shop.getProductByID(productID);
		if (product != null) {
			cart.addItem(product);
		} else {
			System.out.println("That item ID is invalid and could not be added to the cart.");
		}
	}

	private void findProduct() {
		System.out.println("Enter the item to search for:");
		String itemToFind = getNextStringLineFromUser();
		int productID = shop.findProduct(itemToFind);
		if (productID != -1) {
			System.out.printf("%s was found and its product id is %d", itemToFind, productID);
		} else {
			System.out.println("That product was not found.");
		}
	}

	private void checkout() {
		if (cart.checkout()) {
			System.out.printf("Thank you for shopping at %s.%n", shop.getName());
		} else {
			System.out.println("Your cart is currently empty. Please add at least one product to check out.");
		}
	}

	private int getNextIntFromUser() {
		return scanner.nextInt();
	}

	private String getNextStringLineFromUser() {
		scanner.nextLine();
		return scanner.nextLine();
	}

	private void exit() {
		System.out.println("Exiting now. Goodbye.");
		scanner.close();
	}
}