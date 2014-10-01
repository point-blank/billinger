package pl.point.blank.billinger.gui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.inject.Inject;

import java.util.ArrayList;

import billinger.blank.point.pl.billinger.R;
import pl.point.blank.billinger.controller.BillControl;
import pl.point.blank.billinger.model.Bill;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_bill_details)
public class BillDetailsActivity extends RoboActivity {

    @Inject
    BillControl billController;
    @InjectView(R.id.bill_name_value) TextView name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        int position = intent.getIntExtra("POSITION",0);
        name.setText(billController.getBillsForTestPurposes().get(position).getName());
        setTitle(billController.getBillsForTestPurposes().get(position).getName());


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bill_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
