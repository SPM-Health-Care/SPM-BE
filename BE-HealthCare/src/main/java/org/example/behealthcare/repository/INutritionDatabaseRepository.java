package org.example.behealthcare.repository;

import org.example.behealthcare.entity.NutritionDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INutritionDatabaseRepository extends JpaRepository<NutritionDatabase, Integer> {
    NutritionDatabase findByFoodName(String foodName);

    void deleteByFoodName(String foodName);

}
