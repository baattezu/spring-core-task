package org.saltaonelove.service;

import org.saltaonelove.dao.TraineeDAO;
import org.saltaonelove.dao.UserDAO;
import org.saltaonelove.model.Trainee;
import org.saltaonelove.model.Trainer;
import org.saltaonelove.model.User;
import org.saltaonelove.util.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TraineeService {

    @Autowired
    private TraineeDAO traineeDAO;

    @Autowired
    private UserDAO userDAO;

    public Trainee registerTrainee(String firstName, String lastName) {
        User user = new User(firstName, lastName);
        user = userDAO.save(user);
        Trainee trainee = UserMapper.userToTrainee(user);
        return traineeDAO.save(trainee);
    }

    public Trainee registerTrainee(String firstName, String lastName, LocalDate dateOfBirth, String address) {
        User user = new User(firstName, lastName);
        user = userDAO.save(user);
        Trainee trainee = UserMapper.userToTrainee(user);
        trainee.setDateOfBirth(dateOfBirth);
        trainee.setAddress(address);
        return traineeDAO.save(trainee);
    }

    public List<Trainee> listTrainees() {
        return traineeDAO.findAll();
    }
}

