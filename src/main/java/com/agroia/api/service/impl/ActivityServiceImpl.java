package com.agroia.api.service.impl;

import com.agroia.api.model.Activity;
import com.agroia.api.repository.ActivityRepository;
import com.agroia.api.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public List<Activity> getActivitiesByFieldId(Long fieldId) {
        return activityRepository.findByFieldId(fieldId);
    }

    @Override
    public Activity getActivityById(Long id) {
        return activityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity not found with id: " + id));
    }

    @Override
    public Activity updateActivity(Long id, Activity activity) {
        Activity existingActivity = getActivityById(id);
        existingActivity.setType(activity.getType());
        existingActivity.setDate(activity.getDate());
        existingActivity.setProduct(activity.getProduct());
        return activityRepository.save(existingActivity);
    }

    @Override
    public void deleteActivity(Long id) {
        Activity activity = getActivityById(id);
        activityRepository.delete(activity);
    }
}
