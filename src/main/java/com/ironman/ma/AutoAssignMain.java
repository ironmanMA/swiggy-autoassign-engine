package com.ironman.ma;

import com.ironman.ma.dao.DeliveryExec;
import com.ironman.ma.dao.Order;
import com.ironman.ma.engine.DeliveryExecAssignEngine;
import com.ironman.ma.engine.OrderAssignEngine;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Hello world!
 */
public class AutoAssignMain {
    /*
            can be replaced by a DB
    */
    public static ArrayList<Order> orders = new ArrayList<Order>();
    public static ArrayList<DeliveryExec> deliveryExecs = new ArrayList<DeliveryExec>();

    public static void main(String[] args) throws InterruptedException {


        Calendar now = Calendar.getInstance();

        Order order = new Order("1", (float) 1.5, (float) 2.4);
        now.add(Calendar.MINUTE, -10);
        order.setCreationTime(now.getTime());
        order.setZoneId(1);
        orders.add(order);
        order = new Order("2", (float) 6.5, (float) 2.8);
        now.add(Calendar.MINUTE, -4);
        order.setCreationTime(now.getTime());
        order.setZoneId(1);
        orders.add(order);
        order = new Order("3", (float) 7.5, (float) 2.10);
        now.add(Calendar.MINUTE, -1);
        order.setCreationTime(now.getTime());
        order.setZoneId(2);
        order.setPriority(true);
        orders.add(order);

        DeliveryExec exec = new DeliveryExec("234", (float) 1.5, (float) 2.4);
        now.add(Calendar.MINUTE, -10);
        exec.setLastOrderTime(now.getTime());
        exec.setZoneId(1);
        deliveryExecs.add(exec);

        exec = new DeliveryExec("235", (float) 4.5, (float) 4.4);
        now.add(Calendar.MINUTE, -1);
        exec.setLastOrderTime(now.getTime());
        exec.setZoneId(1);
        deliveryExecs.add(exec);

        exec = new DeliveryExec("225", (float) 4.5, (float) 7.4);
        now.add(Calendar.MINUTE, -15);
        exec.setLastOrderTime(now.getTime());
        exec.setZoneId(2);
        deliveryExecs.add(exec);

        /*
            initialize on all orders
         */
        OrderAssignEngine orderAssignEngine = new OrderAssignEngine();
        /*
            initialize on all DeliverExec
         */
        DeliveryExecAssignEngine deliveryExecAssignEngine = new DeliveryExecAssignEngine();

        while (true) {
            /*
                pickup Order
             */
            Order bestOrder = (Order) orderAssignEngine.pickUpBestEntity().get(0);
            if (bestOrder == null) {
                /*
                    no more orders, so wait
                 */
                System.out.println("waiting for orders");
                Thread.sleep(10000);
            } else {
            /*
                pickup DeliveryExec
             */
                DeliveryExec bestDeliveryExec = (DeliveryExec) deliveryExecAssignEngine.pickUpBestEntity(bestOrder).get(0);
                if (bestDeliveryExec == null) {
                /*
                    no more exec, so wait
                 */
                    System.out.println("No DeliveryExecs available, will transfer to hot zone soon");
                    Thread.sleep(10000);
                /*
                    or transfer exec to that zone drive
                 */
                } else {

                    bestOrder.setInProgress(true);
                    bestDeliveryExec.setInProgress(true);

                    System.out.println("ORDER: " + bestOrder.getId() + ", DeliveryExec: " + bestDeliveryExec.getId());
                }
            }

        }
    }
}
