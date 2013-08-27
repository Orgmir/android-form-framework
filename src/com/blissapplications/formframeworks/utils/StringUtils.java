package com.blissapplications.formframeworks.utils;

/**
 * Created with IntelliJ IDEA.
 * User: Luis
 * Date: 25/08/13
 * Time: 19:09
 */
public class StringUtils {

  public static boolean invalidString(String s){
    return !validString(s);
  }

  public static boolean validString(String s){
    return s != null && !s.trim().equalsIgnoreCase("");
  }
}
