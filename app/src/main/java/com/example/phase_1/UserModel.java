package com.example.phase_1;

public class UserModel {

    private String firstn,lastn,phonen,usern;

    public UserModel(String firstn, String lastn, String phonen, String usern) {
        this.firstn = firstn;
        this.lastn = lastn;
        this.phonen = phonen;   
        this.usern = usern;
    }

    public String getFirstn() {
        return firstn;
    }

    public void setFirstn(String firstn) {
        this.firstn = firstn;
    }

    public String getLastn() {
        return lastn;
    }

    public void setLastn(String lastn) {
        this.lastn = lastn;
    }

    public String getPhonen() {
        return phonen;
    }

    public void setPhonen(String phonen) {
        this.phonen = phonen;
    }

    public String getUsern() {
        return usern;
    }

    public void setUsern(String usern) {
        this.usern = usern;
    }
}