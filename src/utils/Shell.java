package barray.widomakr.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Shell.java
 *
 * Blocking access to the shell, providing the output of commands.
 **/
public class Shell{
  /**
   * Shell()
   *
   * Initialises the Shell class.
   **/
  public Shell(){
    /* Do nothing */
  }

  /**
   * runCmd()
   *
   * Run a specified command.
   *
   * @param cmd The command to be run.
   * @return The output from the command, NULL on error.
   **/
  public String runCmd(String[] cmd){
    ProcessBuilder builder = new ProcessBuilder(cmd);
    builder.redirectErrorStream(true);
    Process process = null;
    try{
      process = builder.start();
    }catch(IOException e){
      /* Return NULL on error */
      return null;
    }
    InputStream is = process.getInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    String buffer = "";
    String line = null;
    try{
      while((line = reader.readLine()) != null){
        buffer += line + "\n";
      }
    }catch(IOException e){
      /* Return NULL on error */
      return null;
    }
    return buffer;
  }
}
