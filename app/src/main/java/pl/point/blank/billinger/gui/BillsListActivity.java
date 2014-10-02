package pl.point.blank.billinger.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.inject.Inject;

import billinger.blank.point.pl.billinger.R;
import pl.point.blank.billinger.controller.BillControl;
import pl.point.blank.billinger.tools.BillingerExceptionHandler;
import pl.point.blank.billinger.tools.Constraints;
import roboguice.activity.RoboListActivity;

/**
 * Main Activity
 * Created by gko on 2014-09-26.
 */

public class BillsListActivity extends RoboListActivity {
    @Inject
    BillControl billController;
    private BillsAdapter adapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BillingerExceptionHandler.initializeLogger();
        billController.loadBillsForTestPurposes();

        adapter = new BillsAdapter(this, billController.getListOfBills());

        setListAdapter(adapter);
        this.registerForContextMenu(getListView());

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.long_press_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.edit_bill:
               // editNote(info.id);
              //  BillingerExceptionHandler.notifyABoutError(this,new Throwable("cos"),"gko");
                return true;
            case R.id.delete_bill:
               // deleteNote(info.id);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }



    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(this, BillDetailsActivity.class );
        intent.putExtra(Constraints.INTENT_POSITION, position);
        startActivity(intent);
        overridePendingTransition(R.anim.animation_from_right, R.anim.animation_to_left);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_add_bill) {
            Toast.makeText(this,"I wanna rock !!",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, BillDetailsActivity.class );
            intent.putExtra(Constraints.INTENT_POSITION, -1);
            intent.putExtra(Constraints.INTENT_EDITABLE, true);
            intent.putExtra(Constraints.INTENT_NEW_BILL, true);
            startActivity(intent);
            overridePendingTransition(R.anim.animation_from_right, R.anim.animation_to_left);
            return true;
        }else if (id == R.id.action_exit) {
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bills_list, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
