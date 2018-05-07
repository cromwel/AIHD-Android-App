package org.aihdint.aihd.fragments.dm_initial;

/**
 * Developed by Rodney on 26/04/2018.
 */
public class InitialActivityModel_Two {

    public interface FragStateChangeListener {

        void medicationNone(String status);
        void medicationOther(String check);
    }

    private static InitialActivityModel_Two mInstance;
    private FragStateChangeListener mListener;

    private InitialActivityModel_Two() {
    }

    public static InitialActivityModel_Two getInstance() {
        if (mInstance == null) mInstance = new InitialActivityModel_Two();
        return mInstance;
    }

    public void setListener(FragStateChangeListener listener) {
        mListener = listener;
    }


    public void medicationNone(String status) {
        if (mListener != null) {
            mListener.medicationNone(status);
        }
    }

    public void medicationOther(String check) {
        if (mListener != null) {
            mListener.medicationOther(check);
        }
    }

}
