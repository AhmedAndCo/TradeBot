import java.io.IOException;
import java.util.Scanner;

public class TradeBot {
	public static float invested;
	static boolean start = false;
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws IOException {
		String[] sstoc = new String[100];
		Scanner scanner = new Scanner(System.in);
		System.out.println("How much money do you have");
		float wealth = scanner.nextFloat();
		float invested = wealth; 
		start(sstoc,wealth);	
		}
	@SuppressWarnings({ "resource", "unused" })
	public static void start(String[] sstoc, float wealth) throws IOException {
		boolean start = true;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Wanna buy or sell say NOW "+wealth);
		String wat2 = scanner.nextLine();
		switch (wat2) {
		case "buy": Buy.buy(wealth, sstoc, 0, invested);
		case "sell": Sell.sell(sstoc, wealth, 0, invested);
		default: System.out.println("found");
	}
}
}
