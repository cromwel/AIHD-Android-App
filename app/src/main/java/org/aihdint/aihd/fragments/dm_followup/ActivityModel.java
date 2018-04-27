package org.aihdint.aihd.fragments.dm_followup;

/**
 * Developed by Rodney on 26/04/2018.
 */
public class ActivityModel {

    public interface FragStateChangeListener {

        void dmDiagnosis(String diagnosis);
        void htnDiagnosis(String status);
    }

    private static ActivityModel mInstance;
    private FragStateChangeListener mListener;

    private ActivityModel() {
    }

    public static ActivityModel getInstance() {
        if (mInstance == null) mInstance = new ActivityModel();
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
