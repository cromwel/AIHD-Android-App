package org.aihdint.aihd.fragments.dm_followup;

/**
 * Developed by Rodney on 26/04/2018.
 */
public class FollowUpActivityModel_Four {

    public interface FragStateChangeListener {

        void updateValues();
    }

    private static FollowUpActivityModel_Four mInstance;
    private FragStateChangeListener mListener;

    private FollowUpActivityModel_Four() {
    }

    public static FollowUpActivityModel_Four getInstance() {
        if (mInstance == null) mInstance = new FollowUpActivityModel_Four();
        return mInstance;
    }

    public void setListener(FragStateChangeListener listener) {
        mListener = listener;
    }

    public void updateValues() {
        if (mListener != null) {
            mListener.updateValues();
        }
    }


}
