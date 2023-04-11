import java.lang.Math;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    Player player = new Player("", ""); //Create Player Object
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println("Welcome to EDVANTURA");
    System.out.println("ENTER to start");
    System.out.println();
    Scanner et1 = new Scanner(System.in);
    String w = et1.nextLine();  //Use this line to have the code to wait for an input
    System.out.println("ENTER your character name");
    System.out.println();
    Scanner cn = new Scanner(System.in);
    player.name = cn.nextLine();
    System.out.println();
    System.out.println("Your name is " + player.name);  //Overwrite Player's name
    System.out.println();
    System.out.println("Choose your class:");
    System.out.println("1. Fighter");
    System.out.println("2. Rogue");
    System.out.println();
    chooseclass(player);  //Use this method to set Player's Class, Base Stats, and Stats change per level
    System.out.println("Hit ENTER to enter the town");
    System.out.println();
    Scanner et = new Scanner(System.in);
    w = et.nextLine();
    System.out.println("Welcome to Spawntown");
    System.out.println();
    town(player); // Go to town method to start the entire loop

  }

  public static void chooseclass(Player player){
    Scanner cln = new Scanner(System.in);
    String classname = cln.nextLine();
    switch(classname){
      case "1":
        player.pc = "Figther";  //Overwrite Player's properties
        player.maxhp = 30;
        player.basehp = 30;
        player.currenthp = player.maxhp;
        player.atk = 5;
        player.baseatk = 5;
        System.out.println();
        System.out.println("Your class is Fighter");
        System.out.println();
        break;
      case "2":
        player.pc = "Rogue";
        player.maxhp = 10;
        player.basehp = 10;
        player.currenthp = player.maxhp;
        player.atk = 10;
        player.baseatk = 10;
        System.out.println();
        System.out.println("Your class is Rogue");
        System.out.println();
        break;
      default:
        System.out.println(); //In case wrong answer is entered
        System.out.println("Not a choice, please try again!");
        System.out.println();
        chooseclass(player);
        break;

    }
  }

  public static void town(Player player){
    player.currenthp = player.maxhp;  //Restore Player's health upon entering the town
    System.out.println("What do you want to do now?");
    System.out.println("1. Talk with Bob");
    System.out.println("2. Talk with Citizen");
    System.out.println("3. Check my Stats");
    System.out.println("4. Check my Items");
    System.out.println("5. Enter the Dungeon");
    System.out.println("6. Enter the Store");
    System.out.println("7. Quit Game");
    System.out.println();
    Scanner ca = new Scanner(System.in);
    String rca = ca.nextLine();
    switch(rca){  //Multiple choice
      case "1": 
        bob(player);
        break;
      case "2":
        citizen(player);
        break;
      case "3":
        checkstats(player);
        break;
      case "4":
        checkitem(player);
        break;
      case "5":
        dungeon(player);
        break;
      case "6":
        store(player);
        break;
      case "7":
        quitgame(player);
        break;
      default:
        System.out.println();
        System.out.println("Not a choice, please try again!");
        System.out.println();
        town(player);
        break;
    }
  }

  public static void quitgame(Player player){
    System.out.println();
    System.out.println("All of your progress will be lost. Are you sure you want to quit game?");
    System.out.println("Y/N");
    System.out.println();
    Scanner y = new Scanner(System.in);
    switch(y.nextLine()){
      case "y":
        System.out.println();
        System.out.println("Session Ended");
        System.out.println();
        System.exit(1); //Stop the code
        break;
      case "n":
        System.out.println();
        System.out.println("Returning to town. . . ");
        System.out.println();
        town(player); //Go back to where this method was called
        break;
      default:
        System.out.println();
        System.out.println("Not a choice, please try again!");
        System.out.println();
        quitgame(player);
        break;
    }
  }
  
  public static void bob(Player player){
    System.out.println();
    System.out.println("Bob: " + "Hi, " + player.name);
    if(player.quest == false && player.questcomp == false){ //Change dialogue options base on Player's properties
      System.out.println("1. Do you need any help?");
      System.out.println("2. I should go.");
      System.out.println();
      Scanner cs = new Scanner(System.in);
      switch(cs.nextLine()){
        case "1":
          System.out.println();
          System.out.println("Bob: " + "Can you help me kill some goblins from the dungeon?");
          System.out.println("ENTER TO ACCEPT");
          System.out.println();
          Scanner up = new Scanner(System.in);
          String o = up.nextLine();
          player.quests[0] = new Quest(player); //Let the Player Object Carry the properties of the Quest since the content of the Quest changes base on Player's level
          player.quest = true;
          System.out.println();
          System.out.println("Quest Accepted!");
          System.out.println("Help Bob kill " + player.quests[0].killnum + " Goblins for " + player.quests[0].reward + " gold and " + player.quests[0].exp + " exp.");
          System.out.println();
          System.out.println("Returning to town. . . ");
          System.out.println();
          town(player);
           break;
        case "2":
          System.out.println();
          System.out.println("Return to town.");
          System.out.println();
          town(player);
          break;
        default:
          System.out.println();
          System.out.println("Not a choice, please try again!");
          System.out.println();
          bob(player);
          break;

      }
    }
    else if(player.quest == true && player.questcomp == false){
      System.out.println("-> I should go. <-");
      System.out.println();
      Scanner et1 = new Scanner(System.in);
      String w = et1.nextLine();
      town(player);
    }
    else{
      System.out.println("1. I have completed the quest.");
      System.out.println("2. I should go.");
      Scanner cs = new Scanner(System.in);
      switch(cs.nextLine()){
        case "1":
          System.out.println();
          System.out.println("Thank you, " + player.name + ", I will never forget this!");
          player.quests[0].Reward(player);
          System.out.println();
          player.quests[0] = null;
          player.quest = false;
          System.out.println();
          System.out.println("Returning to town. . . ");
          System.out.println();
          town(player);
          break;
        case "2":
          System.out.println();
          System.out.println("Return to town.");
          System.out.println();
          town(player);
          break;
        default:
          System.out.println();
          System.out.println("Not a choice, please try again!");
          System.out.println();
          bob(player);
          break;

      }
    }
  }

  public static void citizen(Player player){
    switch((int)(Math.random() * 5) + 1){ //Generate random dialogue
      case 1: 
        System.out.println();
        System.out.println("Citizen: " + player.name + ", Bob seems to need your help.");
        System.out.println();
        town(player);
        break;
      case 2:
        System.out.println();
        System.out.println("Citizen: " + "Good morning, " + player.name + "!");
        System.out.println();
        town(player);
        break;
      case 3:
        System.out.println();
        System.out.println("Citizen: " + "I used to be a " + player.pc + " like you, but now I'm just too old.");
        System.out.println();
        town(player);
        break;
      case 4:
        System.out.println();
        System.out.println("Citizen: " + "That dungeon is dangerous, " + player.name + ", you better be prepared before you enter it!");
        System.out.println();
        town(player);
        break;
      case 5: 
        System.out.println();
        System.out.println("Citizen: " + "Hi!");
        System.out.println();
        town(player);
        break;
    }
  }

  public static void checkstats(Player player){
    player.getstats();  //Use a method in Player to show stats
    town(player);
  }

  public static void checkitem(Player player){
    System.out.println();
    player.checkitems();
    System.out.println();
    town(player);
  }

  public static void store(Player player){
    System.out.println();
    System.out.println("Merchant: " + "What do you need?");
    System.out.println("1. Buy a health potion(-" + (player.lv + 2) + " gold)");
    System.out.println("2. I should go.");
    System.out.println();
    Scanner op = new Scanner(System.in);
    switch(op.nextLine()){
      case "1": 
        if(player.gold >= (player.lv + 2)){ //Make sure player can't trade with 0 or less gold
          System.out.println();
          System.out.println("Trade Successful");
          System.out.println();
          player.items.add(new Item(player.lv));  //Create an item base on Player's level and let the Player carry it in a list
          player.gold = player.gold - (player.lv + 2);
          store(player);
          break;
        }
        else{
          System.out.println();
          System.out.println("No Enough Gold");
          System.out.println();
          store(player);
        }
        
      case "2":
        System.out.println();
        System.out.println("Returning to town. . . ");
        System.out.println();
        town(player);
        break;
      default:
        System.out.println();
        System.out.println("Not a choice, please try again!");
        System.out.println();
        store(player);
        break;
    }
  }

  public static void dungeon(Player player){
    System.out.println();
    System.out.println("Entering the Cave of Goblins. . . ");
    System.out.println();
    System.out.println("What do you want to do now?");
    System.out.println("1. Roam");
    System.out.println("2. Return to town");
    System.out.println();
    Scanner dp = new Scanner(System.in);
    switch(dp.nextLine()){
      case "1":
        startfight(player); //Initial fight loop
        break;
      case "2":
        System.out.println();
        System.out.println("Returning to town. . . ");
        System.out.println();
        town(player);
        break;
      default:
        System.out.println();
        System.out.println("Not a choice, please try again!");
        System.out.println();
        dungeon(player);
        break;
    }
  }

  public static void startfight(Player player){
    if(player.lv == 1){ //Make sure there isn't a Level 0 goblin
      Goblin mo = new Goblin((int)(Math.random() * 2) + 1); //Create a Goblin Object, various base on player's level
      System.out.println();
      System.out.println("A wild Goblin appear");
      System.out.println();
      fight(player, mo);
      System.out.println();
      System.out.println("VICTORY");
      System.out.println();
      dungeon(player);  //If fight ended, go back to dungeon
    }
    else{
      Goblin mo = new Goblin((int)(Math.random() * (player.lv + 1)) + (player.lv - 1));
      System.out.println();
      System.out.println("A wild Goblin appear");
      System.out.println();
      fight(player, mo);
      System.out.println();
      System.out.println("VICTORY");
      System.out.println();
      dungeon(player);
    }
  }

  public static void fight(Player player, Goblin mo){
    System.out.println();
    System.out.println("Actions: ");
    System.out.println("1. Attack");
    System.out.println("2. Items");
    System.out.println("3. Check Character Stats");
    System.out.println("4. Check Enemy Stats");
    System.out.println("5. Retreat");
    System.out.println();
    Scanner fi = new Scanner(System.in);
    switch(fi.nextLine()){
      case "1": //Attack, substract Goblin Health with Player's Attack damage
        System.out.println();
        mo.currenthp = mo.currenthp - player.atk;
        System.out.println("You dealt " + player.atk + " damage");
        mo.checkdeath(player);  //Check if player is killed
        System.out.println();
        break;
      case "2":
        useitem(player, mo);
        break;
      case "3":
        System.out.println();
        player.getstats();  //Show Stats and then go back to action choices
        System.out.println();
        fight(player, mo);
        break;
      case "4":
        System.out.println();
        mo.getstats();
        System.out.println();
        fight(player, mo);
        break;
      case "5":
        mo.alive = false;
        System.out.println();
        System.out.println("Returning to town. . . ");
        System.out.println();
        town(player);
        break;
      default:
        System.out.println();
        System.out.println("Not a choice, please try again!");
        System.out.println();
        fight(player, mo);
        break;
    }
    if(mo.alive){
      player.currenthp = player.currenthp - mo.atk;
      System.out.println();
      System.out.println("Goblin dealt " + mo.atk + " damage");
      player.checkdeath();  //Check if Goblin is killed
      System.out.println();
      fight(player, mo);
    }
  }

  public static void useitem(Player player, Goblin mo){
    System.out.println();
    if(player.fightcheckitems()){
      System.out.println();
      Scanner re = new Scanner(System.in);
      boolean n = re.hasNextInt();  //Check if a number is enter
      int p = re.nextInt(); 
      if(n){  
        if(p == player.items.size() + 1){ //If player chooses Back
          fight(player, mo);
        }
        if(p <= player.items.size() && p > 0){  //Consumes the item in the correspond slot shown in the stats check
          player.items.get(p - 1).use(player, p); //Call an Item method that give Player health and remove itself from player's item's list
        }
        else{
          System.out.println();
          System.out.println("Not a choice, please try again!");
          System.out.println();
          useitem(player, mo);
        }
      }
      else{
          System.out.println();
          System.out.println("Not a choice, please try again!");
          System.out.println();
          useitem(player, mo);
      }
    }
    else{
      fight(player, mo);  //If there is no item, go back to action choices instead of Goblin's turn
    }  
  }
}

  