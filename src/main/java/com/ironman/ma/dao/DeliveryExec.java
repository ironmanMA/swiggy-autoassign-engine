package com.ironman.ma.dao;

import java.util.Date;

/**
 * Created by 127.0.0.1.ma on 28/08/17.
 */
public class DeliveryExec extends SwiggyObject {

    Date lastOrderTime;
    int zoneId;

    public DeliveryExec(String id, Float lat, Float Long) {
        super(id, lat, Long);
    }

    public long getDelayTime(Date date) {
        return date.getTime() - lastOrderTime.getTime();
    }

    public double getTravelDistFromOrder(Order order) {
        return (Math.abs(order.getLatitdue() - getLatitdue()) + Math.abs(order.getLongitude() - getLongitude()));
    }

    public Date getLastOrderTime() {
        return lastOrderTime;
    }

    public void setLastOrderTime(Date lastOrderTime) {
        this.lastOrderTime = lastOrderTime;
    }

    public int getZoneId() {
        return zoneId;
    }

    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }
}
