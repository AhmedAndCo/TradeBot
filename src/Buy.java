import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class Buy {
	public static float price3;
@SuppressWarnings("resource")
public static void buy(float wealth, String[] sstoc, int y, float invested) throws IOException {
		System.out.println(y);
		Scanner scanner = new Scanner(System.in);
		System.out.println("What do you want to buy enter in TSLA or anything listed on yahoo finance");
		String thing = scanner.nextLine();
		Stock stocks = YahooFinance.get(thing);
		BigDecimal price = stocks.getQuote().getPrice();
		float price2 = price.floatValue();
		System.out.println(price2);
		System.out.println("How many stocks?");
		int much = scanner.nextInt();
		for (int i = 0;i < much;i++) {
			price3 = price3 + price2;
		}
		if (wealth > price3) {
		invested = wealth; 
		String[] stonk = sstoc;
		System.out.println("Your wealth is "+wealth+" Your stock is "+stonk[y]);
		System.out.println("Wanna buy or sell or wait say NOW");
		System.out.println("DEBUG - Your Buying Power is "+wealth);
		wealth = wealth - price3;
		for (int i = 0;i < much;i++) {
		sstoc[y] = thing;
		System.out.println("DEBUG - stonk is "+sstoc[y]);
		y = y + 1;
		}
		float wealth2 = wealth;
		System.out.println("DEBUG - wealth"+wealth);
		String wat = scanner.nextLine();
		switch (wat) {
		case "buy": Buy.buy(wealth, sstoc, y, invested);
		case "sell": Sell.sell(sstoc, price2, y, invested);
		case "wait": Gui.gui(sstoc, price2, y, invested, wealth2);
		default: Gui.gui(sstoc, price2, y, invested, wealth2);
		}
		}
		else {
			System.out.println("Too poor lol to be added in the future.");
		}
}
}
