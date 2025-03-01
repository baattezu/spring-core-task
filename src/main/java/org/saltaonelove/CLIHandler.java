package org.saltaonelove;

import org.saltaonelove.dto.TraineeDTO;
import org.saltaonelove.dto.TrainerDTO;
import org.saltaonelove.facade.GymFacade;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CLIHandler {
    private final GymFacade gymFacade;
    private final Scanner scanner;

    public CLIHandler(GymFacade gymFacade, Scanner scanner) {
        this.gymFacade = gymFacade;
        this.scanner = scanner;
    }

    public void run() {
        while (true) {
            showMenu();
            int choice = getChoice();
            if (!processChoice(choice)) {
                break;
            }
        }
    }

    private void showMenu() {
        System.out.println("\nChoose an option:");
        System.out.println("1. Register Trainee");
        System.out.println("2. Register Trainer");
        System.out.println("3. Register Training");
        System.out.println("4. Show Trainees");
        System.out.println("5. Show Trainers");
        System.out.println("6. Show Trainings");
        System.out.println("7. Update Trainee");
        System.out.println("8. Update Trainer");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return choice;
    }

    private boolean processChoice(int choice) {
        switch (choice) {
            case 1 -> registerTrainee();
            case 2 -> registerTrainer();
            case 3 -> registerTraining();
            case 4 -> gymFacade.showTrainees();
            case 5 -> gymFacade.showTrainers();
            case 6 -> gymFacade.showTrainings();
            case 7 -> updateTrainer();
            case 8 -> updateTrainer();
            case 9 -> {
                System.out.println("Exiting program...");
                return false;
            }
            default -> System.out.println("Invalid choice. Please try again.");
        }
        return true;
    }

    private void registerTrainee() {
        System.out.print("Enter first name: ");
        String name = scanner.nextLine();
        System.out.print("Enter last name: ");
        String surname = scanner.nextLine();
        gymFacade.registerTrainee(name, surname);
        System.out.println("Trainee registered!");
    }

    private void registerTrainer() {
        System.out.print("Enter first name: ");
        String name = scanner.nextLine();
        System.out.print("Enter last name: ");
        String surname = scanner.nextLine();
        gymFacade.registerTrainer(name, surname);
        System.out.println("Trainer registered!");
    }

    private void registerTraining() {
        System.out.print("Enter Trainer ID: ");
        long trainerId = scanner.nextLong();
        System.out.print("Enter Trainee ID: ");
        long traineeId = scanner.nextLong();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter training name: ");
        String trainingName = scanner.nextLine();
        System.out.print("Enter training category: ");
        String category = scanner.nextLine();
        gymFacade.registerTraining(trainerId, traineeId, LocalDate.now(), Duration.ofMinutes(50), trainingName, category);
        System.out.println("Training registered!");
    }

    private void updateTrainer() {
        System.out.print("Enter Trainer ID: ");
        long updateId = scanner.nextLong();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new first name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new last name: ");
        String newSurname = scanner.nextLine();
        System.out.print("Enter new specialization: ");
        String newSpecialization = scanner.nextLine();
        gymFacade.updateTrainer(updateId, new TrainerDTO(newName, newSurname, newSpecialization));
        System.out.println("Trainer updated!");
    }

    private void updateTrainee() {
        System.out.print("Enter Trainee ID: ");
        long updateId = scanner.nextLong();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new first name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new last name: ");
        String newSurname = scanner.nextLine();
        System.out.print("Enter new birthday: (yyyy-MM-dd)");
        String newBirthday = scanner.nextLine();
        System.out.print("Enter new address: ");
        String newAddress = scanner.nextLine();
        gymFacade.updateTrainee(updateId, new TraineeDTO(newName, newSurname, newBirthday, newAddress));
        System.out.println("Trainee updated!");
    }
}