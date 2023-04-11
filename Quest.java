import java.util.*;

public class Quest{
  int killnum = 3;  //Quest info
  int currentknum = 0;
  int reward = 3;
  int exp = 15;

  
  public Quest(Player player){
    this.killnum = player.lv * 2 + this.killnum;
    this.reward = player.lv / 2 + this.reward;
    this.exp = player.lv + this.exp;

  }

  public void compProgress(Player player){
    this.currentknum++; //Recording Quest Progress and check if the quest is completed
    if(this.currentknum >= this.killnum){
      System.out.println();
      System.out.println("QUEST COMPLETE!");
      System.out.println();
      player.questcomp = true;
    }
  }

  public void Reward(Player player){
    player.gold = player.gold + this.reward;  //Give Player reward base on the level when Player accept quest
    player.exp = player.exp + this.exp;
    System.out.println();
    System.out.println("Gain " + this.reward + " gold coin, " + this.exp + " exp.");
    player.checklvup();
    player.questcomp = false;
  }
}