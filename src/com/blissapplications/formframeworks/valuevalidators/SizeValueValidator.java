package com.blissapplications.formframeworks.valuevalidators;

import android.util.Patterns;
import com.blissapplications.formframeworks.forms.IValueValidator;

/**
 * Created with IntelliJ IDEA.
 * User: Luis
 * Date: 25/08/13
 * Time: 19:49
 *
 * Validates the minimum and maximum size of a field value.
 *
 * -1 can be passed to indicate not to evaluate that limit, e.g.,
 * if maxSize is -1, the password can be any length.
 */
public class SizeValueValidator implements IValueValidator {

  private String error;
  private String hint;
  private int minSize;
  private int maxSize;

  public SizeValueValidator(int minSize, int maxSize, String errorMessage, String hint){
    this.error = errorMessage;
    this.hint = hint;
    this.minSize = minSize;
    this.maxSize = maxSize;
  }

  @Override
  public boolean validateValue(String value) {
    boolean checksMinSize = minSize != -1 && minSize > -1 ? value.length() >= minSize : true;
    boolean checkMaxSize = maxSize != -1 && maxSize > -1 ? value.length() <= maxSize : true;
    return checkMaxSize && checksMinSize;
  }

  @Override
  public String getErrorMessage() {
    return error + ". " + hint;
  }
}
