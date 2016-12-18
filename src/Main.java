package barray.widomakr;

import barray.widomakr.module.Module;
import java.io.File;

/**
 * Main.java
 *
 * The main entry class to the program whose responsibility is to setup a
 * container for the rest of the program to run safely in.
 **/
public class Main{
  private static final String CONFIG_CORE = "default.properties";
  private static final String CONFIG_USER = "widomakr.properties";
  private Config config;

  /**
   * main()
   *
   * The main entry method of the program responsible for putting the program
   * in an instance context for further processing.
   **/
  public static void main(String[] args){
    new Main(args);
  }

  /**
   * Main()
   *
   * Here the container is setup, the configuration file is read and the
   * arguments are passed to the argument parser.
   *
   * @param args The raw arguments to be parsed.
   **/
  public Main(String[] args){
    /* Setup shutdown hook to prevent unsafe shutting down */
    Runtime.getRuntime().addShutdownHook(
      /* NOTE: Run shutdown process in a new thread as the current working
               thread may be compromised. */
      new Thread(){
        /**
         * run()
         *
         * The method to be run on a different thread.
         **/
        @Override
        public void run(){
          /* TODO: Safely shutdown the process here. */
        }
      }
    );
    config = new Config();
    /* Read core configuration file */
    if(!config.load(new File(CONFIG_CORE))){
      error("No core configuration found `" + CONFIG_CORE + "`");
    }
    /* Read user specified configuration file */
    config.load(new File(CONFIG_USER));
    /* Read command line arguments */
    config.load(args);
    /* Initialise and run the module */
    Module module = new Module(config);
    module.run();
  }

  /**
   * error()
   *
   * Displays an error and then safely quits the program.
   *
   * @param msg The message to be displayed.
   **/
  public static void error(String msg){
    System.err.println("[!!] " + msg);
    System.exit(0);
  }
}
