package com.ironman.ma.engine;

import com.ironman.ma.dao.SwiggyObject;

import java.util.List;

/**
 * Created by 127.0.0.1.ma on 28/08/17.
 *
 * This would be core engine which would assign 2 entities
 * in this case (Order, DeliveryExec)
 *
 */
public interface AutoAssignEngine {
    /*
        This pickup Entity that needs to be fulfilled the first
        in this case the Order that needs to be fulfilled first

        List because this could work in batches
     */
    public List<? extends SwiggyObject> pickUpBestEntity();


    /*
        Given the entity this picks up the best resource to move that entitiy
        in this case which Delivery Executive needs to be assigned,
        or given a zone-id pickup the orders that need to assigned urgently

        List because this could work in batches
     */
    public List<? extends SwiggyObject> pickUpBestEntity(SwiggyObject swiggyObject);
}
