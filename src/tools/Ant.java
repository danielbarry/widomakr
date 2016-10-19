package barray.widomakr.tools;

import barray.widomakr.Config;
import barray.widomakr.utils.Shell;

/**
 * Ant.java
 *
 * A wrapper class for the ant build process on the terminal.
 **/
public class Ant{
  private Config config;
  private Shell shell;

  /**
   * Ant()
   *
   * Initialises the Ant class.
   *
   * @param config The configuration for the program.
   **/
  public Ant(Config config){
    this.config = config;
    shell = new Shell();
  }

  /**
   * build()
   *
   * Attempts to build the program.
   *
   * @return True if built, false if not.
   **/
  public boolean build(){
    /* TODO: Implementation should be safer. */
    String output = shell.runCmd(new String[]{"ant"});
    if(output != null){
      return !output.contains("BUILD FAILED");
    }else{
      return false;
    }
  }
}
