package barray.widomakr.tools;

import barray.widomakr.Config;
import barray.widomakr.utils.Shell;

/**
 * Git.java
 *
 * Handles git related tasks.
 **/
public class Git{
  private Config config;
  private Shell shell;

  /**
   * Git()
   *
   * Initialises the Git class.
   *
   * @param config The configuration for the program.
   **/
  public Git(Config config){
    this.config = config;
    shell = new Shell();
  }

  /**
   * isAvailable()
   *
   * Checks whether the program is available.
   *
   * @return True if the program exists, false if not.
   **/
  public boolean isAvailable(){
    String output = shell.runCmd(new String[]{"git", "--version"});
    if(output != null){
      return output.contains("git version");
    }else{
      return false;
    }
  }

  /**
   * update()
   *
   * Updates the local git repository.
   *
   * @return True if the update worked, false if not.
   **/
  public boolean update(){
    shell.runCmd(new String[]{"git", "fetch"});
    return true;
  }

  /**
   * upgrade()
   *
   * Upgrades the local git repository.
   *
   * @return True if the upgrade worked, false if not.
   **/
  public boolean upgrade(){
    String output = shell.runCmd(new String[]{"git", "pull"});
    if(output != null){
      return !output.contains("error");
    }else{
      return false;
    }
  }
}
