package com.blissapplications.formframeworks.valuevalidators;

import android.util.Patterns;
import com.blissapplications.formframeworks.forms.IValueValidator;

/**
 * Created with IntelliJ IDEA.
 * User: Luis
 * Date: 25/08/13
 * Time: 19:49
 */
public class EmailValueValidator implements IValueValidator {

  private String error;
  private String hint;

  public EmailValueValidator(String errorMessage, String hint){
    this.error = errorMessage;
    this.hint = hint;
  }

  @Override
  public boolean validateValue(String value) {
    return Patterns.EMAIL_ADDRESS.matcher(value).matches();
  }

  @Override
  public String getErrorMessage() {
    return error + ". " + hint;
  }
}
