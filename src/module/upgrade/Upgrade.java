package barray.widomakr.module.upgrade;

import barray.widomakr.Config;
import barray.widomakr.tools.Ant;
import barray.widomakr.tools.Git;

/**
 * Upgrade.java
 *
 * Upgrades the program.
 **/
public class Upgrade extends Thread{
  private Config config;

  /**
   * Upgrade()
   *
   * Initialises the Upgrade class.
   *
   * @param config The configuration file containing the settings.
   **/
  public Upgrade(Config config){
    this.config = config;
  }

  /**
   * run()
   *
   * Allows the main program to be run.
   **/
  public void run(){
    Git git = new Git(config);;
    Ant ant = new Ant(config);;
    System.out.print("Upgrade... ");
    if(git.isAvailable() && git.upgrade() && ant.build()){
      System.out.println(config.getString("okay_msg"));
    }else{
      System.out.println(config.getString("error_msg"));
    }
  }
}
