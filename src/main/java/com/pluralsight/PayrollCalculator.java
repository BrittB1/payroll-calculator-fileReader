package com.pluralsight;

// Step 1: Import proper tools

import java.io.*;
import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the name of the file to be processed: ");
        String inputFileName = keyboard.nextLine();

        System.out.println("Enter the name of the payroll file to create: ");
        String outputFileName = keyboard.nextLine();

        // Step 2: try-with opens the file
        try (
                FileReader reader = new FileReader("src/" + inputFileName);
                BufferedReader bufReader = new BufferedReader(reader);
                FileWriter writer = new FileWriter("src/" + outputFileName);
                BufferedWriter bufWriter = new BufferedWriter(writer)) {

            String headerLine = bufReader.readLine();

            bufWriter.write("ID | Name | Gross pay");
            bufWriter.newLine();

            String input;
            while ((input = bufReader.readLine()) != null) {

                // Part 3: Split the line being read inside the loop
                String[] tokens = input.split("\\|");

                // Part 5: Convert the data while its in the loop
                int id = Integer.parseInt(tokens[0]);
                String empName = tokens[1];
                double hours = Double.parseDouble(tokens[2]);
                double pay = Double.parseDouble(tokens[3]);

                // Part 6: Create the employee object in the loop also
                Employee employee = new Employee(id, empName, hours, pay);

                String outputLine = employee.getEmployeeId() + "|" + employee.getName() + "|" + String.format("%.2f", employee.getGrossPay());
                bufWriter.write(outputLine);
                bufWriter.newLine();

                // System.out.printf("Employee ID: %d%n", employee.getEmployeeId());
                // System.out.printf("Name: %s%n", employee.getName());
                // System.out.printf("Gross pay: $%.2f%n%n", employee.getGrossPay());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Payroll File Creation Successful ✅ ");
    }
}
