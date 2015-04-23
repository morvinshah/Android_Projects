package com.example.morvinshah.lifecycle;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.widget.TextView;
import android.os.*;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    private Handler handler = new Handler();
    private static final long TimeDelay = 20000L;
    private int count = -1;
    private TextView txtThreadCounter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/* Handler that will use a Runnable to display counter */
txtThreadCounter = (TextView) findViewById(R.id.Counter);
        handler.post(updateTextRunnable);

    }
Runnable updateTextRunnable = new Runnable() {
    public void run() {
        count++;
        txtThreadCounter.setText(getString(R.string.ThreadCounter,count));
        handler.postDelayed(this,TimeDelay);
        // Thread counter increment method with delay of 20 seconds
    }
};

    public void OnClickStartB (View v)
    {
        startActivity(new Intent(this,ActivityB.class));
    }

    public void OnClickSimpleDialog (View v)
    {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
