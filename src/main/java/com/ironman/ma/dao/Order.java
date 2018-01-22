package com.ironman.ma.dao;

import java.util.Date;

/**
 * Created by 127.0.0.1.ma on 28/08/17.
 *
 * An Order refers to order placed by an individual,
 * params like
 *  creationTime, zoneId are pickup from data store
 *  isPriority refers to a customer being "Prime Customer"
 *      this gives the order a priority and will be tried to fullfill faster
 *
 */
public class Order extends SwiggyObject {

    Date creationTime;

    /*
    can just use Restaurant ref, but for ease
     */
    int zoneId;

    /*
        can just use Customer ref, but for ease
     */
    boolean isPriority = false;

    boolean isComplete = false;

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public Order(String id, Float lat, Float Long) {
        super(id, lat, Long);
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public long getDelayTime(Date date) {
        return date.getTime() - creationTime.getTime();
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public int getZoneId() {
        return zoneId;
    }

    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }

    public boolean isPriority() {
        return isPriority;
    }

    public void setPriority(boolean priority) {
        isPriority = priority;
    }
}
