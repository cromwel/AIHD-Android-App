package org.aihdint.aihd.fragments.dm_initial;

/**
 * Developed by Rodney on 26/04/2018.
 */
public class InitialActivityModel_Three {

    public interface FragStateChangeListener {

        void urinalysisGlucose(String status);

        void urinalysisProtein(String status);

        void urinalysisKetone(String status);
    }

    private static InitialActivityModel_Three mInstance;
    private FragStateChangeListener mListener;

    private InitialActivityModel_Three() {
    }

    public static InitialActivityModel_Three getInstance() {
        if (mInstance == null) mInstance = new InitialActivityModel_Three();
        return mInstance;
    }

    public void setListener(FragStateChangeListener listener) {
        mListener = listener;
    }


    public void urinalysisGlucose(String status) {
        if (mListener != null) {
            mListener.urinalysisGlucose(status);
        }
    }

    public void urinalysisProtein(String status) {
        if (mListener != null) {
            mListener.urinalysisProtein(status);
        }
    }

    public void urinalysisKetone(String status) {
        if (mListener != null) {
            mListener.urinalysisKetone(status);
        }
    }

}
