package com.ironman.ma.entity;

import com.ironman.ma.dao.DeliveryExec;

import java.util.ArrayList;
import java.util.List;

import static com.ironman.ma.AutoAssignMain.deliveryExecs;

/**
 * Created by 127.0.0.1.ma on 28/08/17.
 */
public class DeliveryExecEntitiy implements SwiggyEntity {

    public List<DeliveryExec> getAllEntities() {
        List<DeliveryExec> swiggyObjects = new ArrayList<DeliveryExec>();
        for (int i = 0; i < deliveryExecs.size(); i++) {
            if (!deliveryExecs.get(i).isInProgress()) {
                swiggyObjects.add(deliveryExecs.get(i));
            }
        }
        return swiggyObjects;
    }

    public List<DeliveryExec> getAllEntitiesInZone(int zoneId) {
        List<DeliveryExec> swiggyObjects = new ArrayList<DeliveryExec>();
        for (int i = 0; i < deliveryExecs.size(); i++) {
            if ((!deliveryExecs.get(i).isInProgress()) && deliveryExecs.get(i).getZoneId() == zoneId) {
                swiggyObjects.add(deliveryExecs.get(i));
            }
        }
        return swiggyObjects;
    }

    public List<DeliveryExec> getAllPriorityEntities() {
        return null;
    }

    public List<DeliveryExec> getAllPriorityEntities(int zoneId) {
        return null;
    }
}
