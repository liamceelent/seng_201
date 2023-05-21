package rugby;

import java.util.HashMap;


public class Athlete {
	
	public String name;
	public String nickName = name;
	public HashMap<String, Integer> stats;
	public int wage;
	public int sellPrice;
	public int buyPrice;
	public int stamina = 100;
	public boolean injured = false;
	public String position;
	public int rarity;
	public String[] attributes = new String[]{"Pace", "Passing", "Defence", "Tackling", "Offence", "Fitness"};
	
	public Athlete(String name, int wage, int sellPrice, int buyPrice, boolean injured, String position, int rarity, int[] value) {
		this.name = name;
		this.nickName = name;
		this.wage = wage;
		this.sellPrice = sellPrice;
		this.buyPrice = buyPrice;
		this.position = position;
		this.rarity = rarity;
		this.stats = new HashMap<String, Integer>();
		
		for (int i = 0; i < 6; i++) {
			this.stats.put(attributes[i], value[i]);
		}
	}
	
	@Override
	public String toString() {
<<<<<<< HEAD
		return String.format("%s, $%d, %d, %s, %d",this.nickName, this.buyPrice, this.stamina, this.position, this.rarity);
=======
		return String.format("%s, %d, %s, %d, %d",this.nickName, this.stamina, this.position, this.rarity, this.buyPrice);
>>>>>>> 4b5065267adf72c10658d32b390d7e94649784ad
	}
	
	public void changeNickName(String changeName){
		this.nickName = changeName;
	}
	
	public void rest(){
		this.stamina = 100;
	}
	
	public void train(String stat){
		stats.put(stat, stats.get(stat) + 1);
	}
	
	public void trainAll(){
		for (String stat : attributes) {
			stats.put(stat, stats.get(stat) + 1);
		}
	}
	
	public void updateRating() {
		int newRating = 0;
		for (int i = 0; i < 6; i++) {
			newRating += this.stats.get(attributes[i]);
		}
		this.rarity = newRating/6;
		this.sellPrice = this.rarity*15;
	}
	
	public void changeValue(int changeValue) {
		this.sellPrice = changeValue;
	}
	
	public void injury() {
		this.injured = true;
	}
	
	public void reduceStamina() {
		this.stamina -= 10;
//		int athleteFitness = this.stats.get("Fitness");
//		if (this.stamina - (100 - athleteFitness) <= 0) {
//			this.stamina = 0;
//			System.out.printf(this.name + " Is now injured due to lack of stamina");
//		}
//		else{
//			this.stamina -= (100 - athleteFitness);  
//		}
	}
	
	public void athleteOptions() {
		System.out.println("Options");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tester = new int[]{1, 2, 3, 4, 6, 90};
		
		Athlete liam = new Athlete("liam", 10, 10, 10, false, "rb", 90, tester);
		liam.changeNickName("test");
		System.out.println(liam.stats);
		liam.reduceStamina();
		System.out.println(liam.stamina);
		
	}

}
