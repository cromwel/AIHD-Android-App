package org.aihdint.aihd;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

import org.aihdint.aihd.R;

/**
 * Created : dennis on 3/23/18.
 */

public class DM_FollowUp extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_dm_followup);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_male:
                if (checked)
                    //gender = "Male";
                    break;
            case R.id.radio_female:
                if (checked)
                    //gender = "Female";
                    break;
            case R.id.radio_yes:
                if (checked)
                    //isEstimated = "1";
                    break;
            case R.id.radio_no:
                if (checked)
                    //isEstimated = "0";
                    break;
        }
    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked
        boolean checked = ((CheckBox) view).isChecked();

        /*Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkbox_complaint_blurr_vision:
                if (checked){

                }else{

                }
                break;
               case R.id.checkbox_complaint_blurr_vision:
                if (checked){

                }else{

                }
                break;
        */
            // TODO: Chief Complaints

    }



}
