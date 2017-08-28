package com.ironman.ma.entity;

import com.ironman.ma.dao.SwiggyObject;

import java.util.List;

/**
 * Created by 127.0.0.1.ma on 28/08/17.
 */
public interface SwiggyEntity {

    public List<? extends SwiggyObject> getAllEntities();

    public List<? extends SwiggyObject> getAllEntitiesInZone(int zoneId);

    public List<? extends SwiggyObject> getAllPriorityEntities();

    public List<? extends SwiggyObject> getAllPriorityEntities(int zoneId);

}
