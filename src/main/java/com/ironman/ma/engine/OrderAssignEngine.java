package com.ironman.ma.engine;

import com.ironman.ma.dao.Order;
import com.ironman.ma.dao.SwiggyObject;
import com.ironman.ma.entity.OrderEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 127.0.0.1.ma on 28/08/17.
 */
public class OrderAssignEngine implements AutoAssignEngine {
    OrderEntity orderEntity = new OrderEntity();


    /*
        picks up orders that needs to be fulfilled urgently
     */
    public List<Order> pickUpBestEntity() {
        List<Order> orders = new ArrayList<Order>();

        //finish up oldest priority orders the first
        List<Order> allPriorityEntities = orderEntity.getAllPriorityEntities();
        if (allPriorityEntities.size() > 0) {
            orders.add(getOldestOrder(allPriorityEntities));
        } else {
            orders.add(getOldestOrder(orderEntity.getAllEntities()));
        }
        return orders;
    }

    private Order getOldestOrder(List<Order> list) {
        if (list.size() == 1)
            return list.get(0);
        Order swiggyObject = null;
        long max = -1;
        Date date = new Date();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getDelayTime(date) > max) {
                max = list.get(i).getDelayTime(date);
                swiggyObject = list.get(i);
            }
        }
        return swiggyObject;
    }

    /*
        this could be extended to pickup best order that needs to be fulfilled
     */
    public List<SwiggyObject> pickUpBestEntity(SwiggyObject swiggyObject) {
        return null;
    }
}
