package barray.widomakr.module.update;

import barray.widomakr.Config;
import barray.widomakr.tools.Git;

/**
 * Update.java
 *
 * Updates the program.
 **/
public class Update extends Thread{
  private Config config;

  /**
   * Update()
   *
   * Initialises the Update class.
   *
   * @param config The configuration file containing the settings.
   **/
  public Update(Config config){
    this.config = config;
  }

  /**
   * run()
   *
   * Allows the main program to be run.
   **/
  public void run(){
    Git git = new Git(config);
    System.out.print("Update... ");
    if(git.isAvailable() && git.update()){
      System.out.println(config.getString("okay_msg"));
    }else{
      System.out.println(config.getString("error_msg"));
    }
  }
}
