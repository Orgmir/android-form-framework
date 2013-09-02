# Bliss Forms Framework

Helper activity to simplify the creation and validation of forms.

## Example usage

```java
class SignUpFormActivity extends FormActivity {

  EditText userid;
  EditText password1;
  EditText password2;
  EditText email;

  @Override
  public void onCreate(Bundle savedInstance){
    super.onCreate(savedInstance);
    setContentView(R.layouts.signup);
  }

  //Here's the magic!
  @Override
  protected void inititalizeFormFields(){

    userid = (EditText) findViewById(R.id.userid);
    password1 = (EditText) findViewById(R.id.password1);
    password2 = (EditText) findViewById(R.id.password2);
    email = (EditText) findViewById(R.id.email);

    //Setup Validators
    addValidator(new Field(userid));
    addValidator(new Field(password1));
    addValidator(new Field(password2));
    addValidator(new Field(email));
    addValidator(new PasswordFieldRule(password1, password2));

    //Add click listener to submit button
    ((Button) findViewById(R.id.submit_button)).setOnClickListener(new OnClickListener(){
      public void onClick(View v){
        //Validate the form
        if(!validateForm()){
          //Report Error
          return;
        }

        //signup the user if the form validates
        signup();
      }
    });

  }

  //Utility Code
  (...)

}
```

Magic.