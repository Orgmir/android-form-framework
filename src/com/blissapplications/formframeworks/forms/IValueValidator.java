package com.blissapplications.formframeworks.forms;

/**
 * Created with IntelliJ IDEA.
 * User: Luis
 * Date: 25/08/13
 * Time: 19:36
 */
public interface IValueValidator {

  public boolean validateValue(String value);

  public String getErrorMessage();
}
