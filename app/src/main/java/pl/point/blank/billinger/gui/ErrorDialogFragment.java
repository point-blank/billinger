package pl.point.blank.billinger.gui;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import billinger.blank.point.pl.billinger.R;
import roboguice.fragment.RoboDialogFragment;

/**
 * Created by Grzegorz on 10/1/2014.
 */
public class ErrorDialogFragment extends RoboDialogFragment {

    private static final String MESSAGE_ARG = "message";
    private TextView text;

    public ErrorDialogFragment newInstance(String message) {
        ErrorDialogFragment f = new ErrorDialogFragment();

        Bundle args = new Bundle();
        args.putString(MESSAGE_ARG, message);
        f.setArguments(args);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.error_dialog_fragment, container, false);
        v.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ErrorDialogFragment.this.dismiss();
            }
        });

        text = (TextView) v.findViewById(R.id.error_dialog_text_textView);
        text.setText(getArguments().getString(MESSAGE_ARG));
        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, 0);
    }
}