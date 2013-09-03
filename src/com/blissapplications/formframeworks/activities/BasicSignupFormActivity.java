package com.blissapplications.formframeworks.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.blissapplications.formframeworks.R;
import com.blissapplications.formframeworks.forms.fields.EmailField;
import com.blissapplications.formframeworks.forms.fields.SimplePasswordField;
import com.blissapplications.formframeworks.rules.PasswordFieldRule;

/**
 * Created with IntelliJ IDEA.
 * User: luisramos
 * Date: 03/09/13
 * Time: 10:49
 */
public class BasicSignupFormActivity extends FormActivity {

  private EditText email;
  private EditText password1;
  private EditText password2;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.basic_signup_form);
  }

  @Override
  protected void inititalizeFormFields() {

    email = (EditText) findViewById(R.id.email);
    password1 = (EditText) findViewById(R.id.password1);
    password2 = (EditText) findViewById(R.id.password2);

    addValidator(new EmailField(email));
    addValidator(new SimplePasswordField(6, -1, password1));
    addValidator(new SimplePasswordField(6, -1, password2));
    addValidator(new PasswordFieldRule(password1, password2));

    ((Button) findViewById(R.id.submit)).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        if(!validateForm()){
          Toast.makeText(BasicSignupFormActivity.this, "Please correct the errors in the form.", Toast.LENGTH_LONG).show();
          return;
        }

        Toast.makeText(BasicSignupFormActivity.this, "Everything checks out!", Toast.LENGTH_LONG).show();
      }
    });
  }
}
