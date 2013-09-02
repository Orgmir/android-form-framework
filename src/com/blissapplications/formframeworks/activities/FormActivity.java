package com.blissapplications.formframeworks.activities;

import com.blissapplications.formframeworks.forms.IValidator;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Luis
 * Date: 25/08/13
 * Time: 19:28
 */
public abstract class FormActivity extends BaseActivity{

  protected abstract void inititalizeFormFields();

  @Override
  public void setContentView(int viewId){
    super.setContentView(viewId);
    inititalizeFormFields();
  }

  private ArrayList<IValidator> ruleSet = new ArrayList<IValidator>();

  public void addValidator(IValidator validator){
    ruleSet.add(validator);
  }

  /**
   * Validates the form (the list of IValidators)
   *
   * @return true if the form is valid, false otherwise
   */
  public boolean validateForm(){
    boolean finalResult = true;
    for(IValidator validator : ruleSet){
      finalResult &= validator.validate();
    }
    return finalResult;
  }
}
