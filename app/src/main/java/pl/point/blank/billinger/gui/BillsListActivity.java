package pl.point.blank.billinger.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.inject.Inject;

import billinger.blank.point.pl.billinger.R;
import pl.point.blank.billinger.controller.BillControl;
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
        billController.loadBillsForTestPurposes();

        adapter = new BillsAdapter(this, billController.getListOfBills());

        setListAdapter(adapter);
        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {

                return true;
            }
        });



    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(this, BillDetailsActivity.class );
        intent.putExtra("POSITION", position);
        startActivity(intent);
        overridePendingTransition(R.anim.animation_from_right, R.anim.animation_to_left);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(0, 1, 1, "Add a Bill");
        menu.add(0, 2, 2, "About");

        return super.onCreateOptionsMenu(menu);
    }
}
