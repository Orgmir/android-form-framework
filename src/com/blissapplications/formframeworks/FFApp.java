package com.blissapplications.formframeworks;

import android.app.Application;
import android.content.Context;

/**
 * Created with IntelliJ IDEA.
 * User: luisramos
 * Date: 02/09/13
 * Time: 17:05
 * To change this template use File | Settings | File Templates.
 */
public class FFApp extends Application {

  private static FFApp appInstance;

  @Override
  public void onCreate() {
    setInstance(this);
    super.onCreate();
  }

  private static void setInstance(FFApp instance) {
    appInstance = instance;
  }

  public static FFApp getInstance() {
    return appInstance;
  }

}
