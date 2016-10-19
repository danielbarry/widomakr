package barray.widomakr.module.run;

import barray.widomakr.Config;

/**
 * Run.java
 *
 * Runs a module of the program.
 **/
public class Run extends Thread{
  private Config config;

  /**
   * Run()
   *
   * Initialises the Run class.
   *
   * @param config The configuration file containing the settings.
   **/
  public Run(Config config){
    this.config = config;
  }

  /**
   * run()
   *
   * Allows the main program to be run.
   **/
  public void run(){
    /* TODO: Write this section. */
  }
}
