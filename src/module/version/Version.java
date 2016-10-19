package barray.widomakr.module.version;

import barray.widomakr.Config;

/**
 * Version.java
 *
 * Displays the program version.
 **/
public class Version extends Thread{
  private Config config;

  /**
   * Version()
   *
   * Initialises the Version class.
   *
   * @param config The configuration file containing the settings.
   **/
  public Version(Config config){
    this.config = config;
  }

  /**
   * run()
   *
   * Allows the main program to be run.
   **/
  public void run(){
    System.out.println(
      config.getString("ver")
    );
  }
}
