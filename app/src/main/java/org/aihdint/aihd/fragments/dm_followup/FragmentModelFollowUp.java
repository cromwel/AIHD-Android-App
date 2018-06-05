package org.aihdint.aihd.fragments.dm_followup;

import org.json.JSONObject;

/**
 * Developed by Rodney on 26/04/2018.
 */
public class FragmentModelFollowUp {
    public interface FragStateChangeListener {

        void followUpOne(String supporter_name, JSONObject params);

        void followUpTwo(JSONObject params);

        void followUpThree(JSONObject params);

        void followUpFour(JSONObject params);

    }

    private static FragmentModelFollowUp mInstance;
    private FragStateChangeListener mListener;

    private FragmentModelFollowUp() {
    }

    public static FragmentModelFollowUp getInstance() {
        if (mInstance == null) mInstance = new FragmentModelFollowUp();
        return mInstance;
    }

    public void setListener(FragStateChangeListener listener) {
        mListener = listener;
    }

    public void followUpOne(String supporter_name, JSONObject params) {
        if (mListener != null) {
            mListener.followUpOne(supporter_name, params);
        }
    }

    public void followUpTwo(JSONObject params) {
        if (mListener != null) {
            mListener.followUpTwo(params);
        }
    }

    public void followUpThree(JSONObject params) {
        if (mListener != null) {
            mListener.followUpThree(params);
        }
    }

    public void followUpFour(JSONObject params) {
        if (mListener != null) {
            mListener.followUpFour(params);
        }
    }

}



