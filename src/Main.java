package barray.widomakr;

/**
 * Main.java
 *
 * The main entry class to the program whose responsibility is to setup a
 * container for the rest of the program to run safely in.
 **/
public class Main{
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
    /* TODO: Read core configuration file. */
    /* TODO: Read user specified configuration file. */
    /* TODO: Read command line arguments. */
  }
}
