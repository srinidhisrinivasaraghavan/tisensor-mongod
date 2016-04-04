package com.rest.service;

import com.rest.model.TiSensorDatapoint;
import org.springframework.stereotype.Service;

/**
 * Created by uday on 3/21/16.
 */

public interface TiSensorService {
    boolean isRegisteredIdAttachUserId(TiSensorDatapoint datapoint);
    void save(TiSensorDatapoint datapoint);
}
