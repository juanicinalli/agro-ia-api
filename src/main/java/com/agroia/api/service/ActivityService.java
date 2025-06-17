package com.agroia.api.service;

import com.agroia.api.model.Activity;
import java.util.List;

public interface ActivityService {
    Activity createActivity(Activity activity);
    List<Activity> getActivitiesByFieldId(Long fieldId);
    Activity getActivityById(Long id);
    Activity updateActivity(Long id, Activity activity);
    void deleteActivity(Long id);
}
