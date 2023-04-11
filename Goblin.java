import java.lang.Math;
import java.util.*;

public class Goblin{
  
  public int maxhp = 7;
  public int currenthp = 7;
  public int atk = 3;
  public int lv = 1;
  public int exp = 9;
  public boolean alive = true;
  
  public Goblin(int level){
    this.lv = level;
    this.maxhp = level * this.maxhp;
    this.currenthp = this.maxhp;
    this.atk = level * this.atk;
    this.exp = level + this.exp;
  }

  public void getstats(){ //Print Stats
    System.out.println();
    System.out.println("Level " + this.lv + " Goblin");
    System.out.println("Health: " + this.currenthp + "/" + this.maxhp);
    System.out.println("Attack: " + this.atk);
    System.out.println();
  }

  public void checkdeath(Player player){
    if(this.currenthp <= 0){
      alive = false;  
      if(player.quest == true && player.questcomp == false){
        player.quests[0].compProgress(player);  //If Player holds a quest that is incomplete, push the progress of the quest
      }
      player.exp = player.exp + this.exp;
      player.checklvup();
      int x = (int)(Math.random() * 100) + 1; //Drop rate & items depends on Goblin's level
      if(x <= 50){
        player.gold = player.gold + 3 * this.lv;
        System.out.println();
        System.out.println("+" + (3 * this.lv) + " gold, +" + this.exp + " exp");
        System.out.println();
      }
      else if(x <= 80){
        player.gold = player.gold + 4 * this.lv;
        player.items.add(new Item(this.lv));
        System.out.println();
        System.out.println("+" + (4 * this.lv) + " gold, +" + this.exp + " exp");
        System.out.println("Recieve 1 " + player.items.get(player.items.size() - 1).getString());
        System.out.println();
      }
      else{
        player.gold = player.gold + 5 * this.lv;
        player.items.add(new Item(this.lv + 1));
        System.out.println();
        System.out.println("+" + (5 * this.lv) + " gold, +" + this.exp + " exp");
        System.out.println("Recieve 1 " + player.items.get(player.items.size() - 1).getString());
        System.out.println();
      }
    }
  }
}