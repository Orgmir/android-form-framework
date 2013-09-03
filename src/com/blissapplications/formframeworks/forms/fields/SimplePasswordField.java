package com.blissapplications.formframeworks.forms.fields;

import android.widget.TextView;
import com.blissapplications.formframeworks.R;
import com.blissapplications.formframeworks.valuevalidators.SizeValueValidator;

/**
 * Created with IntelliJ IDEA.
 * User: luisramos
 * Date: 02/09/13
 * Time: 17:21
 *
 * It verifies if the text entered in the field has the correct size.
 * You can choose not to use one limit by passing -1.
 */
public class SimplePasswordField extends Field {

  private int minSize = -1;
  private int maxSize = -1;

  public SimplePasswordField(int minSize, int maxSize, TextView textView) {
    super(textView);
    this.minSize = minSize;
    this.maxSize = maxSize;
    init();
  }

  public SimplePasswordField(int minSize, int maxSize, TextView textView, boolean required) {
    super(textView, required);
    this.minSize = minSize;
    this.maxSize = maxSize;
    init();
  }

  private void init(){
    if(minSize == -1 && maxSize != -1){
      addValueValidator(new SizeValueValidator(minSize, maxSize,
          String.format(getControlContext().getString(R.string.password_size_error), maxSize),
          String.format(getControlContext().getString(R.string.password_size_hint_max), maxSize)
      ));
    }else if(maxSize == -1 && minSize != -1){
      addValueValidator(new SizeValueValidator(minSize, maxSize,
          String.format(getControlContext().getString(R.string.password_size_error), minSize),
          String.format(getControlContext().getString(R.string.password_size_hint_min), minSize)
      ));
    }else if(maxSize != -1 && minSize != -1){
      addValueValidator(new SizeValueValidator(minSize, maxSize,
        String.format(getControlContext().getString(R.string.password_size_error), minSize, maxSize),
        String.format(getControlContext().getString(R.string.password_size_hint_both), minSize, maxSize)
      ));
    }
  }
}
