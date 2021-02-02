import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class Sell {
	@SuppressWarnings("resource")
	public static void sell(String[] sstoc, float wealth, int y, float invested) throws IOException {
		if (y == 0) {
			System.out.println("Get a stock sending you back to where you can buy");
			Buy.buy(wealth, sstoc, y, invested);
		}
		System.out.println("What stonk to sell you have ");
		for (int s = 0; s < sstoc.length; s++) {
		     if (sstoc[s] != null) {
			System.out.println(sstoc[s]);
		     }
		}
		Scanner scanner = new Scanner(System.in);
		String sell = scanner.nextLine();
		Map<String, Stock> work = YahooFinance.get(sstoc);
		BigDecimal price = work.get(sell).getQuote().getPrice();
		float price2 = price.floatValue();
		wealth = wealth - price2;
		invested = wealth; 
		System.out.println("Yo wealth is "+wealth+" Yo have "+sstoc[y]+"hi \n");
		y = y - 1;
		System.out.println("Wanna buy or sell say NOW");
		String wat = scanner.nextLine();
		switch (wat) {
		case "buy": Buy.buy(wealth, sstoc, y, invested);
		case "sell": sell(sstoc, price2, y, invested);
		default: System.out.println("found");
		}
}
}
