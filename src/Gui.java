import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class Gui {
	public static void gui(String[] sstoc, float price2, int y, float invested, float wealth2) throws IOException {
		System.out.println("DEBUG - Your Buying Power is begin "+wealth2);
		JFrame f = new JFrame("Stonkonimics");
		f.setSize(400,500);
		JButton buy = new JButton("BUY");
		JButton sell = new JButton("SELL");
		JButton wait = new JButton("WAIT");
		JTextArea t = new JTextArea();
		t.setEditable(false);
		JTextArea invest = new JTextArea();
		t.setEditable(false);
		JTextArea buying = new JTextArea();
		t.setEditable(false);
		JPanel norm = new JPanel();
		JPanel money = new JPanel();
		JPanel text = new JPanel(new FlowLayout(FlowLayout.CENTER));
		money.add(invest);
		money.add(buying);
		norm.add(buy);
		norm.add(sell);
		norm.add(wait);
		text.add(t);
	    f.add(norm,BorderLayout.SOUTH);
	    f.add(text,BorderLayout.CENTER);
	    f.add(money,BorderLayout.NORTH);
		f.setVisible(true);
		invested = 0;
		invested = invested + wealth2;
		while (true) {
			for (int s = 0; s < sstoc.length; s++) {
			     if (sstoc[s] != null) {
			Map<String, Stock> stocks = YahooFinance.get(sstoc);
			Stock sto = stocks.get(sstoc[s]);
			BigDecimal price = sto.getQuote().getPrice();
			float price3 = price.floatValue();
			invested = invested + price3;
			     }
		}
		System.out.println("Your stats\nYour buying power is "+wealth2+"\nYour Total money invested is "+invested+"\nThe stocks you own:");
		for (int s = 0; s < sstoc.length; s++) {
		     if (sstoc[s] != null) {
			System.out.println(sstoc[s]);
		     }
		}
		System.out.println("DEBUG - Your Buying Power is "+wealth2);
		String wealth21 = String.valueOf(wealth2);
		String invested1 = String.valueOf(invested);
		invest.setText(invested1);
		buying.setText(wealth21);
		invested = 0;
		invested = invested + wealth2;
		System.out.println("Thank you and see you next minute");
		try {
			Thread.sleep(10 * 1000);
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
		}
		//Scanner scanner = new Scanner(System.in);
	    buy.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    	            t.setText("TEST");  
	    	        }  
	    	    });  
	    }
	}

	}
