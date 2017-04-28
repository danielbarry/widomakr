package barray.widomakr.utils;

import barray.widomakr.Main;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Packet.java
 *
 * This class handles an abstract concept for a packet that is sent to a server
 * and attempts to capture the reply from that request. An instance of this
 * class may be used over and over to continue communication with a server,
 * although the internal program may have to re-open sockets if they are
 * closed. Deferencing the instance will remove all associated data through
 * Java garbage collection.
 *
 * NOTE: A more suitable name may be "Request", but this has already been used
 * internally and shall not be used again.
 **/
public class Packet extends Thread{
  private AtomicBoolean complete;
  private byte[] output;
  private String input;
  private String ip;
  private int port;
  private long sendRateMillis;
  private int sendRateNanos;
  private long waitTimeMillis;
  private int waitTimeNanos;

  /**
   * Packet()
   *
   * Here the information for a future connection or multiple connections is
   * made. As no connection is made in this constructor, there is no immediate
   * need to to start using this packet and it can be stored indefinitely until
   * required.
   *
   * @param ip The IP address of the target.
   * @param port The port of the target.
   * @param sendRate The rate at which to attempt to send the bytes in nano
   * seconds. Small times may not work well on slow machines.
   * @param waitTime The wait time in between the end of sending data to the
   * time to start reading the data in nano seconds. Small times may not work
   * well on slow machines.
   **/
  public Packet(String ip, String port, long sendRate, long waitTime){
    complete = new AtomicBoolean(false);
    output = null;
    input = null;
    this.ip = ip;
    try{
      this.port = Integer.parseInt(port);
    }catch(NumberFormatException e){
      Main.error("Invalid port number `" + port + "`");
    }
    sendRateNanos = (int)(sendRate % 1000000);
    sendRateMillis = sendRate / 1000000;
    waitTimeNanos = (int)(waitTime % 1000000);
    waitTimeMillis = waitTime / 1000000;
  }

  /**
   * setOutputData()
   *
   * Sets the output data, byte for byte as it will be sent over the socket.
   *
   * NOTE: The complete flag is set to false when this method is called.
   *
   * @param data The data to be sent.
   **/
  public void setOutputData(String data){
    complete.set(false);
    output = data.getBytes();
  }

  /**
   * getInputData()
   *
   * Gets the input data, byte for byte as it will be sent over the socket.
   *
   * NOTE: Be sure to make sure the complete flag has been set to true before
   * reading the return data from the socket, otherwise concurrency issues may
   * occur.
   *
   * @return data The data to be retrieved, NULL on failure or no data returned.
   **/
  public String getInputData(){
    return complete.get() ? input : null;
  }

  /**
   * complete()
   *
   * A flag to determine whether the communication is complete.
   *
   * @return True if complete, false if not.
   **/
  public boolean complete(){
    return complete.get();
  }

  /**
   * run()
   *
   * Send the packet with the information set, wait for a reply and store that
   * information. After doing so, raise a flag to indicate that the
   * communication is complete.
   **/
  public void run(){
    try{
      Socket socket = new Socket(ip, port);
      OutputStream os = socket.getOutputStream();
      for(int x = 0; x < output.length; x++){
        os.write(output[x]);
        try{
          Thread.currentThread().sleep(sendRateMillis, sendRateNanos);
        }catch(InterruptedException e){
          /* Do nothing */
        }
      }
      try{
        Thread.currentThread().sleep(waitTimeMillis, waitTimeNanos);
      }catch(InterruptedException e){
        /* Do nothing */
      }
      InputStream is = socket.getInputStream();
      input = "";
      int r;
      while((r = is.read()) >= 0){
        input += (char)r;
        /* NOTE: Assume read and write timing is the same. */
        try{
          Thread.currentThread().sleep(sendRateMillis, sendRateNanos);
        }catch(InterruptedException e){
          /* Do nothing */
        }
      }
      socket.close();
    }catch(IOException e){
      /* Do nothing */
    }
    complete.set(true);
  }
}
