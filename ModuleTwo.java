import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ModuleTwo {

    public static String[] readMysteriousNumbers() {
        File target = new File("Instagram_Data.txt");
        String[] lines = new String[0];
        try {
            Scanner scanner = new Scanner(target);
            int num_lines = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                num_lines ++;

            }
            lines = new String[num_lines];
            scanner = new Scanner(target);
            int i = 0;
            while (scanner.hasNextLine()){
                lines[i] = scanner.nextLine();
                i++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int non_num = 0;
        for (int i=0; i < lines.length; i++ ) {
            if (isNotInteger(lines[i])) {
                non_num++;
            }
        }
        int is_numeric = lines.length - non_num;
        String[] numeric_list = new String[is_numeric];
        for (int i=non_num, j=0; j<numeric_list.length;i++, j++) {
            numeric_list[j] = lines[i];
        }

        return numeric_list;
    }


    public static boolean isNotInteger(String line) {
        try {
            int i = Integer.parseInt(line);
//            double d = Double.parseDouble(line);
        } catch (NumberFormatException | NullPointerException nfe) {
            return true;
        }
        return false;
    }



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = Integer.parseInt(scanner.nextLine());

        String[] numbers = readMysteriousNumbers();

        int[] tally = new int[10];

        for(int x=0; x<numbers.length; x++) {
            String number = numbers[x];
            if(n>=number.length()) {
            }
            else {
                int numberat = Character.getNumericValue(number.charAt(n));
                tally[numberat] ++;

            }

        }
        System.out.println("0s: " + tally[0] + "\n" +"1s: " + tally[1] + "\n" +"2s: " + tally[2] + "\n" +
                "3s: " + tally[3] + "\n" +"4s: " + tally[4] + "\n" +"5s: " + tally[5] + "\n" +
                "6s: " + tally[6] + "\n" +"7s: " + tally[7] + "\n" +"8s: " + tally[8] + "\n" +"9s: " + tally[9]);

    }

}

