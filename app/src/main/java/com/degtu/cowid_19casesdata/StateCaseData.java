package com.degtu.cowid_19casesdata;

public class StateCaseData {

    private String state,active,confirmed,recovered,deaths,deltaconfirmed,deltadeaths,deltarecovered,migratedother;

    public StateCaseData(String state, String active, String confirmed, String recovered, String deaths, String deltaconfirmed, String deltadeaths, String deltarecovered, String migratedother) {
        this.state = state;
        this.active = active;
        this.confirmed = confirmed;
        this.recovered = recovered;
        this.deaths = deaths;
        this.deltaconfirmed = deltaconfirmed;
        this.deltadeaths = deltadeaths;
        this.deltarecovered = deltarecovered;
        this.migratedother = migratedother;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getDeltaconfirmed() {
        return deltaconfirmed;
    }

    public void setDeltaconfirmed(String deltaconfirmed) {
        this.deltaconfirmed = deltaconfirmed;
    }

    public String getDeltadeaths() {
        return deltadeaths;
    }

    public void setDeltadeaths(String deltadeaths) {
        this.deltadeaths = deltadeaths;
    }

    public String getDeltarecovered() {
        return deltarecovered;
    }

    public void setDeltarecovered(String deltarecovered) {
        this.deltarecovered = deltarecovered;
    }

    public String getMigratedother() {
        return migratedother;
    }

    public void setMigratedother(String migratedother) {
        this.migratedother = migratedother;
    }
}
