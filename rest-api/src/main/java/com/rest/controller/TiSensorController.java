package com.rest.controller;

import java.util.Random;

import com.rest.config.Constants;
import com.rest.service.TiSensorService;
import com.rest.service.TiSensorServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.web.bind.annotation.*;

import com.rest.model.TiSensorDatapoint;

/**
 * Created by uday on 3/21/16.
 */

@RestController
public class TiSensorController {

    @Autowired
    TiSensorService tiSensorServiceImpl;
    
    //private final MessageSendingOperations<String> messagingTemplate;

    private static Logger logger = LoggerFactory.getLogger(
            TiSensorController.class);
    
    /*@Autowired
    public TiSensorController(
        final MessageSendingOperations<String> messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }*/


    @RequestMapping(value = "/datapoint", method = RequestMethod.POST,
            consumes = {"application/json"})
    public ResponseEntity<Void> checkAndInsertDataPoint(
            @RequestBody TiSensorDatapoint datapoint){
    	
        // check if tiSensorId is registered
        if(!tiSensorServiceImpl.isRegisteredIdAttachUserId(datapoint)){
            logger.info("Unregistered TiSensorId is received!");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        
        tiSensorServiceImpl.save(datapoint);
        //this.messagingTemplate.convertAndSend(
          //      "/data", datapoint.getTemperature());
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Void> sayHello(){
    	System.out.println("Hello from REST");
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
