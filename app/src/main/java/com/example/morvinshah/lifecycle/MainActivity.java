package com.example.morvinshah.lifecycle;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

    public void OnClickCloseApp (View v)
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle(getString(R.string.App_Name));
        dialog.setMessage(getString(R.string.Message_to_Close));
        dialog.setPositiveButton(R.string.Yes_Button);

        new DialogInterface.OnClickListener();{
            @Override
        public void onClick(DialogInterface dialog, int which){
                finish();
            }
        };

        dialog.setNegativeButton(R.string.No_Button),
        new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                dialog.dismiss();
            }
        });
        dialog.create().show();
    }
//Open a SimpleDialog

    public void onClickOpenDialog(View v) {

        final Dialog dialog = new Dialog(this);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_custom);

        dialog.findViewById(R.id.dialog_custom_btnClose).setOnClickListener(
                new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
        dialog.show();

    }
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
