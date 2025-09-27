package org.example.behealthcare.service.imp;

import org.example.behealthcare.dto.HealthMetricDTO;
import org.example.behealthcare.entity.HealthMetric;
import org.example.behealthcare.exception.AppException;
import org.example.behealthcare.exception.ErrorCode;
import org.example.behealthcare.repository.IHealthMetricRepository;
import org.example.behealthcare.service.IHealthMetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class HealthMetricService implements IHealthMetricService {
    @Autowired
    private IHealthMetricRepository IHealthMetricRepository;

    @Override
    public HealthMetric findByMetricId(Integer metricId) {
        return IHealthMetricRepository.findByMetricId(metricId);
    }

    @Override
    public void deleteByMetricId(Integer metricId) {
        IHealthMetricRepository.deleteByMetricId(metricId);
    }

    @Override
    public void deleteByRecordedAt(LocalDate recordedAt) {
        IHealthMetricRepository.deleteByRecordedAt(recordedAt);
    }

    @Override
    public List<HealthMetricDTO> findByUser_UserId(Integer userId) {
        return IHealthMetricRepository.findByUser_UserId(userId);
    }

    @Override
    public HealthMetric save(HealthMetric healthMetric) {
        return IHealthMetricRepository.save(healthMetric);
    }

    @Override
    public HealthMetric update(Integer userId, LocalDate recordedAt, HealthMetricDTO dto) {
        HealthMetric metric = IHealthMetricRepository.findByUserIdAndDate(userId, recordedAt)
                .orElseThrow(() -> new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION));
        if(dto.getHeartRate() != null) metric.setHeartRate(dto.getHeartRate());
        if(dto.getBloodPressure() != null) metric.setBloodPressure(dto.getBloodPressure());
        return IHealthMetricRepository.save(metric);
    }
}
