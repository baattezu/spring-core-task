package org.saltaonelove.service;

import org.saltaonelove.dao.TrainingDAO;
import org.saltaonelove.model.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {

    private final TrainingDAO trainingDAO;

    @Autowired
    public TrainingService(TrainingDAO trainingDAO) {
        this.trainingDAO = trainingDAO;
    }

    public Training createTraining(Training training) {
        return trainingDAO.save(training);
    }

    public List<Training> listTrainings() {
        return trainingDAO.findAll();
    }

    public Training getTraining(Long id) {
        return trainingDAO.get(id);
    }
}
