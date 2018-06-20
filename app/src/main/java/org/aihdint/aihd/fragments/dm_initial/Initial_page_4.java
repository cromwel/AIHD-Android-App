package org.aihdint.aihd.fragments.dm_initial;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;

import org.aihdint.aihd.Forms.JSONFormBuilder;
import org.aihdint.aihd.R;
import org.aihdint.aihd.fragments.dm_followup.FragmentModelFollowUp;
import org.json.JSONArray;
import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Developed by Rodney on 24/04/2018.
 */
@SuppressWarnings("FieldCanBeLocal")
public class Initial_page_4 extends Fragment {

    private CheckBox checkBoxStroke, checkBoxHeart, checkBoxKidney, checkBoxNeuropahty, checkBoxVisual, checkBoxUlcers, checkBoxErectile, checkBoxOther,
            checkBoxNutrition, checkBoxActivity, checkBoxPsychosocial;

    private String stroke, heart, kidney, neuropahty, visual, ulcers, erectile, other, nutrition, activity, psychosocial, diagnosis_stroke, diagnosis_heart, diagnosis_kidney,
            diagnosis_neuropahty, diagnosis_visual, diagnosis_ulcers, diagnosis_erectile, diagnosis_other;

    private RadioButton radioButtonStrokeResolved, radioButtonHeartResolved, radioButtonKidneyResolved, radioButtonNeuropahtyResolved, radioButtonVisualResolved,
            radioButtonUlcersResolved, radioButtonErectileResolved, radioButtonOtherResolved, radioButtonStrokeReferral, radioButtonHeartReferral, radioButtonKidneyReferral,
            radioButtonNeuropahtyReferral, radioButtonVisualReferral, radioButtonUlcersReferral, radioButtonErectileReferral, radioButtonOtherReferral;

