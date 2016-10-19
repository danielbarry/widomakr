package barray.widomakr.module.help;

import barray.widomakr.Config;

/**
 * Help.java
 *
 * Prints help about the program.
 **/
public class Help extends Thread{
  private Config config;

  /**
   * Help()
   *
   * Initialises the Help class.
   *
   * @param config The configuration file containing the settings.
   **/
  public Help(Config config){
    this.config = config;
  }

  /**
   * run()
   *
   * Allows the main program to be run.
   **/
  public void run(){
    System.out.println(
      "\n" + config.getString("app_name") + " [CMD] [OPT]" +
      "\n" +
      "\n" + "  ComManD" +
      "\n" + "    about      About the program" +
      "\n" + "    help       Displays this help" +
      "\n" + "    run        Run the program" +
      "\n" + "    update     Update the program" +
      "\n" + "    upgrade    Upgrade the program" +
      "\n" + "    version    Displays the version" +
      "\n" +
      "\n" + "  OPTions" +
      "\n" + "    Read the configuration."
    );
  }
}
