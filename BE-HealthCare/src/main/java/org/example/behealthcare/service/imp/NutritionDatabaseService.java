package org.example.behealthcare.service.imp;

import org.example.behealthcare.entity.NutritionDatabase;
import org.example.behealthcare.repository.NutritionDatabaseRepository;
import org.example.behealthcare.service.INutritionDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NutritionDatabaseService implements INutritionDatabaseService {
    @Autowired
    private NutritionDatabaseRepository nutritionDatabaseRepository;
    @Override
    public NutritionDatabase findByFoodName(String foodName) {
        return nutritionDatabaseRepository.findByFoodName(foodName);
    }

    @Override
    public NutritionDatabase save(NutritionDatabase nutritionDatabase) {
        return nutritionDatabaseRepository.save(nutritionDatabase);
    }

    @Override
    public void deleteByFoodName(String foodName) {
        nutritionDatabaseRepository.deleteByFoodName(foodName);
    }
}
