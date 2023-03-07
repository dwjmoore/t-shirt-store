import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Product crewNeck = new Product("Crew Neck", 20.00);
		Product vNeck = new Product("V-Neck", 20.00);
		Product polo = new Product("Polo", 25.50);
		Product boatNeck = new Product("Boat Neck", 30.25);
		Product tankTop = new Product("Tank Top", 15.75);
		Product[] products = {crewNeck, vNeck, polo, boatNeck, tankTop};
		Shop shop = new Shop(products);
		
		Menu menu = new Menu(new Scanner(new InputStreamReader(System.in, Charset.forName("UTF-8"))), shop);
		
		menu.greet();
		menu.executeMenu();
	}
}