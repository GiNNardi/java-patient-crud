package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Area;
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
            System.out.println("3. Update patient phone");
            System.out.println("4. Remove patient");
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
                LocalDate birthDate = LocalDate.parse(sc.nextLine(), fmt);

                System.out.println("Choose area:");
                for (int i = 0; i < Area.values().length; i++) {
                    System.out.println((i + 1) + " - " + Area.values()[i]);
                }

                System.out.print("Option: ");
                int areaOption = sc.nextInt();
                sc.nextLine();

                Area area = Area.values()[areaOption - 1];

                Patient patient = new Patient(id, name, document, birthDate, area);
                patients.add(patient);

                System.out.println("Patient registered successfully!");
            }


            else if (option == 2) {
                if (patients.isEmpty()) {
                    System.out.println("No patients registered.");
                } else {
                    patients.forEach(System.out::println);
                }
            }


            else if (option == 3) {

                System.out.print("Enter patient ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                Patient patient = patients.stream()
                        .filter(p -> p.getId() == id)
                        .findFirst()
                        .orElse(null);

                if (patient != null) {
                    System.out.print("Enter new phone: ");
                    String phone = sc.nextLine();
                    patient.updatePhone(phone);
                    System.out.println("Phone updated successfully!");
                } else {
                    System.out.println("Patient not found.");
                }
            }


            else if (option == 4) {

                System.out.print("Enter patient ID to remove: ");
                int id = sc.nextInt();
                sc.nextLine();

                Patient patient = patients.stream()
                        .filter(p -> p.getId() == id)
                        .findFirst()
                        .orElse(null);

                if (patient != null) {
                    if (patient.getArea() != Area.CENTER) {
                        patients.remove(patient);
                        System.out.println("Patient removed successfully (outside CENTER).");
                    } else {
                        System.out.println("Cannot remove patient: patient is inside CENTER area.");
                    }
                } else {
                    System.out.println("Patient not found.");
                }
            }

        } while (option != 0);

        sc.close();
        System.out.println("Program finished.");
    }
}
