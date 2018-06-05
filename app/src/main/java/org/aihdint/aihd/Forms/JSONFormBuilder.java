package org.aihdint.aihd.Forms;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

public class JSONFormBuilder {

    private Context mContext;

    public JSONFormBuilder(Context mContext) {
        this.mContext = mContext;
    }

    public static JSONObject observations(String conceptID, String conceptAnswer, String datetime, String comment) {

        JSONObject jsonObs = new JSONObject();

        try {
            //Values
            if (!conceptAnswer.matches("")) {
                jsonObs.put(conceptID, conceptAnswer);
                jsonObs.put("datetime", datetime);
                jsonObs.put("comment", comment);
            }
            //Json Object for Obeservation
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObs;
    }

}
