package org.example.behealthcare.service.imp;

import org.example.behealthcare.entity.NutritionDatabase;
import org.example.behealthcare.repository.INutritionDatabaseRepository;
import org.example.behealthcare.service.INutritionDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NutritionDatabaseService implements INutritionDatabaseService {
    @Autowired
    private INutritionDatabaseRepository INutritionDatabaseRepository;
    @Override
    public NutritionDatabase findByFoodName(String foodName) {
        return INutritionDatabaseRepository.findByFoodName(foodName);
    }

    @Override
    public NutritionDatabase save(NutritionDatabase nutritionDatabase) {
        return INutritionDatabaseRepository.save(nutritionDatabase);
    }

    @Override
    public void deleteByFoodName(String foodName) {
        INutritionDatabaseRepository.deleteByFoodName(foodName);
    }
}
