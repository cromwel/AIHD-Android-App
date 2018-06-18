package org.aihdint.aihd.Forms;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

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

    public static JSONObject observations(String conceptID, String groupID, String type, String conceptAnswer, String datetime, String comment) {

        JSONObject jsonObs = new JSONObject();

        try {
            //Values
            if (!TextUtils.isEmpty(conceptAnswer)) {
                jsonObs.put("id", conceptID);
                jsonObs.put("group_id", groupID);
                jsonObs.put("type", type);
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

    public static JSONArray concatArray(JSONArray... arrs)
            throws JSONException {
        JSONArray result = new JSONArray();
        for (JSONArray arr : arrs) {
            for (int i = 0; i < arr.length(); i++) {
                JSONObject element = (JSONObject) arr.get(i);
                if (element.length() > 0) {
                    result.put(arr.get(i));
                }

            }
        }

        return result;
    }


}
