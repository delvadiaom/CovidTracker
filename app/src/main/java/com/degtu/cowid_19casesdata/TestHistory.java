package com.degtu.cowid_19casesdata;

import java.util.List;

public class TestHistory {

    private List<TestingHistoryData> data;

    public TestHistory(List<TestingHistoryData> data) {
        this.data = data;
    }

    public List<TestingHistoryData> getData() {
        return data;
    }

    public void setData(List<TestingHistoryData> data) {
        this.data = data;
    }
}
