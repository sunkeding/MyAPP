package com.example.skd.myapp.salvage;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

/**
 * @author skd
 */
public class SalvageActivity extends Activity {
  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ViewPager viewPager = new ViewPager(this);
    viewPager.setAdapter(new SimpleAdapter(this));
    setContentView(viewPager);
  }
}
