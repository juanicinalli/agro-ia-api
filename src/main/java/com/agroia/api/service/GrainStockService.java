package com.agroia.api.service;

import com.agroia.api.model.GrainStock;
import com.agroia.api.model.GrainStock.GrainItem;
import java.util.Map;

public interface GrainStockService {
    GrainStock getGrainStock();
    void updateGrainStock(Map<String, GrainItem> grains);
    void addGrain(String grainName, GrainItem grainItem);
    void updateGrain(String grainName, GrainItem grainItem);
    void removeGrain(String grainName);
}
