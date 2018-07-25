package org.aihdint.aihd.model.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.aihdint.aihd.Forms.DM_Initial_View;
import org.aihdint.aihd.R;
import org.aihdint.aihd.model.Forms;

import java.util.List;

/**
 * Developed by Rodney on 10/10/2017.
 */

public class FormAdapter extends RecyclerView.Adapter<FormAdapter.MyViewHolder> {

    private Context mContext;
    private List<Forms> formList;

    public FormAdapter(Context mContext, List<Forms> formList) {
        this.mContext = mContext;
        this.formList = formList;

    }

    @Override
    public FormAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_form, parent, false);

        return new FormAdapter.MyViewHolder(itemView);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView file_name;
        TextView date;
        Button status, status_sent;

        private MyViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            this.file_name = view.findViewById(R.id.file_name);
            this.date = view.findViewById(R.id.date);
            this.status = view.findViewById(R.id.status);
            this.status_sent = view.findViewById(R.id.status_sent);
        }

        @Override
        public void onClick(final View view) {

            @SuppressWarnings("deprecation") final Forms forms = formList.get(getPosition());

            String input = forms.getForm_name();
            String result = input.split("_")[2];
            Log.d("Form Type", result);

            Intent initial_view = new Intent(view.getContext(), DM_Initial_View.class);
            initial_view.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            initial_view.putExtra("form_id", forms.getForm_id());
            initial_view.putExtra("file_name", forms.getForm_name());
            initial_view.putExtra("status", forms.getStatus());
            mContext.startActivity(initial_view);

        }
    }

    @Override
    public void onBindViewHolder(final FormAdapter.MyViewHolder holder, int position) {
        final Forms forms = formList.get(position);

        holder.file_name.setText(forms.getForm_name());
        holder.date.setText(forms.getDate());

        if (!forms.getStatus().matches("0")) {
            holder.status_sent.setVisibility(View.VISIBLE);
            holder.status.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return formList.size();
    }

    public void searchList(List<Forms> list) {
        formList = list;
        notifyDataSetChanged();
    }

    /*
    public void clear() {
        int size = this.formList.size();
        this.formList.clear();
        notifyItemRangeRemoved(0, size);
    }
    */
}


