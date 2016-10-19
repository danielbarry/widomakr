package barray.widomakr.module;

import barray.widomakr.Config;
import barray.widomakr.module.about.About;
import barray.widomakr.module.help.Help;
import barray.widomakr.module.run.Run;
import barray.widomakr.module.update.Update;
import barray.widomakr.module.upgrade.Upgrade;
import barray.widomakr.module.version.Version;

/**
 * Module.java
 *
 * Handles the module requests and gets the system running correctly.
 **/
public class Module extends Thread{
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
    UPGRADE,
    VERSION
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
        module = new About(config);
        break;
      case HELP :
        module = new Help(config);
        break;
      case RUN :
        module = new Run(config);
        break;
      case UPDATE :
        module = new Update(config);
        break;
      case UPGRADE :
        module = new Upgrade(config);
        break;
      case VERSION :
        module = new Version(config);
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
    module.run();
  }
}
