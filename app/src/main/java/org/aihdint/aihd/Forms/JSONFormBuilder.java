package org.aihdint.aihd.Forms;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

import org.json.JSONArray;
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
            if (!TextUtils.isEmpty(conceptAnswer)) {
                jsonObs.put("id", conceptID);
                jsonObs.put("answer", conceptAnswer);
                jsonObs.put("datetime", datetime);
                jsonObs.put("comment", comment);
            }

            //Json Object for Obeservation
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonObs;
    }

    public void m() {

        JSONArray jsonObs = new JSONArray();
        JSONArray jsonObs1 = new JSONArray();
        try {
            concatArray(jsonObs, jsonObs1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private JSONArray concatArray(JSONArray... arrs)
            throws JSONException {
        JSONArray result = new JSONArray();
        for (JSONArray arr : arrs) {
            for (int i = 0; i < arr.length(); i++) {
                result.put(arr.get(i));
            }
        }
        return result;
    }


}
