package org.aihdint.aihd.fragments.dm_followup;

/**
 * Developed by Rodney on 26/04/2018.
 */
public class FragmentModel {
    public interface FragStateChangeListener {

        void followUpOne(String mopc_number,String supporter_name, String supporter_phone);

        void followUpTwo(String tag);

        void followUpThree(String tag);

        void followUpFour(String tag);

        void initialOne(String tag);

        void initialTwo(String tag);

        void initialThree(String tag);

        void initialFour(String tag);

    }

    private static FragmentModel mInstance;
    private FragStateChangeListener mListener;

    private FragmentModel() {
    }

    public static FragmentModel getInstance() {
        if (mInstance == null) mInstance = new FragmentModel();
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


    public void initialOne(String mopc_number) {
        if (mListener != null) {
            mListener.initialOne(mopc_number);
        }
    }

    public void initialTwo(String mopc_number) {
        if (mListener != null) {
            mListener.initialTwo(mopc_number);
        }
    }

    public void initialThree(String mopc_number) {
        if (mListener != null) {
            mListener.initialThree(mopc_number);
        }
    }

    public void initialFour(String mopc_number) {
        if (mListener != null) {
            mListener.initialFour(mopc_number);
        }
    }

}



