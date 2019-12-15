
public class Player {

	private int gold, level, health, max, potions, healing, maxHealth, specialChance;
	private String name, wand;
	
	public Player(String n) {
		gold = 0;
		level = 1;
		name = n;
		health = 100;
		max = 20;
		potions =0;
		healing = 0;
		maxHealth = health;
		wand = "No Wand";
		specialChance = 20;
	}
	
	public void setMax(int x) {
		max+=x;
	}
	public void setGold(int x) {
		gold+=x;
	}
	
	public void setLevel(int x) {
		level = x;
	}
	
	public void setHealth(int x) {
			health+=x;
	}
	
	public void setHealing(int x) {
		healing+=x;
	}
	
	public void setPotions(int x) {
		potions+=x;
	}
	
	public void setMaxHealth(int x) {
		maxHealth += x;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}
	public String getWand() {
		return wand;
	}
	
	public void setWand(String x) {
		wand = x;
	}
	public int getPotions() {
		return potions;
	}
	
	public int getHealing() {
		return healing;
	}
	
	public int getMax() {
		return  max;
	}
	
	public int getHealth() {
		return health;
	}
	public int getGold() {
		return gold;
	}
	
	public int getLevel() {
		return level;
	}
	
	public String getName() {
		return name;
	}
	
	public int getSpecialChance() {
		return specialChance;
	}
	
	public void setSpecialChance(int n) {
		specialChance = n;
	}
	
	
	
}
