package com.degtu.cowid_19casesdata;

import java.util.List;

public class ListStateCase {

    private List<StateCaseData> stateCaseDataList;

    public ListStateCase(List<StateCaseData> stateCaseDataList) {
        this.stateCaseDataList = stateCaseDataList;
    }

    public List<StateCaseData> getStateCaseDataList() {
        return stateCaseDataList;
    }

    public void setStateCaseDataList(List<StateCaseData> stateCaseDataList) {
        this.stateCaseDataList = stateCaseDataList;
    }
}
