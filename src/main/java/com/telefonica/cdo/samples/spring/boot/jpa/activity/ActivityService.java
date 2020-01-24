package com.telefonica.cdo.samples.spring.boot.jpa.activity;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Transactional
    public Optional<Activity> get(Long activityId) {
        return activityRepository.findById(activityId);
    }

}
