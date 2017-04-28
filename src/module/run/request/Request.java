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
    Packet packet = new Packet(ip, port, 0, 1000);
    packet.setOutputData("GET /a HTTP/1.0\r\n\r\n");
    packet.start();
    while(!packet.complete());
    String control = packet.getInputData().split("\n\r")[1];
    int m = 0;
    int x = 2;
    int c = 1;
    for(; x < 65536; x += c){
      System.out.print('.');
      packet = new Packet(ip, port, 0, 1000);
      String insertion = '/' + timesChar('a', x - 1);
      packet.setOutputData("GET " + insertion + " HTTP/1.0\r\n\r\n");
      packet.start();
      while(!packet.complete());
      String reply = packet.getInputData().split("\n\r")[1];
      if(!control.equals(reply)){
        if(c == 1){
          m = packet.getOutputData().length;
          break;
        }else{
          x -= c;
          c = 1;
        }
      }else{
        c *= 2;
      }
    }
    /* Output report */
    System.out.println("");
    System.out.println("Max Size: " + m);
  }

  private String timesChar(char chr, int size){
    String buffer = "";
    for(int x = 0; x < size; x++){
      buffer += chr;
    }
    return buffer;
  }
}
