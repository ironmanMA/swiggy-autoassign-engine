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

    public List<Order> pickUpBestEntity() {
        List<Order> orders = new ArrayList<Order>();
        List<Order> swiggyObjects = orderEntity.getAllPriorityEntities();
        if (swiggyObjects.size() > 0) {
            orders.add(getOldestOrder(swiggyObjects));
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

    public List<SwiggyObject> pickUpBestEntity(SwiggyObject swiggyObject) {
        return null;
    }
}
