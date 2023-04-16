package com.degtu.cowid_19casesdata;

import java.util.ArrayList;

public class mainStates {

    private ArrayList<StateCaseData> statewise;

    public mainStates(ArrayList<StateCaseData> statewise) {
        this.statewise = statewise;
    }

    public ArrayList<StateCaseData> getStatewise() {
        return statewise;
    }

    public void setStatewise(ArrayList<StateCaseData> statewise) {
        this.statewise = statewise;
    }
}
