package org.example.behealthcare.service;

import org.example.behealthcare.entity.NutritionDatabase;

public interface INutritionDatabaseService {
    NutritionDatabase findByFoodName(String foodName);

    NutritionDatabase save(NutritionDatabase nutritionDatabase);

    void deleteByFoodName(String foodName);
}
