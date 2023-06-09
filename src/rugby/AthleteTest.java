package rugby;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public final class AthleteTest {

	@Test
	public void rarityTest() {
		//having two un auto generated player and item so i can see if the changes worked perfectly
		Athlete event = new Athlete("tim", 10, 10, 10, false, "cb", 10, new int[]{10, 10, 10, 10, 10, 10});
		Item fitness = new Item("Fitness Train", 500, new int[]{10, 10, 10, 10, 10, 10});
		
		// when using a item the rarity of the player correctly changes
		
		assertTrue(event.getRating() == 10);
		//using item then updating player rating
		fitness.useItem(event, fitness);
		
		event.updateRating();
		// checking new rating
		assertTrue(event.getRating() == 20);

		
	}	
	
	
	@Test
	public void statOverHundred() {
		
		// making sure that a player can never have a pre-generated stat that is over 100 
		//checking 99 times
		for (int i = 0; i < 99; i++) {
			Athlete event = GameEnviroment.generatePlayer(2);
			for (int p = 0; p < 6; p++) {
				assertTrue(event.stats.get(event.attributes[p]) < 100);
			}
		}
	}
	
	
	@Test
	public void trainAthleteTest() {
		
		//checking if it trains all athletes by one and update rating works
		Athlete event = new Athlete("", 10, 10, 10, false, "", 10, new int[]{10, 10, 10, 10, 10, 10});
		//keeping a constant athlete with unchanged stats
		Athlete constantEvent = new Athlete("", 10, 10, 10, false, "", 10, new int[]{10, 10, 10, 10, 10, 10});
		int startingRating = event.getRating();
		//Training all stats by one
		event.trainAll();
		event.updateRating();
		
		// checking if all attributes have been increased by one
		for (int i = 0; i < 6; i ++) {
			assertTrue(event.stats.get(event.attributes[i]) - constantEvent.stats.get(constantEvent.attributes[i]) == 1);
		}
		
		// checking if rating increased 
		assertTrue(event.getRating() > startingRating);
		
	}
	
	
	@Test
	public void getBuyPrice() {
		// buy price test
		Athlete event = new Athlete("tim", 10, 10, 10, false, "cb", 10, new int[]{10, 10, 10, 10, 10, 10});
		assertTrue(event.getBuyPrice() == 10);
	}	
	
	@Test
	public void getSellPrice() {
		// sell price test
		Athlete event = new Athlete("tim", 10, 10, 10, false, "cb", 10, new int[]{10, 10, 10, 10, 10, 10});
		assertTrue(event.getSellPrice() == 10);
	}	
	@Test
	public void getInjury() {
		// injury test
		Athlete event = new Athlete("tim", 10, 10, 10, false, "cb", 10, new int[]{10, 10, 10, 10, 10, 10});
		assertFalse(event.getInjury());
	}	
	
	@Test
	public void getRating() {
		// rating test
		Athlete event = new Athlete("tim", 10, 10, 10, false, "cb", 10, new int[]{10, 10, 10, 10, 10, 10});
		assertTrue(event.getRating() == 10);
	}	
	
	@Test
	public void getPosition() {
		// position test
		Athlete event = new Athlete("tim", 10, 10, 10, false, "cb", 10, new int[]{10, 10, 10, 10, 10, 10});
		assertTrue(event.getPosition() == "cb");
	}	
	
	
	@Test
	public void getStamina() {
		// stamina test
		Athlete event = new Athlete("tim", 10, 10, 10, false, "cb", 10, new int[]{10, 10, 10, 10, 10, 10});
		assertTrue(event.getStamina() == 100);
	}	
	
	@Test
	public void getWage() {
		// wage test
		Athlete event = new Athlete("tim", 10, 10, 10, false, "cb", 10, new int[]{10, 10, 10, 10, 10, 10});
		assertTrue(event.getWage() == 10);
	}	
	
	@Test
	public void getName() {
		// name test
		Athlete event = new Athlete("tim", 10, 10, 10, false, "cb", 10, new int[]{10, 10, 10, 10, 10, 10});
		assertTrue(event.getName() == "tim");
	}	
	
	@Test
	public void reduceStamina() {
		// stamina test
		Athlete event = new Athlete("tim", 10, 10, 10, false, "cb", 10, new int[]{10, 10, 10, 10, 10, 10});
		event.reduceStamina();
		assertTrue(event.getStamina() == 10);
	}	
	
	@Test
	public void injury() {
		// injury test
		Athlete event = new Athlete("tim", 10, 10, 10, false, "cb", 10, new int[]{10, 10, 10, 10, 10, 10});
		event.injury();
		assertTrue(event.getInjury());
	}	
	
	@Test
	public void changeValue() {
		// change value test
		Athlete event = new Athlete("tim", 10, 10, 10, false, "cb", 10, new int[]{10, 10, 10, 10, 10, 10});
		event.changeValue(30);
		assertTrue(event.getSellPrice() == 30);
	}	




}
