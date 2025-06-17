package com.agroia.api.service.impl;

import com.agroia.api.model.GrainStock;
import com.agroia.api.model.GrainStock.GrainItem;
import com.agroia.api.repository.GrainStockRepository;
import com.agroia.api.service.GrainStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class GrainStockServiceImpl implements GrainStockService {
    @Autowired
    private GrainStockRepository grainStockRepository;

    @Override
    public GrainStock getGrainStock() {
        return grainStockRepository.findAll().stream()
                .findFirst()
                .orElseGet(() -> {
                    GrainStock stock = new GrainStock();
                    stock.setGrains(Map.of());
                    return grainStockRepository.save(stock);
                });
    }

    @Override
    public void updateGrainStock(Map<String, GrainItem> grains) {
        GrainStock stock = getGrainStock();
        stock.setGrains(grains);
        grainStockRepository.save(stock);
    }

    @Override
    public void addGrain(String grainName, GrainItem grainItem) {
        GrainStock stock = getGrainStock();
        Map<String, GrainItem> grains = stock.getGrains();
        grains.put(grainName.toLowerCase(), grainItem);
        stock.setGrains(grains);
        grainStockRepository.save(stock);
    }

    @Override
    public void updateGrain(String grainName, GrainItem grainItem) {
        GrainStock stock = getGrainStock();
        Map<String, GrainItem> grains = stock.getGrains();
        if (grains.containsKey(grainName.toLowerCase())) {
            grains.put(grainName.toLowerCase(), grainItem);
            stock.setGrains(grains);
            grainStockRepository.save(stock);
        } else {
            throw new RuntimeException("Grain not found: " + grainName);
        }
    }

    @Override
    public void removeGrain(String grainName) {
        GrainStock stock = getGrainStock();
        Map<String, GrainItem> grains = stock.getGrains();
        if (grains.containsKey(grainName.toLowerCase())) {
            grains.remove(grainName.toLowerCase());
            stock.setGrains(grains);
            grainStockRepository.save(stock);
        } else {
            throw new RuntimeException("Grain not found: " + grainName);
        }
    }
}
