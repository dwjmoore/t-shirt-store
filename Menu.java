import java.util.Scanner;

public class Menu {
	private Shop shop;

	private String[] menuOptions = {
			"Exit",
			"List Products",
			"Buy Product",
			"Find Product",
			"Show Cart",
			"Checkout"
	};

	private Scanner scanner;

	public Menu(Scanner scanner, Shop shop) {
		this.scanner = scanner;
		this.shop = shop;
	}

	public void executeMenu() {
		while (true) {
			printMenu();
			int option = getNextIntFromUser();

			if (option == 0)
				break;
			if (option == 1)
				shop.printProducts();

			if (option == 3) {
				System.out.println("Enter the item to search for:");
				String itemToFind = getNextStringLineFromUser();
				int productId = shop.findProduct(itemToFind);
				if (productId != -1) {
					System.out.println(itemToFind + " was found and its product id is " + productId);
				} else {
					System.out.println("That product was not found.");
				}
			}
		}

		exit();
	}

	public void greet() {
		System.out.println("Hello. Please enter your name:");
		String name = scanner.nextLine();
		System.out.println("Welcome " + name + " to " + shop.getName());
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