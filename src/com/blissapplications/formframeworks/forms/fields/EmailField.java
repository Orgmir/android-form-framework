package com.blissapplications.formframeworks.forms.fields;

import android.widget.TextView;
import com.blissapplications.formframeworks.FFApp;
import com.blissapplications.formframeworks.R;
import com.blissapplications.formframeworks.valuevalidators.EmailValueValidator;

/**
 * Created with IntelliJ IDEA.
 * User: luisramos
 * Date: 02/09/13
 * Time: 17:21
 *
 * It verifies if the text entered in the field is
 * a correct email format
 */
public class EmailField extends Field {

  public EmailField(TextView textView) {
    super(textView);
    init();
  }

  public EmailField(TextView textView, boolean required) {
    super(textView, required);
    init();
  }

  private void init(){
    addValueValidator(new EmailValueValidator(
        FFApp.getInstance().getString(R.string.wrong_format_email_value),
        FFApp.getInstance().getString(R.string.email_value_validator_hint)
    ));
  }
}
