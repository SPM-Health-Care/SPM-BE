package org.example.behealthcare.controller;

import jakarta.validation.Valid;
import org.example.behealthcare.dto.HealthMetricCreateDTO;
import org.example.behealthcare.dto.HealthMetricDTO;
import org.example.behealthcare.entity.HealthMetric;
import org.example.behealthcare.service.IHealthMetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class HealthMetricController {
    @Autowired
    private IHealthMetricService healthMetricService;


    @GetMapping("/healthmetrics/{userId}")
    public ResponseEntity<List<HealthMetricDTO>> showHealthMetricsByUserId(@PathVariable Integer userId) {
        List<HealthMetricDTO> healthMetrics = healthMetricService.findByUser_UserId(userId);
        System.out.println(healthMetrics);
        if (!healthMetrics.isEmpty()) {
            return ResponseEntity.ok(healthMetrics);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/metrics/{userId}/{recordedAt}")
    public ResponseEntity<HealthMetricDTO> updateMetric(
            @PathVariable Integer userId,
            @PathVariable LocalDate recordedAt,
            @RequestBody HealthMetricDTO dto) {

        HealthMetric updated = healthMetricService.update(userId, recordedAt, dto);
        if (updated != null) {
            return ResponseEntity.ok(new HealthMetricDTO(updated));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/metrics-create")
    public ResponseEntity<HealthMetric> create(@Valid @RequestBody HealthMetricCreateDTO dto) {
        return ResponseEntity.ok(healthMetricService.create(dto));
    }
}
