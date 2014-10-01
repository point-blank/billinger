package pl.point.blank.billinger.controller;

import com.google.inject.Inject;

import java.util.ArrayList;

import pl.point.blank.billinger.model.Bill;
import roboguice.inject.ContextSingleton;

/**
 * Created by gko on 2014-09-30.
 */

@ContextSingleton
public class BillControl {

    public void getBillsFromDatabase()
    {
        // TODO
    }

    public ArrayList<Bill> getBillsForTestPurposes()
    {
        ArrayList<Bill> result = new ArrayList<Bill>();
        Bill firstBill = new Bill();
        firstBill.setName("first");
        Bill secondBill = new Bill();
        secondBill.setName("second");

        result.add(firstBill);
        result.add(secondBill);

        return result;
    }
}
