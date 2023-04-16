package com.degtu.cowid_19casesdata;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.degtu.cowid_19casesdata.databinding.CountryItemBinding;
import com.degtu.cowid_19casesdata.databinding.StateItemBinding;

import java.util.List;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.StateViewHolder> {

    private Context context;
    private List<StateCaseData> stateCaseDataList;

    public StateAdapter(Context context, List<StateCaseData> stateCaseDataList) {
        this.context = context;
        this.stateCaseDataList = stateCaseDataList;
    }

    public void setStateCaseDataList(List<StateCaseData> stateCaseDataList){
        this.stateCaseDataList = stateCaseDataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.state_item,parent,false);
        return new StateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StateViewHolder holder, int position) {

        StateCaseData stateCaseData = stateCaseDataList.get(position);
        holder.binding.countryname.setText(stateCaseData.getState());

        int cases = Integer.parseInt(stateCaseData.getActive());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailStateCasesActivity.class);
                intent.putExtra("state",stateCaseData.getState());
                intent.putExtra("confirmed",stateCaseData.getConfirmed());
                intent.putExtra("recovered",stateCaseData.getRecovered());
                intent.putExtra("active",stateCaseData.getActive());
                intent.putExtra("deaths",stateCaseData.getDeaths());
                intent.putExtra("deltaconfirmed",stateCaseData.getDeltaconfirmed());
                intent.putExtra("deltarecovered",stateCaseData.getDeltarecovered());
                intent.putExtra("deltadeaths",stateCaseData.getDeltadeaths());
                intent.putExtra("migrated",stateCaseData.getMigratedother());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return stateCaseDataList.size();
    }

    public class StateViewHolder extends RecyclerView.ViewHolder{

        StateItemBinding binding;

        public StateViewHolder(@NonNull View itemView) {
            super(itemView);

            binding = StateItemBinding.bind(itemView);
        }
    }
}
