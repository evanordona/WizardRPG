
public class Wizard {
	private int health;
	private int escape;
	private String name;
	private int goldWin;
	private int max;
	private int maxHealth;
	
	public Wizard(String n,int h, int e, int gw, int m) {
		name=n;
		health = h;
		escape=e;
		goldWin=gw;
		max = m;
		maxHealth = health;
	}
	
	public void setHealth(int x) {
		health += x;
	}
	
	public void setMax(int x) {
		max += x;
	}
	
	public int getMax() {
		return max;
	}
	public int getHealth() {
		return health;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}
	
	public String getName() {
		return name;
	}
	
	public int getEscape() {
		return escape;
	}
	
	public int getGoldWin() {
		return goldWin;
	}
	
}
