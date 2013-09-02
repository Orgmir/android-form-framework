package com.blissapplications.formframeworks.activities;

import com.blissapplications.formframeworks.forms.IValidator;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Luis
 * Date: 25/08/13
 * Time: 19:28
 */
public abstract class SherlockFormActivity extends SherlockBaseActivity{

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

  public boolean validateForm(){
    boolean finalResult = true;
    for(IValidator validator : ruleSet){
      finalResult &= validator.validate();
    }
    return finalResult;
  }
}
