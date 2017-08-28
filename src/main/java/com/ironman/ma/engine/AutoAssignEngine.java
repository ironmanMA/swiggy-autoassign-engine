package com.ironman.ma.engine;

import com.ironman.ma.dao.SwiggyObject;

import java.util.List;

/**
 * Created by 127.0.0.1.ma on 28/08/17.
 */
public interface AutoAssignEngine {
    /*
        has one method pickUpBestEntity
     */
    public List<? extends SwiggyObject> pickUpBestEntity();

    public List<? extends SwiggyObject> pickUpBestEntity(SwiggyObject swiggyObject);
}
