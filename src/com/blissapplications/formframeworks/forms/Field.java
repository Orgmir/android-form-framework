package com.blissapplications.formframeworks.forms;

import android.widget.TextView;
import com.blissapplications.formframeworks.utils.StringUtils;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Luis
 * Date: 25/08/13
 * Time: 19:37
 */
public class Field implements IValidator {

  private TextView control;
  private boolean required = true;

  private ArrayList<IValueValidator> valueValidatorList = new ArrayList<IValueValidator>();

  public Field(TextView textView){
    this(textView, true);
  }

  public Field(TextView textView, boolean inRequired){
    control = textView;
    required = inRequired;
  }

  @Override
  public boolean validate() {
    String value = getValue();
    if (StringUtils.invalidString(value)){
      if(required){
        warnRequiredFields();
        return false;
      }
    }
    for(IValueValidator validator : valueValidatorList){
      boolean resultIsValid = validator.validateValue(value);
      if(resultIsValid){
        continue;
      }else{
        setErrorMessage(validator.getErrorMessage());
        return false;
      }
    }
    return true;
  }

  private void warnRequiredFields(){
    //TODO localize this
    setErrorMessage("This is a required field");
  }

  private void setErrorMessage(String message){
    control.setError(message);
  }

  private String getValue(){
    return this.control.getText().toString();
  }
}
