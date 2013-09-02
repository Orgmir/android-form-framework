package com.blissapplications.formframeworks.forms.fields;

import android.widget.TextView;
import com.blissapplications.formframeworks.FFApp;
import com.blissapplications.formframeworks.R;
import com.blissapplications.formframeworks.forms.IValidator;
import com.blissapplications.formframeworks.forms.IValueValidator;
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

  private ArrayList<IValueValidator> valueValidatorList;

  public Field(TextView textView){
    this(textView, true);
  }

  public Field(TextView textView, boolean inRequired){
    valueValidatorList = new ArrayList<IValueValidator>();
    control = textView;
    required = inRequired;
  }

  public void addValueValidator(IValueValidator valueValidator){
    valueValidatorList.add(valueValidator);
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
    setErrorMessage(FFApp.getInstance().getString(R.string.required_field));
  }

  private void setErrorMessage(String message){
    control.setError(message);
  }

  private String getValue(){
    return this.control.getText().toString();
  }
}
