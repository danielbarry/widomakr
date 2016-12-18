package barray.widomakr.module.run.request;

import barray.widomakr.Config;

/**
 * Request.java
 *
 * This class represents the request module, responsible for working out
 * information about a server, including but not limited to information such as
 * the largest possible request, accepted chracters, timeouts, etc.
 **/
public class Request extends Thread{
  private Config config;

  /**
   * Request()
   *
   * Initialises the Request class.
   *
   * @param config The configuration file containing the settings.
   **/
  public Request(Config config){
    this.config = config;
  }

  /**
   * run()
   *
   * Allows the main program to be run.
   **/
  public void run(){
    /* TODO: Check that we have a server to run a test against. */
    /* TODO: Check that we have a port to run a test against. */
    /* TODO: Send increasingly larger packets to the server. */
    /* TODO: Output report. */
  }
}
