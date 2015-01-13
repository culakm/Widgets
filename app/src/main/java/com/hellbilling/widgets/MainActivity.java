package com.hellbilling.widgets;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Button;

import java.util.Date;


public class MainActivity extends ActionBarActivity implements
        CompoundButton.OnCheckedChangeListener {

    int i = 0;
    CheckBox wCheckBoxMoj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // we vant to monitor status of the check box
        // Swutch supports the same behavior
        wCheckBoxMoj=(CheckBox)findViewById(R.id.moj_check_box_id);
        wCheckBoxMoj.setOnCheckedChangeListener(this);

    }

    public void buttonSendsMessage(View view) {
        // Declaration: button, from the view
        Button wButton = (Button)view;
        // Search widgets in layout
        TextView wText=(TextView)findViewById(R.id.moj_text_view_id);
        EditText wEditText=(EditText)findViewById(R.id.moj_edit_text_id);
        wCheckBoxMoj=(CheckBox)findViewById(R.id.moj_check_box_id);
        Switch wSwitch=(Switch)findViewById(R.id.moj_switch_id);
        RadioGroup wRadioGroup=(RadioGroup)findViewById(R.id.moj_redio_group_id);
        // Change text widget's string
        wText.setText(
            new Date().toString() + "\n" +
            "button text: " + wButton.getText().toString() + "\n" +
            "counter: " + i++ + "\n" +
            "editovany text: " + wEditText.getText() + "\n" +
            "check box status: " + wCheckBoxMoj.isChecked() + "\n" +
            "switch status: " + wSwitch.isChecked() + "\n" +
            "radio status: " + wRadioGroup.getCheckedRadioButtonId() + "\n" +
            "");

    }

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
        if(isChecked){
            wCheckBoxMoj.setText("check box checked");
        }
        else {
            wCheckBoxMoj.setText("check box NOT checked");
        }
    }
    public void buttonSendsMessage2(View view) {
        // Declaration: text widget
        TextView wText;
        EditText wEditText;
        // Declaration: button, from the view
        //Button wButton = (Button)view;
        // Search button in layout
        wText=(TextView)findViewById(R.id.moj_text_view_id);
        wEditText=(EditText)findViewById(R.id.moj_edit_text_id);
        // Change text widget's string
        wText.setText("Text written: " + wEditText.getText() + "\ncounter: " + i++);

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
