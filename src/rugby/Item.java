package rugby;

import java.util.HashMap;

/**
 * class for base level object item
 * @author Joel Bremner & Liam Ceelan-Thomas
 *
 */
public class Item {
	
	private String item;
	public HashMap<String, Integer> stats;
	private int price;
	private int sellPrice;
	public String[] attributes = new String[]{"Pace", "Passing", "Defence", "Tackling", "Offence", "Fitness"};
	
	/**
	 * Constructor
	 * @param item String
	 * @param price int
	 * @param value int
	 */
	public Item(String item, int price, int[] value) {
		this.item = item;
		this.price = price;
		this.stats = new HashMap<String, Integer>();
		this.sellPrice = price - 100;
		
		for (int i = 0; i < 6; i++) {
			this.stats.put(attributes[i], value[i]);
		}
	}
	
	/**
	 * Use item on selected athletes
	 * @param athlete Athlete to use item on
	 * @param item Item to use on athlete
	 */
	public void useItem(Athlete athlete, Item item) {
		for (int i = 0; i < 6; i++) {
			System.out.println(athlete.stats.get(attributes[i]) + (item.stats.get(attributes[i])));
			athlete.stats.put(attributes[i], athlete.stats.get(attributes[i]) + (item.stats.get(attributes[i])));
		}
	}
	
	/**
	 * Price Getter
	 * @return int price of item
	 */
	public int getPrice() {
		return this.price;
	}
	
	/**
	 * Sell price Getter
	 * @return int price of item
	 */
	public int getSellPrice() {
		return this.sellPrice;
	}
	
	/**
	 * Name Getter
	 * @return String name of item
	 */
	public String getName() {
		return this.item;
	}
	
	@Override
	public String toString() {
		return String.format("%s Sell Price: $%d",this.item, this.sellPrice);
	}

}
