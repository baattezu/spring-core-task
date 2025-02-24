package org.saltaonelove;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.saltaonelove.config.AppConfig;
import org.saltaonelove.facade.GymFacade;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import org.slf4j.Logger;

import java.time.Duration;
import java.time.LocalDate;


public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args){
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            GymFacade gymFacade = context.getBean(GymFacade.class);

            var trainee = gymFacade.registerTrainee("John", "Doe");
            gymFacade.registerTrainee("John", "Doe");
            gymFacade.registerTrainer("John", "Doe");
            gymFacade.registerTrainer("John", "Doe");
            var trainer = gymFacade.registerTrainer("John", "Doe");
            gymFacade.registerTrainee("John", "Doe");

            gymFacade.registerTraining(trainer, trainee, LocalDate.now(),
                    Duration.ofMinutes(50), "HIIT Mike Mentzer Training");

            System.out.println("Registered trainees:");
            gymFacade.showTrainees();
            System.out.println("Registered trainers:");
            gymFacade.showTrainers();


            System.out.println("Registered trainings");
            gymFacade.showTrainings();
        }
    }
}