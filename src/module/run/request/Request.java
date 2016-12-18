package barray.widomakr.module.run.request;

import barray.widomakr.Config;
import barray.widomakr.Main;
import barray.widomakr.utils.Packet;

/**
 * Request.java
 *
 * This class represents the request module, responsible for working out
 * information about a server, including but not limited to information such as
 * the largest possible request, accepted chracters, timeouts, etc.
 **/
public class Request extends Thread{
  private String ip;
  private String port;

  /**
   * Request()
   *
   * Initialises the Request class.
   *
   * @param config The configuration file containing the settings.
   **/
  public Request(Config config){
    /* Check for server IP */
    ip = config.getString("ip");
    if(ip == null){
      Main.error("No IP address found");
    }
    /* Check for server port */
    port = config.getString("port");
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
    /* Test server bounds by increasing packet size */
    String insertion = "@";
    Packet packet = new Packet(ip, port, 100000, 100000000);
    packet.setOutputData("GET " + insertion + " HTTP/1.0\n\r\n\r\n\r");
    packet.start();
    while(!packet.complete());
    String control = packet.getInputData();
    int maxSize = 1;
    for(;;){
      System.out.print(".");
      packet = new Packet(ip, port, 100000, 100000000);
      packet.setOutputData("GET " + insertion + " HTTP/1.0\n\r\n\r\n\r");
      packet.start();
      while(!packet.complete());
      String reply = packet.getInputData();
      if(control.equals(reply)){
        break;
      }
      insertion += "@";
      maxSize++;
    }
    System.out.println("");
    /* Output report */
    System.out.println("maxSize: " + maxSize);
  }
}
