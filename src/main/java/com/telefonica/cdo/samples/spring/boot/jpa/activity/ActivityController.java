package com.telefonica.cdo.samples.spring.boot.jpa.activity;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityController {

    @Autowired
    private ActivityService service;

    @GetMapping(path = "/activities/{activityId}", produces = "application/json")
    public Optional<Activity> get(@PathVariable Long activityId) {
        return service.get(activityId);
    }

}
