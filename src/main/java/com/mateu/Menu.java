package com.mateu;

import com.mateu.dao.AssignmentDao;
import com.mateu.dao.Database;
import com.mateu.domain.Assignment;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;


public class Menu {

    private Scanner scanner;
    private Database database;
    private Connection connection;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public void connect() {
        database = new Database();
        connection = database.getConnection();
    }


    public void showMenu() {
        connect();

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
                    add();
                    break;
                case "2":
                    searchAssignment();
                    break;
                case "3":
                    deleteAssignment();
                case "4":
                    modifyAssignment();
                    break;
                case "5":
                    showAssignments();
                    break;
            }
        } while (!Option.equals("6"));
    }

    public void add() {
        System.out.print("Name a new Assigment: ");
        String Name = scanner.nextLine();
        System.out.println("Description:");
        String Description = scanner.nextLine();
        System.out.println("Poscode Location: ");
        String Postcode = scanner.nextLine();
        Assignment assignment = new Assignment(Name.trim(), Description.trim(), Postcode.trim());

        AssignmentDao assignmentDao = new AssignmentDao(connection);
        assignmentDao.add(assignment);
        System.out.println("New Assignment has been added successfully");

    }

    public void searchAssignment() {
        System.out.println("Search By Name: ");
        String Name = scanner.nextLine();

        AssignmentDao assignmentDao = new AssignmentDao(connection);
        Assignment assignment = assignmentDao.findByTitle(Name);

        if (assignment == null) {
            System.out.println("Could not be found");
            return;
        }

        System.out.println(assignment.getName());
        System.out.println(assignment.getDescription());
        System.out.println(assignment.getPostcode());
    }

    public void deleteAssignment() {
        System.out.print("Titulo del libro a eliminar: ");
        String Name = scanner.nextLine();
        AssignmentDao assignmentDao = new AssignmentDao(connection);
        boolean deleted = assignmentDao.delete(Name);
        if (deleted)
            System.out.println("El libro se ha borrado correctamente");
        else
            System.out.println("El libro no se ha podido borrar. No existe");
    }


    public void modifyAssignment() {
        System.out.print("Assignment´s Name to be modified: ");
        String Name = scanner.nextLine();
        // TODO Buscar el libro antes de pedir los nuevos datos
        System.out.print("New Name: ");
        String newName = scanner.nextLine();
        System.out.print("Nuew Description: ");
        String newDescription = scanner.nextLine();
        System.out.print("New Poscode: ");
        String newPostcode = scanner.nextLine();
        Assignment newAssignment = new Assignment(newName.trim(), newDescription.trim(), newPostcode.trim());

        AssignmentDao assignmentDao = new AssignmentDao(connection);
        boolean modified = assignmentDao.modify(Name, newAssignment);
        if (modified)
            System.out.println("El libro se ha modificado correctamente");
        else
            System.out.println("El libro no se ha podido modificar. No existe");
    }


    public void showAssignments() {

        AssignmentDao assignmentDao = new AssignmentDao(connection);
        // TODO Propagar la excepción al menú de usuario
        ArrayList<Assignment> assignments = assignmentDao.findAll();
        for (Assignment assignment : assignments) {
            System.out.println(assignment.getName());
        }

    }

}


