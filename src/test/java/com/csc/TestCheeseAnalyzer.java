package com.csc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class TestCheeseAnalyzer {

    @Test
    void testOutputFileExists() {
        CheeseAnalyzer.main(new String[]{});
        File outputFile = new File("output.txt");
        assertTrue(outputFile.exists(), "Output file should exist after running the program.");
    }
    @Test
    void testOutputFileNotEmpty() throws IOException {
        CheeseAnalyzer.main(new String[]{});
        File outputFile = new File("output.txt");
        assertTrue(outputFile.length() > 0, "Output file should not be empty.");
    }

    @Test
    void testMostCommonMilkType() throws IOException {
        String testData = "ID,MilkTreatmentTypeEn,Organic,MoisturePercent,MilkTypeEn\n"
                        + "200, Pasteurized, 1, 45.0, Cow\n"
                        + "201, Raw, 0, 38.5, Goat\n"
                        + "202, Pasteurized, 1, 42.0, Cow\n"
                        + "203, Pasteurized, 0, 39.0, Cow\n";
                File testFile = new File("test_cheese_dataset.csv");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFile))) {
            writer.write(testData);
        }
        CheeseAnalyzer.main(new String[]{});
        BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
        String line;
        boolean found = false;
        while ((line = reader.readLine()) != null) {
            if (line.contains("Most common milk type: Cow")) {
                found = true;
                break;
            }
        }
        reader.close();
        assertTrue(found, "The most common milk type should be Cow.");
    }
}
