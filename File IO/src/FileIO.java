import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
    public static void main(String[] args) {
        String inputFileName = "input_file.txt";
        String outputFileName = "output_file.txt";

        try {
            FileReader fileReader = new FileReader(inputFileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(outputFileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line); // writing as it is read while checking
                bufferedWriter.newLine();
            }

            bufferedReader.close();
            bufferedWriter.close();

            System.out.println("Data copied from " + inputFileName + " to " + outputFileName);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
