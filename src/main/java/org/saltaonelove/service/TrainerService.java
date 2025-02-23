package org.saltaonelove.service;

import org.saltaonelove.dao.TrainerDAO;
import org.saltaonelove.model.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {
    private final TrainerDAO trainerDAO;

    @Autowired
    public TrainerService(TrainerDAO trainerDAO) {
        this.trainerDAO = trainerDAO;
    }

    public void registerTrainer(String firstName, String lastName) {
        Trainer trainer = new Trainer(firstName, lastName);
        trainerDAO.save(trainer);
    }

    public void registerTrainer(String firstName, String lastName, String specialization) {
        Trainer trainer = new Trainer(firstName, lastName, specialization);
        trainerDAO.save(trainer);
    }

    public List<Trainer> listTrainers() {
        return trainerDAO.findAll();
    }
}
