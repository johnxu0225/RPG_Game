import java.util.*;

public class Item{
  public int hp = 2;
  public int lv = 1;

  public Item(int level){
    this.lv = level;
    this.hp = level * this.hp;
  }

  public void stats(){
    System.out.println();
    System.out.println("Level " + this.lv + " Health Potion");
    System.out.println();
  }

  public String getString(){
    return ("Level " + this.lv + " Health Potion");
  }
  
  public void use(Player player, int slot){ //Upon consumed, give Player Health and remove from items list
    if(player.currenthp + this.hp <= player.maxhp){ //Make sure current health will not be larger than maximum health
      player.currenthp = this.hp + player.currenthp;
      System.out.println();
      System.out.println("+" + this.hp + " Health");
      System.out.println();
      player.items.remove(slot - 1);
    }
    else{
      System.out.println();
      System.out.println("+" + (player.maxhp - player.currenthp) + " Health");
      System.out.println();
      player.currenthp = player.maxhp;
      player.items.remove(slot - 1);
    }
  }
}