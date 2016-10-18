package barray.widomakr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

/**
 * Config.java
 *
 * Handles the program configuration from various sources in a simplistic
 * format.
 **/
public class Config{
  private Properties props;

  /**
   * Config()
   *
   * Creates a new configuration object.
   **/
  public Config(){
    /* Create our properties instance */
    props = new Properties();
  }

  /**
   * load()
   *
   * Loads from a file for the configuration.
   *
   * @param file The file to be loaded from.
   * @return True on success, otherwise false.
   **/
  public boolean load(File file){
    try{
      props.load(new FileInputStream(file));
    }catch(FileNotFoundException e){
      return false;
    }catch(IOException e){
      return false;
    }
    return true;
  }

  /**
   * load()
   *
   * Loads from a string array for the configuration.
   *
   * @param strarr The string array to be loaded from.
   * @return True on success, otherwise false.
   **/
  public boolean load(String[] strarr){
    String str = argsStrParse(strarr);
    if(str == null){
      return false;
    }
    try{
      props.load(new StringReader(str));
    }catch(IOException e){
      return false;
    }
    return true;
  }

  /**
   * argsStrParse()
   *
   * Parses command line arguments and converts them to a format that can be
   * processed.
   *
   * @param sa The String array to be parsed.
   * @return NULL if the format is bad and the String if it is okay.
   **/
  private String argsStrParse(String[] sa){
    /* TODO: Better checking. */
    String buffer = "";
    for(String s : sa){
      buffer += s + "\n";
    }
    return buffer;
  }
}
