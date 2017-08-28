package com.ironman.ma.dao;

/**
 * Created by 127.0.0.1.ma on 28/08/17.
 */
public abstract class SwiggyObject {
    Float latitdue, longitude;
    String name, contact;
    boolean inProgress = false;
    String id;

    public SwiggyObject(String id, Float lat, Float Long) {
        this.id = id;
        this.latitdue = lat;
        this.longitude = Long;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }

    public Float getLatitdue() {
        return latitdue;
    }

    public void setLatitdue(Float latitdue) {
        this.latitdue = latitdue;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
