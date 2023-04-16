package com.degtu.cowid_19casesdata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.degtu.cowid_19casesdata.databinding.HelplinenumberofstatesBinding;

import java.util.List;

public class HelplineNumberAdapter extends RecyclerView.Adapter<HelplineNumberAdapter.HelplineViewHolder> {

    private Context context;
    private List<HelplineNumberData> helplineNumberData;

    public HelplineNumberAdapter(Context context, List<HelplineNumberData> helplineNumberData){
        this.context = context;
        this.helplineNumberData = helplineNumberData;
    }

    @NonNull
    @Override
    public HelplineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.helplinenumberofstates,parent,false);
        return new HelplineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HelplineViewHolder holder, int position) {

        HelplineNumberData helplineNumberData1 = helplineNumberData.get(position);
        holder.binding.loc.setText(helplineNumberData1.getLoc());
        holder.binding.contactnumber.setText(helplineNumberData1.getNumber());

    }

    @Override
    public int getItemCount() {
        return helplineNumberData.size();
    }

    public class HelplineViewHolder extends RecyclerView.ViewHolder {

        HelplinenumberofstatesBinding binding;

        public HelplineViewHolder(@NonNull View itemView) {
            super(itemView);

            binding = HelplinenumberofstatesBinding.bind(itemView);
        }
    }
}
