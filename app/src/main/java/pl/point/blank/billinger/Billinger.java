package pl.point.blank.billinger;

import android.app.Application;
import android.os.Bundle;

import org.acra.ACRA;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;

import pl.point.blank.billinger.tools.BillingerReportSender;

/**
 * Created by gko on 2014-10-09.
 */
@ReportsCrashes(formKey = "", formUri = "https://oint-lank.iriscouch.com/acra-billinger/_design/acra-storage/_update/report",
        reportType = org.acra.sender.HttpSender.Type.JSON,
        httpMethod = org.acra.sender.HttpSender.Method.PUT,
        formUriBasicAuthLogin="billinger",
        formUriBasicAuthPassword="billinger",
// Your usual ACRA configuration
        mode = ReportingInteractionMode.DIALOG,
        resToastText = R.string.crash_toast_text, // optional, displayed as soon as the crash occurs, before collecting data which can take a few seconds
        resDialogText = R.string.crash_dialog_text,
        resDialogIcon = android.R.drawable.ic_dialog_info, //optional. default is a warning sign
        resDialogTitle = R.string.crash_dialog_title, // optional. default is your application name
        resDialogCommentPrompt = R.string.crash_dialog_comment_prompt, // optional. when defined, adds a user text field input with this text resource as a label
        resDialogOkToast = R.string.crash_dialog_ok_toast // optional. displays a Toast message when the user accepts to send a report.
)
public class Billinger extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ACRA.init(this);
        //BillingerReportSender mySender = new BillingerReportSender();
       // ACRA.getErrorReporter().setReportSender(mySender);
    }
}
