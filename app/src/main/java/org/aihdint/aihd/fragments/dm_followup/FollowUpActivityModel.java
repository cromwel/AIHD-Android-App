package org.aihdint.aihd.fragments.dm_followup;

/**
 * Developed by Rodney on 26/04/2018.
 */
public class FollowUpActivityModel {

    public interface FragStateChangeListener {

        void dmDiagnosis(String diagnosis);
        void htnDiagnosis(String status);
    }

    private static FollowUpActivityModel mInstance;
    private FragStateChangeListener mListener;

    private FollowUpActivityModel() {
    }

    public static FollowUpActivityModel getInstance() {
        if (mInstance == null) mInstance = new FollowUpActivityModel();
        return mInstance;
    }

    public void setListener(FragStateChangeListener listener) {
        mListener = listener;
    }

    public void dmDiagnosis(String diagnosis) {
        if (mListener != null) {
            mListener.dmDiagnosis(diagnosis);
        }
    }

    public void htnDiagnosis(String status) {
        if (mListener != null) {
            mListener.htnDiagnosis(status);
        }
    }

}
