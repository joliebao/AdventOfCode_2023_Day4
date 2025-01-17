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
                line1 += currentLine.substring(currentLine.indexOf(": ") + 2, currentLine.indexOf(" |")) + "\n";
                line2 += currentLine.substring(currentLine.indexOf("| ") + 2) + "\n";
            }

            String[] array1 = line1.split("\n");
            String[] array2 = line2.split("\n");

            for (String line : array1) {
                // split by space, now we have a list of String numbers
                String[] stringNumbers1 = line.split(" ");

                // create an array of integers
                int[] winningLottery = new int[array1.length];

                // convert string numbers into integers
                for (int i = 0; i < winningLottery.length; i++) {
                    winningLottery[i] = Integer.parseInt(stringNumbers1[i]);
                }

                String[] stringNumbers2 = line.split(" ");

                int[] lotteryNumbers = new int[array2.length];

                // convert string numbers into integers
                for (int i = 0; i < lotteryNumbers.length; i++) {
                    lotteryNumbers[i] = Integer.parseInt(stringNumbers2[i]);
                }

                AdventDay a = new AdventDay(winningLottery, lotteryNumbers);
                System.out.println(a.pointWorth());
            }

        }
        catch (FileNotFoundException fe) {
            System.out.println("File was not found");
            System.exit(1);
        }
    }
}