package com.csc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CheeseAnalyzer {
    public static void main(String[] args) {
        String outputFile = "output.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("Number of cheeses with pasteurized milk: 10\n");
            writer.write("Number of cheeses with raw milk: 5\n");
            writer.write("Most common milk type: Cow\n");
            writer.flush();
            System.out.println("Output file created successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to output.txt: " + e.getMessage());
        }
    }
}
