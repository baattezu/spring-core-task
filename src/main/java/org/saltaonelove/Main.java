package org.saltaonelove;


import org.saltaonelove.config.AppConfig;
import org.saltaonelove.facade.GymFacade;
import org.saltaonelove.model.Trainee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.Duration;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            GymFacade gymFacade = context.getBean(GymFacade.class);

            gymFacade.registerTrainee("John", "Doe");
            gymFacade.registerTrainee("Jane", "Doe");

            System.out.println("Registered trainees:");
            gymFacade.showTrainees();
        }
    }
}