package pl.point.blank.billinger.tools;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.mindpipe.android.logging.log4j.LogConfigurator;


/**
 * Created by Grzegorz on 10/1/2014.
 */
public class BillingerExceptionHandler {

    private static final Logger log = Logger.getLogger(BillingerExceptionHandler.class);

    public static void notifyABoutError(final Activity context,final Throwable th,final String tag){



        FragmentTransaction ft = context.getFragmentManager().beginTransaction();
        Fragment prev = context.getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        Log.e(tag, th.getMessage(),th);

        new AlertDialog.Builder(context)
                .setTitle("An Error ?")
                .setMessage("You have destroyed me ! \nLet the IT guys fix it ?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        logAnError(th);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public static void logAnError(Throwable th){
        log.info(th.getMessage(),th);
        sendLog();
    }

    public static void sendLog(){

    }

    public static void initializeLogger(){
        final LogConfigurator logConfigurator = new LogConfigurator();
final String logPath = Environment.getExternalStorageDirectory() + File.separator + "billinger.log";
        if (!new File(logPath).exists()){
            try {
                new File(logPath).createNewFile();
            } catch (IOException e) {
                Log.e(BillingerExceptionHandler.class.getSimpleName(), e.getMessage(),e);
            }
        }
        logConfigurator.setFileName(logPath);
        logConfigurator.setRootLevel(Level.DEBUG);
        // Set log level of a specific logger
        logConfigurator.setLevel("org.apache", Level.ERROR);
        logConfigurator.configure();
    }
}


