package org.saltaonelove.facade;


import org.saltaonelove.model.Trainee;
import org.saltaonelove.model.Trainer;
import org.saltaonelove.model.Training;
import org.saltaonelove.model.TrainingType;
import org.saltaonelove.service.TraineeService;
import org.saltaonelove.service.TrainerService;
import org.saltaonelove.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class GymFacade {
    private final TraineeService traineeService;
    private final TrainerService trainerService;
    private final TrainingService trainingService;

    public GymFacade(TraineeService traineeService, TrainerService trainerService, TrainingService trainingService) {
        this.traineeService = traineeService;
        this.trainerService = trainerService;
        this.trainingService = trainingService;
    }

    public Trainee registerTrainee(String firstName, String lastName) {
        return traineeService.registerTrainee(firstName, lastName);
    }

    public Trainer registerTrainer(String firstName, String lastName) {
        return trainerService.registerTrainer(firstName, lastName);
    }

    public void registerTraining(Trainer trainer, Trainee trainee, LocalDate date, Duration duration, String description, String trainingType) {
        Training training = new Training();
        training.setTraineeId(trainee.getTraineeId());
        training.setTrainerId(trainer.getTrainerId());
        training.setName(description);
        training.setDate(date);
        training.setDuration(duration);
        trainingService.createTraining(training);
    }

    public void showTrainees() {
        traineeService.listTrainees().forEach(t ->
                System.out.println(t.getUsername() + " - " + t.getPassword()));
    }
    public void showTrainers() {
        trainerService.listTrainers().forEach(t ->
                System.out.println(t.getUsername() + " - " + t.getPassword()));
    }

    public void showTrainings() {
        trainingService.listTrainings().forEach(System.out::println);
    }
}
