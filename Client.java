import java.util.*;

public class Client {
	
	//Global variables
	static Player player;
	static ArrayList<Wizard> wiz = new ArrayList<Wizard>();
	static HashMap<String, Integer> wands = new HashMap<String, Integer>();
	
	//Store menu where you can purchase items
	
	public static void store() {
		Scanner scan = new Scanner(System.in);
		int choice;
		int choice2;
		
		System.out.println("\nWelcome to the Wizard store! Please buy what ever you please!");
		System.out.println("\nTotal gold: " + player.getGold());
		System.out.println("Current Health: " + player.getHealth());
		System.out.println("\n1. Enchanted healing books");
		System.out.println("2. Potions");
		System.out.println("3. Wands");
		System.out.println("4. Go back");
		System.out.print("Enter your choice: ");
		choice = scan.nextInt();
		
		if (choice ==1) {
			System.out.println("\n1. Confirm buying an enchanted healing book (10 gold)?");
			System.out.println("2. Use an enchanted healing book (heals 10 hp) - " + player.getHealing() + " left");
			System.out.println("3. Go back");
			System.out.print("Enter your choice: ");
			choice2 = scan.nextInt();
			
			if(choice2 == 1) {
				if (player.getGold() >= 10) {
					System.out.println("You purchased the book. It cost you 10 gold.");
					player.setHealing(1);
					player.setGold(-10);
					store();
				} else {
				 	System.out.println("You don't have enough to buy the magic healing book!");
					store();
				}
			} else if (choice2 == 2) {
					if (player.getHealing()>0) {
						player.setHealing(-1);
						System.out.println("You read off the pages of the Enchanted healing book and heal " + (int) player.getMaxHealth()/10 + " hp!");
						System.out.println("You now have " + player.getHealing() + " enchanted healing books left.");
						player.setHealth((int) player.getMaxHealth()/10);
						store();
					} else {
						System.out.println("You have no books left.");
						store();
					}
				} 
		} else if (choice == 2) {
			System.out.println("\n1. Increase max hit by 5 (75 gold)");
			System.out.println("2. Increase max health by 25 (100 gold)");
			System.out.println("3. Go back");
			System.out.print("Enter your choice: ");
			choice2 = scan.nextInt();
			
			if (choice2 ==1) {
				if (player.getGold() >= 75) {
					player.setMax(5);
					player.setGold(-75);
					System.out.println("You paid the wizard 75 gold for an increase in your max hit of 5. Your new max hit is " + player.getMax() + ".");
					store();
				} else {
					System.out.println("You don't have enough gold. You only have " + player.getGold() + " gold.");
					store();
				}
				
			}else if (choice2 ==2) {
				if (player.getGold() >= 100) {
					System.out.println("You paid the wizard 100 gold for an increase of 25 health.");
					player.setMaxHealth(25);
					player.setGold(-100);
					System.out.println("Your new max health is: " + player.getMaxHealth());
					store();
				} else {
					System.out.println("You don't have enough gold. You only have " + player.getGold() + " gold.");
					store();
				}
			}
				
		} else if (choice == 3) {
			System.out.println("Wands: ");
			System.out.println("1. Beginner Wand - 50 gold - increases special spell chance 5%");
			System.out.println("2. Advanced Wand - 100 gold - increases special spell chance 10%");			
			System.out.println("3. Master Wand - 150 gold - increases special spell chance 15%");
			System.out.println("4. Go back");
			System.out.print("Enter your choice: ");
			choice2 = scan.nextInt();
			
			if (choice2==1) {
				if (player.getGold() >= 50) {
					player.setWand("Beginner Wand");
					player.setSpecialChance(25);
					player.setGold(-50);
				} else {
					System.out.println("You don't have enough gold!");
					store();
				}
			} else if (choice2==2) {
				if (player.getGold() >= 100) {
					player.setWand("Advanced Wand");
					player.setSpecialChance(30);
					player.setGold(-100);
				} else {
					System.out.println("You don't have enough gold!");
					store();
				}
			} else if (choice2==3) {
				if (player.getGold() >= 150) {
					player.setWand("Master Wand");
					player.setSpecialChance(35);
					player.setGold(-150);
				} else {
					System.out.println("You don't have enough gold!");
					store();
				}
			} else store();
			
		} else if (choice==4){
			//empty so it goes back in to the main menu
		}else store();
	}
		
		
	
