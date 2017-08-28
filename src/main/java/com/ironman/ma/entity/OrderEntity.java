package com.ironman.ma.entity;

import com.ironman.ma.dao.Order;

import java.util.ArrayList;
import java.util.List;

import static com.ironman.ma.AutoAssignMain.orders;

/**
 * Created by 127.0.0.1.ma on 28/08/17.
 */
public class OrderEntity implements SwiggyEntity {

    public List<Order> getAllEntities() {
        /*
            get all unfulfilled orders
         */
        List<Order> swiggyObjects = new ArrayList<Order>();
        for (int i = 0; i < orders.size(); i++) {
            /*
                pick those which are not complete and not in-progress
             */
            if (!orders.get(i).isInProgress() && !orders.get(i).isComplete()) {
                swiggyObjects.add(orders.get(i));
            }
        }
        return swiggyObjects;
    }

    public List<Order> getAllEntitiesInZone(int zoneId) {
        /*
            get all unfulfilled orders in a zone
         */
        List<Order> swiggyObjects = new ArrayList<Order>();
        for (int i = 0; i < orders.size(); i++) {
            /*
                pick those which are not complete and not in-progress
                and in the same zone
             */
            if ((!orders.get(i).isInProgress() && !orders.get(i).isComplete()) && orders.get(i).getZoneId() == zoneId) {
                swiggyObjects.add(orders.get(i));
            }
        }
        return swiggyObjects;
    }

    public List<Order> getAllPriorityEntities() {
        /*
            get all unfulfilled orders with SwiggyPrime
         */
        List<Order> swiggyObjects = new ArrayList<Order>();
        for (int i = 0; i < orders.size(); i++) {
            /*
                pick those which are not complete and not in-progress
                and are priority
             */
            if ((!orders.get(i).isInProgress() && !orders.get(i).isComplete()) && orders.get(i).isPriority()) {
                swiggyObjects.add(orders.get(i));
            }
        }
        return swiggyObjects;
    }

    public List<Order> getAllPriorityEntities(int zoneId) {
        /*
            get all unfulfilled orders with SwiggyPrime, in a zone
         */
        List<Order> swiggyObjects = new ArrayList<Order>();
        for (int i = 0; i < orders.size(); i++) {
            /*
                pick those which are not complete and not in-progress
                and are priority
                and are in the same zone
             */
            if ((!orders.get(i).isInProgress() && !orders.get(i).isComplete())
                    && orders.get(i).isPriority()
                    && orders.get(i).getZoneId() == zoneId) {
                swiggyObjects.add(orders.get(i));
            }
        }
        return swiggyObjects;
    }
}
