package org.aihdint.aihd.fragments.dm_initial;

/**
 * Developed by Rodney on 26/04/2018.
 */
public class InitialActivityModel_One {

    public interface FragStateChangeListener {

        void dmDiagnosis(String diagnosis);
        void htnDiagnosis(String status);
        void hivStatus(String status);
        void nhifStatus(String status);
        void referralStatus(String status);
        void complaintStatus(String status);
    }

    private static InitialActivityModel_One mInstance;
    private FragStateChangeListener mListener;

    private InitialActivityModel_One() {
    }

    public static InitialActivityModel_One getInstance() {
        if (mInstance == null) mInstance = new InitialActivityModel_One();
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

    public void hivStatus(String status) {
        if (mListener != null) {
            mListener.hivStatus(status);
        }
    }

    public void nhifStatus(String status) {
        if (mListener != null) {
            mListener.nhifStatus(status);
        }
    }

    public void referralStatus(String status) {
        if (mListener != null) {
            mListener.referralStatus(status);
        }
    }

    public void complaintStatus(String status) {
        if (mListener != null) {
            mListener.complaintStatus(status);
        }
    }


}
