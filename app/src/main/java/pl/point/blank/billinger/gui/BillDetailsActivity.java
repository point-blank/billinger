package pl.point.blank.billinger.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.google.inject.Inject;

import pl.point.blank.billinger.R;
import pl.point.blank.billinger.controller.BillControl;
import pl.point.blank.billinger.model.Bill;
import pl.point.blank.billinger.tools.BillingerExceptionHandler;
import pl.point.blank.billinger.tools.Constraints;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_bill_details)
public class BillDetailsActivity extends RoboActivity {
    private static final String TAG = BillDetailsActivity.class.getSimpleName();

    @Inject
    BillControl billController;
    @InjectView(R.id.bill_name_value)
    EditText name;

    boolean isEditable;
    boolean isNewObject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        int position = intent.getIntExtra(Constraints.INTENT_POSITION,0);
        isEditable = intent.getBooleanExtra(Constraints.INTENT_EDITABLE,false);
        isNewObject = intent.getBooleanExtra(Constraints.INTENT_NEW_BILL,false);

        if (!isNewObject){
            readData(position);
        }

        if(!isEditable){
            setFieldsNotEditable();
        }

    }


    public void readData(int position){
        try {
            name.setText(billController.getBillFromList(position).getName());
            setTitle(billController.getBillFromList(position).getName());

        } catch (NullPointerException ex){
            BillingerExceptionHandler.notifyABoutError(this,ex,TAG);
        }
    }

    public void setFieldsNotEditable(){
        name.setKeyListener(null);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bill_details, menu);

        //TODO ugly piece of code ... need to be rewritten
        for (int i=0;i<menu.size();i++){
            if (menu.getItem(i).getItemId() == R.id.action_create) {
                if (isNewObject) {
                    menu.getItem(i).setVisible(true);
                }
            }
            else if (menu.getItem(i).getItemId() == R.id.action_update){
                if (isEditable) {
                    menu.getItem(i).setVisible(true);
                }
            }
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_add_bill) {
            Bill testNewBill = new Bill();
            testNewBill.setName(name.getText().toString());
            BillControl.addBill(testNewBill);
            onBackPressed();
            return true;
        }
        // TODO add update functionality with closing / onbackpressed
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.animation_from_left, R.anim.animation_to_right);
    }
}
