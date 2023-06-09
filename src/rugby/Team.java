package rugby;


import java.util.ArrayList;

/**
 * Class for the clubs team
 * @author sport Joel Bremner & Liam Ceelan-Thomas
 */
public class Team {
	public ArrayList<Athlete> players = new ArrayList<Athlete>();
	private String teamName;
	
	/**
	 * 
	 * @param athlete Athlete to add to team
	 * @return boolean Successful or not
	 */
	public boolean addPlayer(Athlete athlete){
		if (this.players.size() >= GameEnviroment.teamSize) {
			return false;
		}else {
			this.players.add(athlete);
			return true;
		}
	}
	
	/**
	 * get team name 
	 * @return String team name
	 */
	public String getTeamName(){
		return this.teamName;
	}
	
	/**
	 * get team name 
	 * @param name String name to set
	 */
	public void setTeamName(String name){
		this.teamName = name;
	}
	
	/**
	 * 
	 * @param athlete Athlete to remove from team
	 */
	public void removePlayer(Athlete athlete) {
		if (this.players.contains(athlete)) {
			this.players.remove(athlete);
		}
	}
	
	/**
	 * 
	 * @param athlete1 Athlete to swap
	 * @param athlete2 Athlete to swap
	 */
	public void swapPlayer(Athlete athlete1, Athlete athlete2) {
		this.removePlayer(athlete2);
		this.addPlayer(athlete1);
	}
	
	/**
	 * 
	 * @return ArrayList<Athlete> players in team
	 */
	public ArrayList<Athlete> getAthletes(){
		return this.players;
	}
	
	/**
	 *  Reduces stamina of all athletes in team
	 */
	public void reduceStamina() {
		for (Athlete athlete: this.players) {
			athlete.reduceStamina();
		}
	}
	
	/**
	 * Returns all stamina of athletes in team to max
	 */
	public void maxStamina() {
		for (Athlete athlete: this.players) {
			athlete.rest();
		}
	}
	
	/**
	 * Check whether team is ready to play or not
	 * @return boolean whether team is ready to play or not
	 */
	public boolean checkReady() {
		for (Athlete athlete: this.players) {
			if (athlete.getInjury() == true | athlete.getStamina() == 0) {
				return false;
			}
		}
		if (this.getAthletes().size() < GameEnviroment.teamSize){
			return false;
		}
		return true;
	}
	

	/**
	 * Recalculate team ratings
	 * @param team Team Object team to calculate rating
	 * @return int new rating of team
	 */
	public int teamRating(Team team) {
		int overallRating = 0;
		for (int i = 0; i < GameEnviroment.teamSize; i++) {
			int a = team.players.get(i).getRating();
			overallRating += a;
		}
		return overallRating/GameEnviroment.teamSize;
	}
}
