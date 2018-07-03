package org.aihdint.aihd.Forms;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.SimpleMultiPartRequest;
import com.android.volley.toolbox.Volley;

import org.aihdint.aihd.model.KeyValue;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static org.aihdint.aihd.app.Config.FILE_UPLOAD_URL;

public class File_Upload {


    // Progress dialog
    public static ProgressDialog showProgressDialog(Context context, String message) {
        ProgressDialog m_Dialog = new ProgressDialog(context);
        m_Dialog.setMessage(message);
        m_Dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        m_Dialog.setCancelable(false);
        m_Dialog.show();
        return m_Dialog;
    }


    public static boolean Connectivity(final Context mContext) {
        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);

        assert cm != null;
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }


    public static void upload(final Context mContext, final String filePath, ArrayList<KeyValue> keyValues) {

        SimpleMultiPartRequest smr = new SimpleMultiPartRequest(Request.Method.POST, FILE_UPLOAD_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Upload Response", response);

                        try {
                            JSONObject jObj = new JSONObject(response);
                            boolean error = jObj.getBoolean("error");
                            if (!error) {
                                // User successfully stored in MySQL
                                // Now store the user in sqlite
                                Toast.makeText(mContext, "Form successfully uploaded.!", Toast.LENGTH_LONG).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        if (keyValues != null) {
            for (KeyValue keyValue : keyValues) {
                smr.addStringParam(keyValue.getId(), keyValue.getName());
            }
        }
        //
        smr.addFile("image", filePath);
        smr.setFixedStreamingMode(true);
        smr.setOnProgressListener(new Response.ProgressListener() {
            @Override
            public void onProgress(long transferredBytes, long totalSize) {
                int percentage = (int) ((transferredBytes / ((float) totalSize)) * 100);
                Log.d("Upload Percentage ", String.valueOf(percentage));

            }
        });

        RequestQueue mRequestQueue = Volley.newRequestQueue(mContext);
        mRequestQueue.add(smr);
    }


    /*
    public static void testString(ArrayList<KeyValue> keyValues) {
        for (KeyValue keyValue : keyValues) {
            Log.d("KeyValue Pair ", keyValue.getId() + " : " + keyValue.getName());
        }
    }
    ArrayList<KeyValue> keyvalueParams = new ArrayList<>();

    keyvalueParams.add(new KeyValue("1540", "Employed"));
    keyvalueParams.add(new KeyValue("165170", "Unemployed"));

    File_Upload.testString(keyvalueParams);
    */
}