    private EditText editTextStroke, editTextHeart, editTextKidney, editTextNeuropahty, editTextVisual, editTextUlcers, editTextErectile, editTextOtherComplication,
            editTextStrokeDate, editTextHeartDate, editTextKidneyDate, editTextNeuropahtyDate, editTextVisualDate, editTextUlcersDate, editTextErectileDate,
            editTextOtherComplicationDate, editTextOtherProvision;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dm_initial_fragment_4, container, false);

        checkBoxStroke = view.findViewById(R.id.checkbox_complication_stroke);
        checkBoxHeart = view.findViewById(R.id.checkbox_complication_heart);
        checkBoxKidney = view.findViewById(R.id.checkbox_complication_kidney);
        checkBoxNeuropahty = view.findViewById(R.id.checkbox_complication_neuropathy);
        checkBoxVisual = view.findViewById(R.id.checkbox_complication_visual);
        checkBoxUlcers = view.findViewById(R.id.checkbox_complication_foot_ulcer);
        checkBoxErectile = view.findViewById(R.id.checkbox_complication_erectile);
        checkBoxOther = view.findViewById(R.id.checkbox_complication_other);
        checkBoxNutrition = view.findViewById(R.id.checkbox_nutrition);
        checkBoxActivity = view.findViewById(R.id.checkbox_physical_activity);
        checkBoxPsychosocial = view.findViewById(R.id.checkbox_psychosocial);

        checkBox(checkBoxStroke);
        checkBox(checkBoxHeart);
        checkBox(checkBoxKidney);
        checkBox(checkBoxNeuropahty);
        checkBox(checkBoxVisual);
        checkBox(checkBoxUlcers);
        checkBox(checkBoxErectile);
        checkBox(checkBoxOther);
        checkBox(checkBoxNutrition);
        checkBox(checkBoxActivity);
        checkBox(checkBoxPsychosocial);

        radioButtonStrokeResolved = view.findViewById(R.id.radio_diagnosis_stroke_resolved);
        radioButtonHeartResolved = view.findViewById(R.id.radio_diagnosis_heart_failure_resolved);
        radioButtonKidneyResolved = view.findViewById(R.id.radio_diagnosis_kidney_failure_resolved);
        radioButtonNeuropahtyResolved = view.findViewById(R.id.radio_diagnosis_neuropathy_resolved);
        radioButtonVisualResolved = view.findViewById(R.id.radio_diagnosis_visual_resolved);
        radioButtonUlcersResolved = view.findViewById(R.id.radio_diagnosis_foot_ulcer_resolved);
        radioButtonErectileResolved = view.findViewById(R.id.radio_diagnosis_erectile_resolved);
        radioButtonOtherResolved = view.findViewById(R.id.radio_diagnosis_other_resolved);

        radioButtonStrokeReferral = view.findViewById(R.id.radio_diagnosis_stroke_referral);
        radioButtonHeartReferral = view.findViewById(R.id.radio_diagnosis_heart_failure_referral);
        radioButtonKidneyReferral = view.findViewById(R.id.radio_diagnosis_kidney_failure_referral);
        radioButtonNeuropahtyReferral = view.findViewById(R.id.radio_diagnosis_neuropathy_referral);
        radioButtonVisualReferral = view.findViewById(R.id.radio_diagnosis_visual_referral);
        radioButtonUlcersReferral = view.findViewById(R.id.radio_diagnosis_foot_ulcer_referral);
        radioButtonErectileReferral = view.findViewById(R.id.radio_diagnosis_erectile_referral);
        radioButtonOtherReferral = view.findViewById(R.id.radio_diagnosis_other_referral);

        radioButton(radioButtonStrokeResolved);
        radioButton(radioButtonHeartResolved);
        radioButton(radioButtonKidneyResolved);
        radioButton(radioButtonNeuropahtyResolved);
        radioButton(radioButtonVisualResolved);
        radioButton(radioButtonUlcersResolved);
        radioButton(radioButtonErectileResolved);
        radioButton(radioButtonOtherResolved);

        radioButton(radioButtonStrokeReferral);
        radioButton(radioButtonHeartReferral);
        radioButton(radioButtonKidneyReferral);
        radioButton(radioButtonNeuropahtyReferral);
        radioButton(radioButtonVisualReferral);
        radioButton(radioButtonUlcersReferral);
        radioButton(radioButtonErectileReferral);
        radioButton(radioButtonOtherReferral);

        editTextStroke = view.findViewById(R.id.diagnosis_comment_stroke);
        editTextHeart = view.findViewById(R.id.diagnosis_comment_heart_failure);
        editTextKidney = view.findViewById(R.id.diagnosis_comment_kidney_failure);
        editTextNeuropahty = view.findViewById(R.id.diagnosis_comment_neuropathy);
        editTextVisual = view.findViewById(R.id.diagnosis_comment_visual);
        editTextUlcers = view.findViewById(R.id.diagnosis_comment_foot_ulcer);
        editTextErectile = view.findViewById(R.id.diagnosis_comment_erectile);
        editTextOtherComplication = view.findViewById(R.id.diagnosis_comment_other);
        editTextOtherProvision = view.findViewById(R.id.provision_other);

        editTextStrokeDate = view.findViewById(R.id.diagnosis_date_stroke);
        editTextHeartDate = view.findViewById(R.id.diagnosis_date_heart_failure);
        editTextKidneyDate = view.findViewById(R.id.diagnosis_date_kidney_failure);
        editTextNeuropahtyDate = view.findViewById(R.id.diagnosis_date_neuropathy);
        editTextVisualDate = view.findViewById(R.id.diagnosis_date_visual);
        editTextUlcersDate = view.findViewById(R.id.diagnosis_date_foot_ulcer);
        editTextErectileDate = view.findViewById(R.id.diagnosis_date_erectile);
        editTextOtherComplicationDate = view.findViewById(R.id.diagnosis_date_other);

        textWatcher(editTextStroke);
        textWatcher(editTextHeart);
        textWatcher(editTextKidney);
        textWatcher(editTextNeuropahty);
        textWatcher(editTextVisual);
        textWatcher(editTextUlcers);
        textWatcher(editTextErectile);
        textWatcher(editTextOtherComplication);

        textWatcher(editTextStrokeDate);
        textWatcher(editTextHeartDate);
        textWatcher(editTextKidneyDate);
        textWatcher(editTextNeuropahtyDate);
        textWatcher(editTextVisualDate);
        textWatcher(editTextUlcersDate);
        textWatcher(editTextErectileDate);
        textWatcher(editTextOtherProvision);

        return view;
    }

    public void textWatcher(EditText editText) {

        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(final Editable editable) {
                updateValues();
            }


            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

            }
        });
    }


    public void checkBox(final CheckBox checkBox) {

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                boolean checked = (buttonView).isChecked();

                //Check which checkbox was clicked
                switch (checkBox.getId()) {
                    case R.id.checkbox_complication_stroke:
                        if (checked) {
                            stroke = "111103";
                        } else {
                            stroke = "";
                        }
                        break;
                    case R.id.checkbox_complication_heart:
                        if (checked) {
                            heart = "139069";
                        } else {
                            heart = "";
                        }
                        break;
                    case R.id.checkbox_complication_kidney:
                        if (checked) {
                            kidney = "113338";
                        } else {
                            kidney = "";
                        }
                        break;
                    case R.id.checkbox_complication_neuropathy:
                        if (checked) {
                            neuropahty = "118983";
                        } else {
                            neuropahty = "";
                        }
                        break;
                    case R.id.checkbox_complication_visual:
                        if (checked) {
                            visual = "163411";
                        } else {
                            visual = "";
                        }
                        break;
                    case R.id.checkbox_complication_foot_ulcer:
                        if (checked) {
                            ulcers = "156162";
                        } else {
                            ulcers = "";
                        }
                        break;
                    case R.id.checkbox_complication_erectile:
                        if (checked) {
                            erectile = "156162";
                        } else {
                            erectile = "";
                        }
                        break;
                    case R.id.checkbox_complication_other:
                        if (checked) {
                            other = "5622";
                        } else {
                            other = "";
                        }
                        break;
                    case R.id.checkbox_nutrition:
                        if (checked) {
                            nutrition = "1380";
                        } else {
                            nutrition = "";
                        }
                        break;
                    case R.id.checkbox_physical_activity:
                        if (checked) {
                            activity = "159364";
                        } else {
                            activity = "";
                        }
                        break;
                    case R.id.checkbox_psychosocial:
                        if (checked) {
                            psychosocial = "5490";
                        } else {
                            psychosocial = "";
                        }
                        break;

                }

                updateValues();
            }
        });
    }

    public void radioButton(final RadioButton radioButton) {

        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Is the button now checked?
                boolean checked = (buttonView).isChecked();

                // Check which radio button was clicked
                switch (radioButton.getId()) {
                    case R.id.radio_diagnosis_stroke_resolved:
                        if (checked)
                            diagnosis_stroke = "6097";
                        break;
                    case R.id.radio_diagnosis_stroke_referral:
                        if (checked)
                            diagnosis_stroke = "165192";
                        break;
                    case R.id.radio_diagnosis_heart_failure_resolved:
                        if (checked)
                            diagnosis_heart = "6097";
                        break;
                    case R.id.radio_diagnosis_heart_failure_referral:
                        if (checked)
                            diagnosis_heart = "165192";
                        break;
                    case R.id.radio_diagnosis_kidney_failure_resolved:
                        if (checked)
                            diagnosis_kidney = "6097";
                        break;
                    case R.id.radio_diagnosis_kidney_failure_referral:
                        if (checked)
                            diagnosis_kidney = "165192";
                        break;
                    case R.id.radio_diagnosis_neuropathy_resolved:
                        if (checked)
                            diagnosis_neuropahty = "6097";
                        break;
                    case R.id.radio_diagnosis_neuropathy_referral:
                        if (checked)
                            diagnosis_neuropahty = "165192";
                        break;
                    case R.id.radio_diagnosis_visual_resolved:
                        if (checked)
                            diagnosis_visual = "6097";
                        break;
                    case R.id.radio_diagnosis_visual_referral:
                        if (checked)
                            diagnosis_visual = "165192";
                        break;
                    case R.id.radio_diagnosis_foot_ulcer_resolved:
                        if (checked)
                            diagnosis_ulcers = "6097";
                        break;
                    case R.id.radio_diagnosis_foot_ulcer_referral:
                        if (checked)
                            diagnosis_ulcers = "165192";
                        break;
                    case R.id.radio_diagnosis_erectile_resolved:
                        if (checked)
                            diagnosis_erectile = "6097";
                        break;
                    case R.id.radio_diagnosis_erectile_referral:
                        if (checked)
                            diagnosis_erectile = "165192";
                        break;
                    case R.id.radio_diagnosis_other_resolved:
                        if (checked)
                            diagnosis_other = "6097";
                        break;
                    case R.id.radio_diagnosis_other_referral:
                        if (checked)
                            diagnosis_other = "165192";
                        break;
                }

                updateValues();
            }
        });

    }

    public void updateValues() {

        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String current_date = dateFormat.format(new Date());

        JSONArray jsonArry = new JSONArray();

        jsonArry.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", stroke, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("159948", "165124", "valueCoded", editTextStrokeDate.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", diagnosis_stroke, current_date, editTextStroke.getText().toString().trim()));

        jsonArry.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", heart, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("159948", "165124", "valueCoded", editTextHeartDate.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", diagnosis_heart, current_date, editTextHeart.getText().toString().trim()));

        jsonArry.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", kidney, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("159948", "165124", "valueCoded", editTextKidneyDate.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", diagnosis_kidney, current_date, editTextKidney.getText().toString().trim()));

        jsonArry.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", neuropahty, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("159948", "165124", "valueCoded", editTextNeuropahtyDate.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", diagnosis_neuropahty, current_date, editTextNeuropahty.getText().toString().trim()));

        jsonArry.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", visual, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("159948", "165124", "valueCoded", editTextVisualDate.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", diagnosis_visual, current_date, editTextVisual.getText().toString().trim()));

        jsonArry.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", ulcers, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("159948", "165124", "valueCoded", editTextUlcersDate.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", diagnosis_ulcers, current_date, editTextUlcers.getText().toString().trim()));

        jsonArry.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", erectile, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("159948", "165124", "valueCoded", editTextErectileDate.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", diagnosis_erectile, current_date, editTextErectile.getText().toString().trim()));

        jsonArry.put(JSONFormBuilder.observations("6042", "165124", "valueCoded", other, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("159948", "165124", "valueCoded", editTextOtherComplicationDate.getText().toString().trim(), current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("165127", "165124", "valueCoded", diagnosis_other, current_date, editTextOtherComplication.getText().toString().trim()));

        jsonArry.put(JSONFormBuilder.observations("1379", "", "valueCoded", nutrition, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1379", "", "valueCoded", activity, current_date, ""));
        jsonArry.put(JSONFormBuilder.observations("1379", "", "valueCoded", psychosocial, current_date, ""));

        jsonArry.put(JSONFormBuilder.observations("1379", "", "valueCoded", editTextOtherProvision.getText().toString().trim(), current_date, ""));

        try {
            jsonArry = JSONFormBuilder.concatArray(jsonArry);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("JSON Initial Page 4", jsonArry.toString() + " ");

        FragmentModelFollowUp.getInstance().followUpFour(jsonArry);
    }

}
