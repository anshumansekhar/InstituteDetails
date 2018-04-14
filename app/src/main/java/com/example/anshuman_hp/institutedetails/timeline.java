package com.example.anshuman_hp.institutedetails;

/**
 * Created by Anshuman-HP on 01-04-2017.
 */

public class timeline {
    String username;
    String Collegename;
    int userurl;
    int imageurl;
    String numoflikes;
    String numofdislikes;
    String Eventdetails;
    String numofviewers;

    public timeline(String username, String collegename, int userurl, int imageurl, String numoflikes, String numofdislikes, String eventdetails, String numofviewers) {
        this.username = username;
        Collegename = collegename;
        this.userurl = userurl;
        this.imageurl = imageurl;
        this.numoflikes = numoflikes;
        this.numofdislikes = numofdislikes;
        Eventdetails = eventdetails;
        this.numofviewers = numofviewers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCollegename() {
        return Collegename;
    }

    public void setCollegename(String collegename) {
        Collegename = collegename;
    }

    public int getUserurl() {
        return userurl;
    }

    public void setUserurl(int userurl) {
        this.userurl = userurl;
    }

    public int getImageurl() {
        return imageurl;
    }

    public void setImageurl(int imageurl) {
        this.imageurl = imageurl;
    }

    public String getNumoflikes() {
        return numoflikes;
    }

    public void setNumoflikes(String numoflikes) {
        this.numoflikes = numoflikes;
    }

    public String getNumofdislikes() {
        return numofdislikes;
    }

    public void setNumofdislikes(String numofdislikes) {
        this.numofdislikes = numofdislikes;
    }

    public String getEventdetails() {
        return Eventdetails;
    }

    public void setEventdetails(String eventdetails) {
        Eventdetails = eventdetails;
    }

    public String getNumofviewers() {
        return numofviewers;
    }

    public void setNumofviewers(String numofviewers) {
        this.numofviewers = numofviewers;
    }
}
