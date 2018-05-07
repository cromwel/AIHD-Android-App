package org.aihdint.aihd.fragments.dm_initial;

/**
 * Developed by Rodney on 26/04/2018.
 */
public class FragmentModelInitial {
    public interface FragStateChangeListener {

        void initialOne(String dm_initial_date,String occupation_other,String diagnosis_diabetes_date,String diagnosis_hypertension_date,String hiv_other_status,
                        String tb_treatment_start,String tb_comment,String nhif_other,String referral_other,
                        String referral_other_details,String complaint_other,String complaint_lmp,String abuse_other,String occupation,String education);

        void initialTwo(String tag);

        void initialThree(String tag);

        void initialFour(String tag);

    }

    private static FragmentModelInitial mInstance;
    private FragStateChangeListener mListener;

    private FragmentModelInitial() {
    }

    public static FragmentModelInitial getInstance() {
        if (mInstance == null) mInstance = new FragmentModelInitial();
        return mInstance;
    }

    public void setListener(FragStateChangeListener listener) {
        mListener = listener;
    }

    public void initialOne(String dm_initial_date,String occupation_other ,String diagnosis_diabetes_date,String diagnosis_hypertension_date,String hiv_other_status,
                           String tb_treatment_start,String tb_comment,String nhif_other,String referral_other,
                           String referral_other_details,String complaint_other,String complaint_lmp,String abuse_other,String occupation,String education) {
        if (mListener != null) {
            mListener.initialOne(dm_initial_date, occupation_other,diagnosis_diabetes_date,diagnosis_hypertension_date,hiv_other_status,
                    tb_treatment_start,tb_comment,nhif_other,referral_other,referral_other_details,complaint_other,complaint_lmp,abuse_other,occupation,education);
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



