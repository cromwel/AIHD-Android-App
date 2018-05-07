package org.aihdint.aihd.fragments.dm_followup;

/**
 * Developed by Rodney on 26/04/2018.
 */
public class FragmentModelFollowUp {
    public interface FragStateChangeListener {

        void followUpOne(String mopc_number,String supporter_name, String supporter_phone);

        void followUpTwo(String tag);

        void followUpThree(String tag);

        void followUpFour(String tag);

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

    public void followUpOne(String mopc_number,String supporter_name, String supporter_phone) {
        if (mListener != null) {
            mListener.followUpOne(mopc_number,supporter_name,supporter_phone);
        }
    }

    public void followUpTwo(String mopc_number) {
        if (mListener != null) {
            mListener.followUpTwo(mopc_number);
        }
    }

    public void followUpThree(String mopc_number) {
        if (mListener != null) {
            mListener.followUpThree(mopc_number);
        }
    }

    public void followUpFour(String mopc_number) {
        if (mListener != null) {
            mListener.followUpFour(mopc_number);
        }
    }

}



