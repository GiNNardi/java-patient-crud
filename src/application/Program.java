package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Patient;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Patient> patients = new ArrayList<>();

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        int option;

        do {
            System.out.println("\n--- *PATIENT CRUD* ---");
            System.out.println("1. Register patient");
            System.out.println("2. List patients");
            System.out.println("0. Exit");
            System.out.print("Option: ");
            option = sc.nextInt();
            sc.nextLine();

            if (option == 1) {

                System.out.print("ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("CPF or CNS: ");
                String document = sc.nextLine();

                System.out.print("Birth date (dd/MM/yyyy): ");
                String dateStr = sc.nextLine();
                LocalDate birthDate = LocalDate.parse(dateStr, fmt);

                Patient patient = new Patient(id, name, document, birthDate);
                patients.add(patient);

                System.out.println("Patient registered successfully!");

            } else if (option == 2) {

                System.out.println("\n--- PATIENT LIST ---");

                if (patients.isEmpty()) {
                    System.out.println("No patients registered.");
                } else {
                    for (Patient p : patients) {
                        System.out.println(p);
                    }
                }
            }

        } while (option != 0);

        sc.close();
    }
}
