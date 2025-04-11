import java.io.*;
import java.util.*;

public class GestionProduits {
    public static void main(String[] args) {
        // Write product data to file
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("produits.txt"));

            // Create some product examples
            Electronique e = new Electronique("0001", 1200);
            Alimentaire a = new Alimentaire("0002", 15, "2025-01-01");
            Cosmetique c = new Cosmetique("0003", 60, "2016 -04-03");

            // Save product to the file
            writer.write("electronique;" + e.numeroSerie + ";" + e.prix);
            writer.newLine();

            writer.write("alimentaire;" + a.numeroSerie + ";" + a.prix + ";" + a.datePeremption);
            writer.newLine();

            writer.write("cosmetique;" + c.numeroSerie + ";" + c.prix + ";" + c.dateFabrication);
            writer.newLine();

            writer.close();
            System.out.println("products saved!");
        } catch (IOException e) {
            // Print error if writing fails
            System.out.println("write error: " + e.getMessage());
        }

        // Read product data from file
        try {
            BufferedReader reader = new BufferedReader(new FileReader("produits.txt"));
            String line;

            // Read each line and print the product
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String type = parts[0];

                switch (type) {
                    case "Electronique":
                        Electronique e = new Electronique(parts[1], Double.parseDouble(parts[2]));
                        System.out.println(e);
                        break;
                    case "Alimentaire":
                        Alimentaire a = new Alimentaire(parts[1], Double.parseDouble(parts[2]), parts[3]);
                        System.out.println(a);
                        break;
                    case "Cosmetique":
                        Cosmetique c = new Cosmetique(parts[1], Double.parseDouble(parts[2]), parts[3]);
                        System.out.println(c);
                        break;
                }
            }

            reader.close();
        } catch (IOException e) {
            // Print error if reading fails
            System.out.println("Read error: " + e.getMessage());
        }
    }
}
