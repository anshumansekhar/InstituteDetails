package com.example.anshuman_hp.institutedetails;

/**
 * Created by Anshuman-HP on 01-04-2017.
 */

public class Institue {
    String instiute_name;
    String state;
    String institue_img_url;
    String id;
    String about;

    public Institue(String instiute_name, String state, String institue_img_url, String id,String about) {
        this.instiute_name = instiute_name;
        this.state = state;
        this.institue_img_url = institue_img_url;
        this.id = id;
        this.about=about;
    }

    public String getInstiute_name() {
        return instiute_name;
    }

    public void setInstiute_name(String instiute_name) {
        this.instiute_name = instiute_name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getInstitue_img_url() {
        return institue_img_url;
    }

    public void setInstitue_img_url(String institue_img_url) {
        this.institue_img_url = institue_img_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
