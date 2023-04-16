package com.degtu.cowid_19casesdata;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.anychart.anychart.AnyChart;
import com.anychart.anychart.AnyChartView;
import com.anychart.anychart.DataEntry;
import com.anychart.anychart.Pie;
import com.anychart.anychart.ValueDataEntry;
import com.bumptech.glide.Glide;
import com.degtu.cowid_19casesdata.databinding.ActivityDetailCountryCase2Binding;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.charts.ValueLineChart;
import org.eazegraph.lib.models.PieModel;
import org.eazegraph.lib.models.ValueLinePoint;
import org.eazegraph.lib.models.ValueLineSeries;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DetailCountryCase2Activity extends AppCompatActivity {

    ActivityDetailCountryCase2Binding binding;
    private Context context;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailCountryCase2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        String cases = getIntent().getStringExtra("confirm");
        String flag = getIntent().getStringExtra("flag");
        String countryname = getIntent().getStringExtra("name");
        String active = getIntent().getStringExtra("active");
        String recovered = getIntent().getStringExtra("recovered");
        String deaths = getIntent().getStringExtra("deaths");
        String tests = getIntent().getStringExtra("tests");
        String todaycase = getIntent().getStringExtra("todaycase");
        String todayrecovered = getIntent().getStringExtra("todayrecovered");
        String todaydeath = getIntent().getStringExtra("todaydeath");
        String critical = getIntent().getStringExtra("critical");
        String caseperonemillion = getIntent().getStringExtra("caseperonemillion");
        String deathperonemillion = getIntent().getStringExtra("deathperonemillion");
        String testsperonemillion = getIntent().getStringExtra("testsperonemillion");
        String oneCasePerPeople = getIntent().getStringExtra("oneCasePerPeople");
        String oneDeathPerPeople = getIntent().getStringExtra("oneDeathPerPeople");
        String oneTestPerPeople = getIntent().getStringExtra("oneTestPerPeople");
        String activePerOneMillion = getIntent().getStringExtra("activePerOneMillion");
        String recoveredPerOneMillion = getIntent().getStringExtra("recoveredPerOneMillion");
        String criticalPerOneMillion = getIntent().getStringExtra("criticalPerOneMillion");
        String population = getIntent().getStringExtra("population");
        String continent = getIntent().getStringExtra("continent");
        String updated = getIntent().getStringExtra("updated");
        String countryimage = getIntent().getStringExtra("countryimage");

        float confirmcases = Float.parseFloat(cases);
        float recoveredcases = Float.parseFloat(recovered);
        float activecases = Float.parseFloat(active);

        PieChart mPieChart = (PieChart) findViewById(R.id.piechart);

        mPieChart.addPieSlice(new PieModel("Confirmed",confirmcases,getResources().getColor(R.color.myfav)));
        mPieChart.addPieSlice(new PieModel("Recovered",recoveredcases,getResources().getColor(R.color.green)));
        mPieChart.addPieSlice(new PieModel("Active",activecases,getResources().getColor(R.color.orange)));

        mPieChart.startAnimation();


        binding.smallconfirmednumber.setText(NumberFormat.getInstance().format(Integer.parseInt(cases)));
        binding.deathnumbers.setText(NumberFormat.getInstance().format(Integer.parseInt(deaths)));
        binding.smallactivenumber.setText(NumberFormat.getInstance().format(Integer.parseInt(active)));
        binding.smallrecoverednumber.setText(NumberFormat.getInstance().format(Integer.parseInt(recovered)));
        binding.testnumbers.setText(NumberFormat.getInstance().format(Integer.parseInt(tests)));
        binding.criticalnumbers.setText(NumberFormat.getInstance().format(Integer.parseInt(critical)));
        binding.casespermillion.setText(NumberFormat.getInstance().format(Integer.parseInt(caseperonemillion)));
        binding.todaycases.setText(NumberFormat.getInstance().format(Integer.parseInt(todaycase)));
        binding.todaydeath.setText(NumberFormat.getInstance().format(Integer.parseInt(todaydeath)));
        binding.todayrecovered.setText(NumberFormat.getInstance().format(Integer.parseInt(todayrecovered)));
        binding.deathperonemillion.setText(NumberFormat.getInstance().format(Integer.parseInt(deathperonemillion)));
        DateFormat format = new SimpleDateFormat("MMM dd, yyyy");
        long milliseconds = Long.parseLong(updated);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliseconds);
        binding.date.setText(format.format(calendar.getTime()));



        binding.countryname.setText(countryname + " - statistics");
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}

