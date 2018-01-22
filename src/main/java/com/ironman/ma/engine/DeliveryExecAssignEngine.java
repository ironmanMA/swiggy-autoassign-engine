package com.ironman.ma.engine;

import com.ironman.ma.dao.DeliveryExec;
import com.ironman.ma.dao.Order;
import com.ironman.ma.dao.SwiggyObject;
import com.ironman.ma.entity.DeliveryExecEntitiy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 127.0.0.1.ma on 28/08/17.
 */
public class DeliveryExecAssignEngine implements AutoAssignEngine {

    DeliveryExecEntitiy deliveryExecEntitiy = new DeliveryExecEntitiy();

    public List<DeliveryExec> pickUpBestEntity() {
        return null;
    }

    public List<DeliveryExec> pickUpBestEntity(SwiggyObject swiggyObject) {

        List<DeliveryExec> deliveryExecList = new ArrayList<DeliveryExec>();

        /*
            can read these from any service of config table on database
         */
        double WAIT_TIME_MULTIPLIER = 1,
                TRAVEL_TIME_MULTIPLIER = 0.8;


        /*
            DeliveryExec understands order.
         */
        Order order = (Order) swiggyObject;

        /*
            get DeliveryExecs in the same zone of the order,
            this method can return neighbouring zoneID DeliveryExecs too
         */
        List<DeliveryExec> deliveryExecs = deliveryExecEntitiy.getAllEntitiesInZone(order.getZoneId());

        /*
            calculate cost of utilizing a executive.
         */
        double min_cost = Long.MAX_VALUE;
        DeliveryExec bestDeliveryExec = null;
        Date date = new Date();
        for (int i = 0; i < deliveryExecs.size(); i++) {
            DeliveryExec deliveryExec = deliveryExecs.get(i);

            /*
                calculate rank of DE's, in this case cost of util
             */
            double total_cost = WAIT_TIME_MULTIPLIER * (deliveryExec.getDelayTime(date)) +
                    TRAVEL_TIME_MULTIPLIER * (deliveryExec.getTravelDistFromOrder(order));
            if (total_cost < min_cost) {
                min_cost = total_cost;
                bestDeliveryExec = deliveryExec;
            }
        }
        deliveryExecList.add(bestDeliveryExec);


        //return the exec with least cost util
        return deliveryExecList;
    }
}
