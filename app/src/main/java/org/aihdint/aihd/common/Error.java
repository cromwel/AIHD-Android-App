package org.aihdint.aihd.common;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

public class Error {

    public Error() {
    }

    public static void errorMessage(CoordinatorLayout coordinatorLayout, String message) {
        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, message, Snackbar.LENGTH_LONG)
                .setAction("DISMISS", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });

        // Changing message text color
        snackbar.setActionTextColor(Color.RED);

        // Changing action button text color
        View sbView = snackbar.getView();
        TextView textView = sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        snackbar.show();
    }
}
