package com.degtu.cowid_19casesdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.degtu.cowid_19casesdata.databinding.ActivityDetailStateCasesBinding;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DetailStateCasesActivity extends AppCompatActivity {

    ActivityDetailStateCasesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailStateCasesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        String state = getIntent().getStringExtra("state");
        String confirmed = getIntent().getStringExtra("confirmed");
        String recovered = getIntent().getStringExtra("recovered");
        String deaths = getIntent().getStringExtra("deaths");
        String active = getIntent().getStringExtra("active");
        String deltaconfirmed = getIntent().getStringExtra("deltaconfirmed");
        String deltarecovered = getIntent().getStringExtra("deltarecovered");
        String deltadeaths = getIntent().getStringExtra("deltadeaths");
        String migrated = getIntent().getStringExtra("migrated");

        binding.toolstate.setText(state + " - statistics");
        binding.smallconfirmednumber.setText(NumberFormat.getInstance().format(Integer.parseInt(confirmed)));
        binding.smallrecoverednumber.setText(NumberFormat.getInstance().format(Integer.parseInt(recovered)));
        binding.deaths.setText(NumberFormat.getInstance().format(Integer.parseInt(deaths)));
        binding.smallactivenumber.setText(NumberFormat.getInstance().format(Integer.parseInt(active)));
        binding.deltaconfirmed.setText(NumberFormat.getInstance().format(Integer.parseInt(deltaconfirmed)));
        binding.deltadeaths.setText(NumberFormat.getInstance().format(Integer.parseInt(deltadeaths)));
        binding.deltarecovered.setText(NumberFormat.getInstance().format(Integer.parseInt(deltarecovered)));
        binding.migrated.setText(NumberFormat.getInstance().format(Integer.parseInt(migrated)));

        float confirmcases = Float.parseFloat(confirmed);
        float recoveredcases = Float.parseFloat(recovered);
        float activecases = Float.parseFloat(active);

        PieChart mPieChart = (PieChart) findViewById(R.id.piechart);

        mPieChart.addPieSlice(new PieModel("Confirmed",confirmcases,getResources().getColor(R.color.myfav)));
        mPieChart.addPieSlice(new PieModel("Recovered",recoveredcases,getResources().getColor(R.color.green)));
        mPieChart.addPieSlice(new PieModel("Active",activecases,getResources().getColor(R.color.orange)));

        mPieChart.startAnimation();

        DateFormat format = new SimpleDateFormat("MMM dd, yyyy");
        Calendar calendar = Calendar.getInstance();
        binding.date.setText(format.format(calendar.getTime()));

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}