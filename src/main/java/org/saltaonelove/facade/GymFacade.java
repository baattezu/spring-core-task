package org.saltaonelove.facade;


import org.saltaonelove.service.TraineeService;
import org.saltaonelove.service.TrainerService;
import org.saltaonelove.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public void registerTrainee(String firstName, String lastName) {
        traineeService.registerTrainee(firstName, lastName);
    }

    public void showTrainees() {
        traineeService.listTrainees().forEach(t ->
                System.out.println(t.getUsername() + " - " + t.getPassword()));
    }
}
