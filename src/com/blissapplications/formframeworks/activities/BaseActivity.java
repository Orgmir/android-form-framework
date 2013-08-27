package com.blissapplications.formframeworks.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import com.blissapplications.formframeworks.utils.C;
import com.blissapplications.formframeworks.utils.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: Luis
 * Date: 25/08/13
 * Time: 19:03
 */
public class BaseActivity extends Activity {

  private ProgressDialog progressDialog = null;

  public void reportBack(String message){
    reportBack(C.TAG, message);
  }

  public void reportBack(String tag, String message){
    Log.d(tag, message);
  }

  public void reportTransient(String message){
    reportTransient(C.TAG, message);
  }

  public void reportTransient(String tag, String message){
    String s = tag + ": " + message;
    Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    reportBack(message);
  }

  public boolean invalidString(String s){
    return StringUtils.invalidString(s);
  }

  public boolean validString(String s){
    return StringUtils.validString(s);
  }

  public void gotoActivity(Class activityClassReference){
    Intent i = new Intent(this, activityClassReference);
    startActivity(i);
  }

  public void turnOnProgressDialog(String title, String message){
    progressDialog = ProgressDialog.show(this, title, message);
  }

  public void turnOffProgressDialog(){
    progressDialog.cancel();
  }

  public void alert(String title, String message){
    AlertDialog dialog = new AlertDialog.Builder(this).create();
    dialog.setTitle(title);
    dialog.setMessage(message);
    dialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener(){
      public void onClick(DialogInterface dialog, int which){
        //TODO create a hook for this
      }
    });
    dialog.show();
  }
}
