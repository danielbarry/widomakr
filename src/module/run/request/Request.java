package barray.widomakr.module.run.request;

import barray.widomakr.Config;
import barray.widomakr.Main;

/**
 * Request.java
 *
 * This class represents the request module, responsible for working out
 * information about a server, including but not limited to information such as
 * the largest possible request, accepted chracters, timeouts, etc.
 **/
public class Request extends Thread{
  /**
   * Request()
   *
   * Initialises the Request class.
   *
   * @param config The configuration file containing the settings.
   **/
  public Request(Config config){
    /* Check for server IP */
    String ip = config.getString("ip");
    if(ip == null){
      Main.error("No IP address found");
    }
    /* Check for server port */
    String port = config.getString("port");
    if(port == null){
      Main.error("No port found");
    }
  }

  /**
   * run()
   *
   * Allows the main program to be run.
   **/
  public void run(){
    /* TODO: Send increasingly larger packets to the server. */
    /* TODO: Output report. */
  }
}
