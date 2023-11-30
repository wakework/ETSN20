package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class App {
        public static void main(String[] args) {
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < args.length - 1; i++) {
            sb.append(args[i]);
            sb.append(" ");
        }

        try (Scanner scanner = new Scanner(SearchApp.class.getClassLoader().getResource(args[args.length - 1]).toURI())) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.contains(" " + sb.toString() + " ")) {
                    System.out.println(line);
                    System.out.println();
                }
            }
        } catch (FileNotFoundException | URISyntaxException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
