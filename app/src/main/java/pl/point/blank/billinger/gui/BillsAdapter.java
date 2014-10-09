package pl.point.blank.billinger.gui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import pl.point.blank.billinger.R;
import pl.point.blank.billinger.model.Bill;

/**
 * Created by gko on 2014-09-29.
 */
public class BillsAdapter extends ArrayAdapter<Bill> {

    private ArrayList<Bill> listOfBills;

    public BillsAdapter(Context context, ArrayList<Bill> objects) {
        super(context, R.layout.bill_row_layout, objects);
        this.listOfBills = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater vi = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(R.layout.bill_row_layout, null);
        }


        TextView textView = (TextView) view.findViewById(R.id.label);
        textView.setText(listOfBills.get(position).getName());

        return view;
    }

}
