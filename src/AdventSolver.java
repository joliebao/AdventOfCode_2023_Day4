import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class AdventSolver {
    public static void main(String[] args) {

        // step 1: create a file object
        File f = new File("src/input_file");

        String line1 = ""; // winning lottery numbers
        String line2 = ""; // lottery numbers received
        try {
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String currentLine = s.nextLine();
                System.out.println("OG LINE CODE: " + currentLine);
                line1 += currentLine.substring(currentLine.indexOf(": ") + 2, currentLine.indexOf(" |")) + "\n";
                line2 += currentLine.substring(currentLine.indexOf("| ") + 2) + "\n";
            }

            System.out.println("Winning:\n" + line1);
            System.out.println("lotto:\n" + line2);

            // a String array where every item in the array is a line from the file
            String[] winningArray = line1.split("\n");
            String[] received = line2.split("\n");
            System.out.println(Arrays.toString(winningArray));
            System.out.println(Arrays.toString(received));

            for (String line : fileArray) {
                // split by space, now we have a list of String numbers
                String[] stringNumbers = line.split(" ");

                // create an array of integers
                int[] numbers = new int[stringNumbers.length];

                // convert string numbers into integers
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = Integer.parseInt(stringNumbers[i]);
                    System.out.println(numbers);
                }
            }

//            AdventDay a = new AdventDay()
        }
        catch (FileNotFoundException fe) {
            System.out.println("File was not found");
            System.exit(1);
        }
    }
}