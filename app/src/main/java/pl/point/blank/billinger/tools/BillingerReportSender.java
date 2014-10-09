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

import org.acra.collector.CrashReportData;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderException;


/**
 * Created by Grzegorz on 10/1/2014.
 */
public class BillingerReportSender implements ReportSender {

    @Override
    public void send(CrashReportData errorContent) throws ReportSenderException {

    }
}


