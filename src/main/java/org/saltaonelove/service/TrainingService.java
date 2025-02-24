package org.saltaonelove.service;

import org.saltaonelove.dao.TrainingDAO;
import org.saltaonelove.dao.TrainingTypeDAO;
import org.saltaonelove.model.Training;
import org.saltaonelove.model.TrainingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {

    @Autowired
    private TrainingDAO trainingDAO;
    @Autowired
    private TrainingTypeDAO trainingTypeDAO;

    public TrainingType addTrainingType(TrainingType trainingType) {
        return trainingTypeDAO.save(trainingType);
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
