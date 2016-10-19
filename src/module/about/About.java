package barray.widomakr.module.about;

import barray.widomakr.Config;

/**
 * About.java
 *
 * Prints information about the program.
 **/
public class About extends Thread{
  private Config config;

  /**
   * About()
   *
   * Initialises the About class.
   *
   * @param config The configuration file containing the settings.
   **/
  public About(Config config){
    this.config = config;
  }

  /**
   * run()
   *
   * Allows the main program to be run.
   **/
  public void run(){
    System.out.println(
      "\n" + config.getString("logo") +
      "\n" +
      "\n" + "\"" + config.getString("motto") + "\"" +
      "\n" +
      "\n" + config.getString("app_name") +
      "\n" + "  Author(s): " + config.getString("author") +
      "\n" + "  Date     : " + config.getString("date") +
      "\n" + "  Version  : " + config.getString("ver")
    );
  }
}
