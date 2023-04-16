package com.degtu.cowid_19casesdata;

public class TestingHistoryData {

    private String day,totalSamplesTested,totalIndividualsTested,totalPositiveCases,source;

    public TestingHistoryData() {
    }

    public TestingHistoryData(String day, String totalSamplesTested, String totalIndividualsTested, String totalPositiveCases, String source) {
        this.day = day;
        this.totalSamplesTested = totalSamplesTested;
        this.totalIndividualsTested = totalIndividualsTested;
        this.totalPositiveCases = totalPositiveCases;
        this.source = source;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTotalSamplesTested() {
        return totalSamplesTested;
    }

    public void setTotalSamplesTested(String totalSamplesTested) {
        this.totalSamplesTested = totalSamplesTested;
    }

    public String getTotalIndividualsTested() {
        return totalIndividualsTested;
    }

    public void setTotalIndividualsTested(String totalIndividualsTested) {
        this.totalIndividualsTested = totalIndividualsTested;
    }

    public String getTotalPositiveCases() {
        return totalPositiveCases;
    }

    public void setTotalPositiveCases(String totalPositiveCases) {
        this.totalPositiveCases = totalPositiveCases;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
