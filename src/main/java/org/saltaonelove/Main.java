package org.saltaonelove;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.saltaonelove.config.AppConfig;
import org.saltaonelove.dto.TrainerDTO;
import org.saltaonelove.facade.GymFacade;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import org.slf4j.Logger;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Scanner;


public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class);
             Scanner scanner = new Scanner(System.in)) {
            GymFacade gymFacade = context.getBean(GymFacade.class);
            CLIHandler cliHandler = new CLIHandler(gymFacade, scanner);
            cliHandler.run();
        }
    }
}