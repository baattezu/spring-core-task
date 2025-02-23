package org.saltaonelove.service;

import org.saltaonelove.dao.TraineeDAO;
import org.saltaonelove.model.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TraineeService {
    private final TraineeDAO traineeDAO;

    @Autowired
    public TraineeService(TraineeDAO traineeDAO) {
        this.traineeDAO = traineeDAO;
    }

    public void registerTrainee(String firstName, String lastName) {
        Trainee trainee = new Trainee(firstName, lastName);
        traineeDAO.save(trainee);
    }

    public void registerTrainee(String firstName, String lastName, LocalDate dateOfBirth, String address) {
        Trainee trainee = new Trainee(firstName, lastName, dateOfBirth, address);
        traineeDAO.save(trainee);
    }

    public List<Trainee> listTrainees() {
        return traineeDAO.findAll();
    }
}

