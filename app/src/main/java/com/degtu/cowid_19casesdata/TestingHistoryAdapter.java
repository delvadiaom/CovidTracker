package com.degtu.cowid_19casesdata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.degtu.cowid_19casesdata.databinding.TestingHistoryBinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class TestingHistoryAdapter extends RecyclerView.Adapter<TestingHistoryAdapter.TestingHistoryViewHolder> {

    private Context context;
    private List<TestingHistoryData> testingHistoryDataList;

    public TestingHistoryAdapter(Context context, List<TestingHistoryData> testingHistoryDataList) {
        this.context = context;
        this.testingHistoryDataList = testingHistoryDataList;
    }

    @NonNull
    @Override
    public TestingHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.testing_history,parent,false);
        return new TestingHistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestingHistoryViewHolder holder, int position) {

        TestingHistoryData testingHistoryData = testingHistoryDataList.get(position);
        holder.binding.date.setText(testingHistoryData.getDay());
        holder.binding.totalSamplesTested.setText(testingHistoryData.getTotalSamplesTested());
        holder.binding.totalIndividualsTested.setText(testingHistoryData.getTotalIndividualsTested());
        holder.binding.totalPositiveCases.setText(testingHistoryData.getTotalPositiveCases());

        if (holder.binding.totalIndividualsTested.equals(null)){
            holder.binding.totalIndividualsTested.setText("Loading...");
        }else if (holder.binding.totalPositiveCases.equals(null)){
            holder.binding.totalPositiveCases.setText("Loading...");
        }


    }

    @Override
    public int getItemCount() {
        return testingHistoryDataList.size();
    }

    public class TestingHistoryViewHolder extends RecyclerView.ViewHolder{

        TestingHistoryBinding binding;

        public TestingHistoryViewHolder(@NonNull View itemView) {
            super(itemView);

            binding = TestingHistoryBinding.bind(itemView);
        }
    }
}