	//Stats menu - currently only showing statistics
	public static void stats() {
		System.out.println("\n----" + player.getName() + "'s stats----");
		System.out.println("At level: " + player.getLevel());
		System.out.println("Gold: " + player.getGold());
		System.out.println("Health: " + player.getHealth());
		System.out.println("Max Health: " + player.getMaxHealth());
		System.out.println("Max Hit: " + player.getMax());
		System.out.println("Wand: " + player.getWand());
		System.out.println("Special Chance (%): " + player.getSpecialChance());
		System.out.println("Amount of Enchanted Healing Books: " + player.getHealing());
		
		
	}
	
	//Method randomizing what the wizard will do during it's turn
	
	public static void wizTurn(int x) {
		Random r = new Random();
		int num, num2, num3;
		
		if (wiz.get(x-1).getHealth() <=0) {
			System.out.println("You...have defeated me?");
		}
		else
		{
			System.out.println("It is " + wiz.get(x-1).getName() + "'s turn.");
			//alg based off random number generator
			num2 = r.nextInt(100);
			
			
			if ((wiz.get(x-1).getHealth() >= (wiz.get(x-1).getMaxHealth()/2)) && (num2 >= 20)) {
				num = r.nextInt(wiz.get(x-1).getMax());
				player.setHealth(-num);
				
				System.out.println("He hit you for " + num + "!");
			} else if ((wiz.get(x-1).getHealth() >= (wiz.get(x-1).getMaxHealth()/2)) && (num2 < 20)) {
				num3 = r.nextInt((int) (wiz.get(x-1).getMaxHealth() * 0.2)+4);
				System.out.println("He decided to heal " + (num3) + " hp!");
				wiz.get(x-1).setHealth(num3);
				
			} else if ((wiz.get(x-1).getHealth() < (wiz.get(x-1).getMaxHealth()/2)) && (num2 >= 50)) {
				num3 = r.nextInt((int) (wiz.get(x-1).getMaxHealth() * 0.2)+4);
				System.out.println("He decided to heal " + (num3) + " hp!");
				wiz.get(x-1).setHealth(num3);
				
			} else if ((wiz.get(x-1).getHealth() < (wiz.get(x-1).getMaxHealth()/2)) && (num2 < 50)) {
				num = r.nextInt(wiz.get(x-1).getMax());
				player.setHealth(-num);
				
				System.out.println("He hit you for " + num + "!");
			} 
		}
		
	}
	
	//training method - earn gold this way in order to fight or buy from store
	
	public static boolean train() {
		int num1 =0; int num2 = 0, ans = 0;
		int guess;
		String[] operation = {"+", "-", "*"};
		String op;
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		
		
		num1 = r.nextInt(13);
		num2 = r.nextInt(13);
		op = operation[r.nextInt(3)];
		if(op.equals("+")) {
			ans = num1+num2;
		} else if (op.equals("-")) {
			ans = num1-num2;
		} else if (op.equals("*")) {
			ans = num1*num2;
		}

		System.out.print("\nWhat is " + num1 + " " + op + " " + num2 + "?: ");
		guess = s.nextInt();
		
		if(guess==ans) {
			return true;
		}
		return false;
		
	}
	
	//PLayer Turn - Fighting menu 
	
