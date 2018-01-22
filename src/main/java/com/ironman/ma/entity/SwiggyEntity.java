package com.ironman.ma.entity;

import com.ironman.ma.dao.SwiggyObject;

import java.util.List;

/**
 * Created by 127.0.0.1.ma on 28/08/17.
 *
 * interfaces to ineract with Entities within Swiggy Ecosystem
 *
 */
public interface SwiggyEntity {

    /*
        returns all available entities overall
     */
    public List<? extends SwiggyObject> getAllEntities();


    /*
        returns all available entities in the given zone
     */
    public List<? extends SwiggyObject> getAllEntitiesInZone(int zoneId);


    /*
        returns all available entities on priority overall
     */
    public List<? extends SwiggyObject> getAllPriorityEntities();


    /*
        returns all available entities on priority in the given zone
     */
    public List<? extends SwiggyObject> getAllPriorityEntities(int zoneId);

}
