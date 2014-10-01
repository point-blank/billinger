package pl.point.blank.billinger.tools;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import billinger.blank.point.pl.billinger.R;
import pl.point.blank.billinger.gui.ErrorDialogFragment;
import roboguice.fragment.RoboDialogFragment;

/**
 * Created by Grzegorz on 10/1/2014.
 */
public class BillingerExceptionHandler {


    public static void notifyAndLog(Activity context, Throwable th, String tag){

        FragmentTransaction ft = context.getFragmentManager().beginTransaction();
        Fragment prev = context.getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        // Create and show the dialog.
        FireMissilesDialogFragment newFragment = new FireMissilesDialogFragment();

        newFragment.show(ft, "dialog");
    }

    public ErrorDialogFragment newInstance (String message){
        ErrorDialogFragment f = new ErrorDialogFragment();

        Bundle args = new Bundle();
        args.putString(MESSAGE_ARG, message);
        f.setArguments(args);

        return f;
    }
}


