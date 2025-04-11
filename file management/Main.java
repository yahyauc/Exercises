
// imoprt the bibilio that give us to read or write on any file
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {



            // Open the input file to read
            BufferedReader r = new BufferedReader(new FileReader("input.txt"));



            // Open the output file to write
            BufferedWriter w = new BufferedWriter(new FileWriter("output.txt"));


            String line;

            // Read any line from the input file
            while ((line = r.readLine()) != null) {

                // convert the line to uppercase(majis)
                String upperLine = line.toUpperCase();

                // Write the converted line to the output file
                w.write(upperLine);

                // move to the next line
                w.newLine();

                // validate changes on the file
                w.flush();
            }
            w.close();
            r.close();
            
            System.out.println(" conversion done!");
        } catch (IOException e) {
            // if we have any prob print this message
            System.out.println(" error: " + e.getMessage());
        }
    }
}
