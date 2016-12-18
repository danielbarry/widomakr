package barray.widomakr.module.run;

import barray.widomakr.Config;
import barray.widomakr.Main;
import barray.widomakr.module.run.request.Request;

/**
 * Run.java
 *
 * Runs a module of the program.
 **/
public class Run extends Thread{
  /**
   * RUN_MODE
   *
   * A simple enumerator that describes the program that is required to be run.
   **/
  private enum RUN_PROG{
    NONE,
    REQUEST
  }

  private Thread module;

  /**
   * Run()
   *
   * Initialises the Run class.
   *
   * @param config The configuration file containing the settings.
   **/
  public Run(Config config){
    module = null;
    /* Check for standard operation command */
    RUN_PROG runProg = RUN_PROG.valueOf(config.getString("prog"));
    for(RUN_PROG rp : RUN_PROG.values()){
      if(config.getString(rp.toString().toLowerCase()) != null){
        runProg = rp;
      }
    }
    /* Check for the program to be run */
    switch(runProg){
      case NONE :
        /* Do nothing */
        break;
      case REQUEST :
        module = new Request(config);
        break;
      default :
        Main.error("FATAL: Shpould not be possible to reach here");
        break;
    }
  }

  /**
   * run()
   *
   * Allows the main program to be run.
   **/
  public void run(){
    if(module != null){
      module.run();
    }
  }
}
