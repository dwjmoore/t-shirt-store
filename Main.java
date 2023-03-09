import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.ArrayList;

class Main {
	public static void main(String[] args) {
		Product crewNeck = new Product(0, "Crew Neck", 20.00);
		Product vNeck = new Product(1, "V-Neck", 20.00);
		Product polo = new Product(2, "Polo", 25.50);
		Product boatNeck = new Product(3, "Boat Neck", 30.25);
		Product tankTop = new Product(4, "Tank Top", 15.75);
		
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(crewNeck);
		products.add(vNeck);
		products.add(polo);
		products.add(boatNeck);
		products.add(tankTop);

		Shop shop = new Shop("T-Shirt Mart", products);
		Cart cart = new Cart(shop);
		Menu menu = new Menu(new Scanner(new InputStreamReader(System.in, Charset.forName("UTF-8"))), shop, cart);
		
		
		menu.greet();
		menu.executeMenu();
	}
}