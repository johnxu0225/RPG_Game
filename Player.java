import java.util.*;

public class Player{
  public int lv = 1;
  public int exp = 0;
  public int maxhp = 1;
  public int currenthp = 1;
  public int atk = 1;
  public String name = "";
  public String pc = "";
  public List<Item> items = new ArrayList<Item>();
  public int gold = 0;
  public boolean quest = false;
  public int basehp = 1;
  public int baseatk = 1;
  public int expcap = 100;
  public boolean questcomp = false;
  public Quest[] quests = new Quest[1];

  public Player(String name, String pc){
    this.name = name;
    this.pc = pc;
  }

  public void getstats(){
    System.out.println();
    System.out.println(this.name);
    System.out.println("Level " + this.lv + "  " + this.exp + "/" + this.expcap);
    System.out.println("Class: " + this.pc);
    System.out.println("Health: " + this.currenthp + "/" + this.maxhp);
    System.out.println("Attack: " + this.atk);
    System.out.println("Gold: " + this.gold);
    System.out.println();
  }

  public void checkdeath(){
    if(currenthp <= 0){
      System.out.println();
      System.out.println("Gameover. Rerun the code to Restart.");
      System.out.println();
      System.exit(1); //Stop running code
    }
  }

  public void checkitems(){
    System.out.println();
    if(items.size() != 0){
      for(int i = 0; i < items.size(); i++){
        System.out.println((i + 1) + ". " + items.get(i).getString());
      }
      System.out.println();
    }
    else{ //Can't print nothing, so print this instead
     System.out.println();
     System.out.println("You have no item.");
     System.out.println(); 
    }    
  }

  public boolean fightcheckitems(){ //Same as check items, but use in fight so it has an Back option
    System.out.println();
    if(items.size() != 0){
      for(int i = 0; i < items.size() + 1; i++){
        if(i < items.size()){
          System.out.println((i + 1) + ". " + items.get(i).getString());
        }
        else{
          System.out.println((i + 1) + ". Back");
        }
      }
      System.out.println();
      return true;
    }
    else{
     System.out.println();
     System.out.println("You have no item.");
     System.out.println(); 
     return false;
    }
  }

  public void checklvup(){

    if(this.exp >= this.expcap){  //If exp requirement reach, level up
    this.lv++;
    this.exp = this.exp - this.expcap;
    this.expcap = 100 * this.lv;  //Remove the exp that is used for level up and increase exp requirement
    this.maxhp = this.lv * 2 + this.basehp; //Adjust Player's stats
    this.atk = this.lv + this.baseatk;
    System.out.println();
    System.out.println("Level Up!!! " + (this.lv - 1) + " -> " + this.lv);
    }
  }
  
  public void getQuest(){
    quests[0] = new Quest(this);
    quest = true;
  }

}