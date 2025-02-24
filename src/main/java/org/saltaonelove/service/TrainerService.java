package org.saltaonelove.service;

import org.saltaonelove.dao.TrainerDAO;
import org.saltaonelove.dao.UserDAO;
import org.saltaonelove.model.Trainer;
import org.saltaonelove.model.User;
import org.saltaonelove.util.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {

    @Autowired
    private TrainerDAO trainerDAO;

    @Autowired
    private UserDAO userDAO;


    public Trainer registerTrainer(String firstName, String lastName) {
        User user = new User(firstName, lastName);
        user = userDAO.save(user);
        Trainer trainer = UserMapper.userToTrainer(user);
        return trainerDAO.save(trainer);
    }

    public Trainer registerTrainer(String firstName, String lastName, String specialization) {
        User user = new User(firstName, lastName);
        user = userDAO.save(user);
        Trainer trainer = UserMapper.userToTrainer(user);
        trainer.setSpecialization(specialization);
        return trainerDAO.save(trainer);
    }

    public List<Trainer> listTrainers() {
        return trainerDAO.findAll();
    }
}
