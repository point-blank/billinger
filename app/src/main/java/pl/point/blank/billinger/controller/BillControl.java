package pl.point.blank.billinger.controller;

import android.util.Log;

import com.google.inject.Singleton;

import java.util.ArrayList;

import pl.point.blank.billinger.model.Bill;

/**
 * Created by gko on 2014-09-30.
 */

@Singleton
public class BillControl {
    private static ArrayList<Bill> listOfBills;

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
            throw new NullPointerException("No Bill with given ID found, ID= "+position);
        }
    }

    public static void addBill(Bill newBill){
        listOfBills.add(newBill);
    }


}
