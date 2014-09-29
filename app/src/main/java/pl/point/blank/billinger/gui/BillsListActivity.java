package pl.point.blank.billinger.gui;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import pl.point.blank.billinger.model.Bill;
import roboguice.activity.RoboListActivity;

/**
 * Main Activity
 * Created by gko on 2014-09-26.
 */

public class BillsListActivity extends RoboListActivity {
    private ArrayList<Bill> listOfBills;
    private BillsAdapter adapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listOfBills = new ArrayList<Bill>();


        Bill firstBill = new Bill();
        firstBill.setName("first");
        Bill secondBill = new Bill();
        secondBill.setName("second");

        listOfBills.add(firstBill);
        listOfBills.add(secondBill);

        adapter = new BillsAdapter(this, listOfBills);


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

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(0, 1, 1, "Add a Bill");
        menu.add(0, 2, 2, "About");

        return super.onCreateOptionsMenu(menu);
    }
}
