package barray.widomakr.module;

import barray.widomakr.Config;

/**
 * Module.java
 *
 * Handles the module requests and gets the system running correctly.
 **/
public class Module{
  /**
   * RUN_MODE
   *
   * A simple enumerator that describes the mode that has been requested to
   * run.
   **/
  private enum RUN_MODE{
    ABOUT,
    HELP,
    RUN,
    UPDATE,
    UPGRADE
  }

  private Thread module;

  /**
   * Module()
   *
   * Initialises the Module class and checks for the module to be run.
   *
   * @param config The configuration file containing the settings for the
   * commands to be run.
   **/
  public Module(Config config){
    /* Check for standard operation command */
    RUN_MODE runMode = RUN_MODE.valueOf(config.getString("mode"));
    for(RUN_MODE rm : RUN_MODE.values()){
      if(config.getString(rm.toString().toLowerCase()) != null){
        runMode = rm;
      }
    }
    /* Check for the module */
    switch(runMode){
      case ABOUT :
        /* TODO: Handle the case. */
        break;
      case HELP :
        /* TODO: Handle the case. */
        break;
      case RUN :
        /* TODO: Handle the case. */
        break;
      case UPDATE :
        /* TODO: Handle the case. */
        break;
      case UPGRADE :
        /* TODO: Handle the case. */
        break;
      default :
        /* TODO: Handle the problem case. */
        break;
    }
  }

  /**
   * run()
   *
   * Allows the module that has been loaded to be run.
   **/
  public void run(){
    /* TODO: Remove me. */
  }
}
