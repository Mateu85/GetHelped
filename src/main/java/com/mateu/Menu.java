package com.mateu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private List<Assigment> catalogAssigments;

    public Menu() {
        scanner = new Scanner(System.in);
        catalogAssigments = new ArrayList<>();
    }


    public void showMenu() {
        fillUpCatalog();
        String Option = null;

        do {
            System.out.println("Handy Person around your area..!!!");
            System.out.println("1. Add");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Modify");
            System.out.println("5. LookUp the whole List os assignments");
            System.out.println("6. Exit");
            System.out.print("Option: ");
            Option = scanner.nextLine();

            switch (Option) {
                case "1":
                    addAssignment();
                    break;
                case "2":
                    searchAssigments();
                    break;
                case "3":
                    DeleteAssigments();
                case "4":
                    modifyAssignment();
                    break;
                case "5":
                    finfAll();
                    break;
            }
        } while (!Option.equals("6"));
    }

    public void addAssignment() {
        System.out.print("Name a new Assigment: ");
        String Name = scanner.nextLine();
        System.out.println("Description:");
        String Description = scanner.nextLine();
        System.out.println("Poscode Location: ");
        String Postcode = scanner.nextLine();
        Assigment assigment = new Assigment(Name.trim(), Description.trim(), Postcode.trim());
        catalogAssigments.add(assigment);

    }

    public void searchAssigments() {
        boolean found = false;
        System.out.println("Search By Title: ");
        String Name = scanner.nextLine();
        for (Assigment assigment : catalogAssigments) {
            if (assigment.getName().equals(Name)) {
                System.out.println("Data found: ");
                System.out.println(assigment.getName());
                System.out.println(assigment.getDescription());
                System.out.println(assigment.getPostcode());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Could not be found");
        } else {
            System.out.println("This is the result:");
        }
    }

    public void DeleteAssigments() {
        System.out.println("Type the assigment to be deleted: ");
        String Name = scanner.nextLine();
        boolean eliminado = catalogAssigments.removeIf(libro -> libro.getName().equals(Name));
        if (eliminado)
            System.out.println("The assignment has been Deleted properly");
        else
            System.out.println("The assignment could no be deleted as does not exist");
    }



    public void modifyAssignment() {
        boolean modifyed = false;
        System.out.print("Name of the Assignment to be modified : ");
        String Name = scanner.nextLine();
        for (Assigment assigment : catalogAssigments) {
            if (assigment.getName().equalsIgnoreCase(Name)) {
                System.out.print("New Name ");
                String nuevoTitulo = scanner.nextLine();
                System.out.print("New Description: ");
                String nuevoAutor = scanner.nextLine();
                System.out.print("New Postcode: ");
                String nuevaEditorial = scanner.nextLine();
                assigment.setName(nuevoTitulo);
                assigment.setDescription(nuevoAutor);
                assigment.setPostcode(nuevaEditorial);
                System.out.println("Assignment Modified Properly!");
                modifyed = true;
            }
        }
        if (!modifyed)
            System.out.println("Assignment could no be found!");
    }

    public void finfAll() {
        for (Assigment assigment : catalogAssigments) {
            System.out.println(assigment.getName());
            System.out.println(assigment.getDescription());
            System.out.println(assigment.getPostcode());
        }
    }

    public void fillUpCatalog() {
        catalogAssigments.add(new Assigment("Assigment 1", "TEST", "www www"));
        catalogAssigments.add(new Assigment("Assigment 2", "TEST", "QQQ QQQ"));
        catalogAssigments.add(new Assigment("Assigment 3", "TEST", "RRR RRR"));
        catalogAssigments.add(new Assigment("Assigment 4", "TEST", "GGG GGG"));
        catalogAssigments.add(new Assigment("Assigment 5", "TEST", "BBB BBB"));
    }

}


