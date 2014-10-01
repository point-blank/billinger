package pl.point.blank.billinger.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.ArrayList;

import pl.point.blank.billinger.model.Bill;
import roboguice.inject.ContextSingleton;

/**
 * Created by gko on 2014-09-30.
 */

@Singleton
public class BillControl {
    private ArrayList<Bill> listOfBills;

    public void loadBillsFromDatabase(){
        // TODO
    }

    public void loadBillsForTestPurposes(){
        listOfBills = new ArrayList<Bill>();
        Bill firstBill = new Bill();
        firstBill.setName("first");
        Bill secondBill = new Bill();
        secondBill.setName("second");

        listOfBills.add(firstBill);
        listOfBills.add(secondBill);
    }

    public ArrayList<Bill> getListOfBills(){
        return listOfBills;
    }

    public Bill getBillFromList(int position){
        if (listOfBills.get(position) != null){
            return listOfBills.get(position);
        }
        else{
            //TODO handle throwable
            return null;
        }
    }


}
