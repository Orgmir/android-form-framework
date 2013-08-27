package com.blissapplications.formframeworks.valuevalidators;

import com.blissapplications.formframeworks.forms.IValueValidator;

/**
 * Created with IntelliJ IDEA.
 * User: Luis
 * Date: 25/08/13
 * Time: 19:49
 */
public class RegExValueValidator implements IValueValidator {

  private String regExPattern;
  private String error;
  private String hint;

  public RegExValueValidator(String regExPattern, String errorMessage, String hint){
    this.regExPattern = regExPattern;
    this.error = errorMessage;
    this.hint = hint;
  }

  @Override
  public boolean validateValue(String value) {
    return value.matches(regExPattern);
  }

  @Override
  public String getErrorMessage() {
    return error + ". " + hint;
  }
}
