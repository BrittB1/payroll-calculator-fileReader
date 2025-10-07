package com.pluralsight;

// Step 1: Import proper tools

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class PayrollCalculator {
    public static void main(String[] args) {

        // Step 2: try-with opens the file
        try {
            FileReader reader = new FileReader("src/main/resources/employees.csv");
            BufferedReader bufReader = new BufferedReader(reader);

            String headerLine = bufReader.readLine();

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

                System.out.printf("Employee ID: %d%n", employee.getEmployeeId());
                System.out.printf("Name: %s%n", employee.getName());
                System.out.printf("Gross pay: %.2f%n%n", employee.getGrossPay());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
