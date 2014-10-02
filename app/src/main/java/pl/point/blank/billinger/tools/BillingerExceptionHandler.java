package pl.point.blank.billinger.tools;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.util.Log;


/**
 * Created by Grzegorz on 10/1/2014.
 */
public class BillingerExceptionHandler {


    public static void notifyABoutError(final Activity context,final Throwable th,final String tag){

        FragmentTransaction ft = context.getFragmentManager().beginTransaction();
        Fragment prev = context.getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        new AlertDialog.Builder(context)
                .setTitle("An Error ?")
                .setMessage("You have destroyed me ! \nLet the IT guys fix it ?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        logAnError(th,tag);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Log.e(tag, th.getMessage(),th);
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public static void logAnError(Throwable th, String tag){
        Log.e(tag, th.getMessage(),th);

    }
}


