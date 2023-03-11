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
		while (true) {
			printMenu();
			int option = getNextIntFromUser();

			if (option == 0)
				break;

			if (option == 1)
				shop.printProducts();

			if (option == 2) {
				System.out.println("Please enter the ID of the product you would like to purchase:");
				int productID = getNextIntFromUser();
				Product product = shop.getProductByID(productID);
				if (product != null) {
					cart.addItem(product);
				} else {
					System.out.println("That item ID is invalid and could not be added to the cart.");
				}
			}

			if (option == 3) {
				System.out.println("Enter the item to search for:");
				String itemToFind = getNextStringLineFromUser();
				int productID = shop.findProduct(itemToFind);
				if (productID != -1) {
					System.out.printf("%s was found and its product id is %d", itemToFind, productID);
				} else {
					System.out.println("That product was not found.");
				}
			}

			if (option == 4)
				cart.showDetails();

			if (option == 5) {
				if (cart.checkout()) {
					System.out.printf("Thank you for shopping at %s.%n", shop.getName());
				} else {
					System.out.println("Your cart is currently empty. Please add at least one product to check out.");
				}
			}
		}

		exit();
	}

	public void greet() {
		System.out.println("Hello. Please enter your name:");
		String name = scanner.nextLine();
		System.out.printf("Welcome %s to %s", name, shop.getName());
	}

	private void printMenu() {
		System.out.println();
		System.out.println("--Main Menu--");
		System.out.println("Select an option using one of the numbers shown");
		System.out.println();

		for (int i = 0; i < menuOptions.length; i++) {
			System.out.print(i + ": ");
			System.out.println(menuOptions[i]);
		}
	}

	private void exit() {
		System.out.println("Exiting now. Goodbye.");
		scanner.close();
	}

	private int getNextIntFromUser() {
		return scanner.nextInt();
	}

	private String getNextStringLineFromUser() {
		scanner.nextLine();
		return scanner.nextLine();
	}
}