	public static void playerTurn(int x) {
		Scanner sc = new Scanner(System.in);
		int choice=0, esc, num, choice2;
		Random r = new Random();
		
		//if statements to check if wizard and player are still alive or not
		if ((wiz.get(x-1).getHealth() > 0) && (player.getHealth() > 0))
		{
			System.out.println("\nHP: " + player.getHealth());
			System.out.println(wiz.get(x-1).getName() + "'s HP: " + wiz.get(x-1).getHealth());
			System.out.println("\n1. Attack");
			System.out.println("2. Heal");
			System.out.println("3. Escape!");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
		}
		else if ((wiz.get(x-1).getHealth() <= 0) && (player.getHealth() > 0) && (choice!=5)) {
			System.out.println(wiz.get(x-1).getName() + " has been defeated! You gain " + wiz.get(x-1).getGoldWin() + " gold.");
			player.setGold(wiz.get(x-1).getGoldWin());
			player.setLevel(1+player.getLevel());
			choice = 5;
			if(x==3) {
				System.out.println("You beat the game. Your name, " + player.getName() + " will go down in history as the best wizard in the world!");
				System.out.println("Thanks for playing!");
			}
		}
		else
		{
			if (player.getHealth() <= 0) {
				System.out.println("Oh my. You have been defeated!!! You are set back to level 1 and lost 100 gold.");
				for(int i = 100; i>0; i--) {
					if(player.getGold()>0) {
						player.setGold(-1);
					}
				}
				for(int i = 0; i < 101; i++) {
					if(player.getHealth() < player.getMaxHealth()) {
						player.setHealth(1);
					}
				}
				
				System.out.println("All the previous wizards heal half of their hp for collectively defeating you!");
				for(int i=0; i < player.getLevel(); i++) {
					wiz.get(i).setHealth(wiz.get(i).getMaxHealth()/2);
				}
				
				player.setLevel(1);
			}
			choice = 5;
		}
		
		
		if (choice==1) {
			System.out.println("\nChoose your attack: ");
			System.out.println("1. Cast normal spell");
			System.out.println("2. Cast special spell (" + player.getSpecialChance() + "% chance of landing)");
			System.out.println("3. Go back");
			System.out.print("Enter your choice: ");
			choice2 = sc.nextInt();
			
			if (choice2==1) {
				num = r.nextInt(player.getMax());
				System.out.println("\nYou attacked " + wiz.get(x-1).getName() + " and hit him for " + num + "!");
				wiz.get(x-1).setHealth(-num);
				wizTurn(x);
				
			} else if (choice2 ==2) {
				num = r.nextInt(101);
				if (num <= player.getSpecialChance()) {
					System.out.println("\nYou hit them with a powerful spell doing damage worth 1/3 of the Wizard's Max Health!");
					System.out.println("The damage you dealt with this spell was: " + (int) (wiz.get(x-1).getMaxHealth()/3) * -1);
					wiz.get(x-1).setHealth((int) (wiz.get(x-1).getMaxHealth()/3) * -1);
					wizTurn(x);
				}
				else {
					System.out.println("You failed your special spell :(");
					wizTurn(x);
				}
					
			} 
			
			playerTurn(x);
			
		}else if(choice ==2) {
			
			if (player.getHealing() > 0) {
				player.setHealing(-1);
				System.out.println("You read off the pages of the Enchanted healing book and heal " + (int) player.getMaxHealth()/10 + " hp!");
				System.out.println("You now have " + player.getHealing() + " enchanted healing books left.");
				player.setHealth((int) player.getMaxHealth()/10);
				wizTurn(x);
				
			} else {
				System.out.println("You don't have any enchanted healing books left!");
				playerTurn(x);
			}
			
			playerTurn(x);
		} else if (choice == 3) {
			System.out.println("You have a " + wiz.get(x-1).getEscape() + "% chance of escaping. Failure means you will lose a quarter of your MAX health!");
			System.out.println("Do you still wish on trying to escape?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			System.out.print("Enter your choice: ");
			esc = sc.nextInt();
			
			if (esc==1){
				num = r.nextInt(101);
				if (num < 71) {
					num = r.nextInt(player.getGold()/2);
					System.out.println("You have successfully escaped!");
					System.out.println("Unfortunately you lost " + (num + 1)+ " gold on your escape!");
					player.setGold(-(num + 1));
				} else {
					System.out.println(wiz.get(x-1).getName() + " has hit you for a quarter of your max hp! You cannot escape!");
					player.setHealth((int) -(player.getMaxHealth()/4));
					playerTurn(x);
					
				}
			} 
			
		}
			
		
		
	}
	
	//Sent to this method once set to fight - declares opponent and sends you up against them based off your level
	
	public static void combat(int x) {
		if(x==1) {
			
			System.out.println("\nHa! I can tell you are an amateur wizard just by looking at you!");
			System.out.println("There is no chance you are going to beat me, The Great Leb!");
			System.out.println("Let's fight!");
			
			playerTurn(x);
			
		} else if (x==2) {
			
			System.out.println("\nSo you got past Leb... Hmph! He's nothing compared to me!");
			System.out.println("Come at me! I am the Undefeated, Glorious, Spedskrt!");

			playerTurn(x);
		} else if (x==3) {
			
			System.out.println("\nAmazing you go this far. I am the boss.");
			System.out.println("You should probably just quit. FOR I, EVGOD, SHALL DESTROY YOU!");
			playerTurn(x);
		}
		
	}
			
	//method printing the main menu of options in the game
	
	public static void menu() {
		System.out.println("\n1. Train");
		System.out.println("2. Fight");
		System.out.println("3. Store");
		System.out.println("4. Stats");
		System.out.println("5. Quit");
		System.out.print("Enter your choice: ");
	}
	
	/************************
	MAIN - contains game loop
	*************************/
	
	
	public static void main(String[] args) {
		
		String name, pw;
		int guess;
		Random rand = new Random();
		int choice = 0, choice2;
		Scanner scan = new Scanner(System.in);
		
		//adds Wands to Hashmap
		wands.put("Beginner Wand", 5);
		wands.put("Advanced", 10);		
		wands.put("Master Wand", 15);
		
		//adds wizards to arraylist
		wiz.add(new Wizard("The Great Leb", 75, 70, 70, 20));
		wiz.add(new Wizard("Spedskrt", 120, 60, 100, 25));
		wiz.add(new Wizard("Evgod", 180, 40, 100000, 35));
		
		//Begins story line
		System.out.print("Welcome wizard! What do you call yourself?: ");
		name = scan.nextLine();
		
		player = new Player(name);
		
		System.out.println("Ahh, " + name + ", you seem like a worthy one. See if you can beat the final wizard and become the best!");
		System.out.println("There are 3 wizards you must face and you level up after beating each one.");
		System.out.println("If you fail to beat one, you are set back to level 1 and lose 100 gold.");
		System.out.println("Gold is necessary to begin fighting or for purchasing items from the store.\nIt can be acquired by training or beating wizards.");
		
		//Game loop
		while (choice != 5) {
			
			//Shows main menu
			menu();
			choice = scan.nextInt();
			if (choice==1) {
				
				if (train()) {
					player.setGold(4);
					System.out.println("\nCorrect you have gained 4 gold. Your total is now " + player.getGold() + " gold.");
				}
				else {
					System.out.println("\nIncorrect. You are not very bright, huh?");
				}
				
			}
			else if (choice ==2) {
				System.out.println("\nHello! I'm Candorin. In order to begin you will need to pay 30 gold, or tell me what the password is.");
				System.out.println("Here is a hint: It's either you or me but minus one.");
				System.out.println("1. Pay gold");
				System.out.println("2. Say password");
				System.out.print("Enter your choice: ");
				choice2 = scan.nextInt();
				scan.nextLine();
				
				if (choice2 == 1) {
					if (player.getGold() >= 30) {
						player.setGold(-30);
						System.out.println("You pay Candorin 30 gold, grudgingly. You have " + player.getGold() + " gold left over.");
						combat(player.getLevel());
					} else {
						System.out.println("Are you kidding me? You don't have enough! You only have " + player.getGold() + " gold!");
					}
				} else {
					System.out.print("So you think you figured it out? Tell me what you think it is.: ");
					pw =  scan.nextLine();
					
					if (pw.equals(name.substring(0, name.length()-1))){
						System.out.println("Correct! Carry on.");
						combat(player.getLevel());
					} else {
						System.out.println("Piss off. You're wasting my time.");
					}
				}
			}
			
			else if (choice==3) {
				store();
			}
			else if (choice ==4) {
				stats();
			}
		}
		
	}

}
