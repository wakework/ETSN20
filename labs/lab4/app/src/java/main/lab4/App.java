package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class App {
        public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java SearchApp <pattern> <file>. Please try again.");
            return;
        }

        String pattern = args[1];
        String filePath = args[2];

        try (Scanner scanner = new Scanner(SearchApp.class.getClassLoader().getResource(filePath).toURI())) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.contains(" " + pattern + " ")) {
                    System.out.println(line);
                    System.out.println();
                }
            }
        } catch (FileNotFoundException | URISyntaxException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
