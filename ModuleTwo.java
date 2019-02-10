//author: Tanaya Jadhav
//Write a program that can take in data from a text file and tally the digits in the nth position of each number
//Useful in finding the 0th digit and seeing if the data follows Benford's Law

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ModuleTwo {

    public static int[] readMysteriousNumbers() {
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
        int[] numeric_list = new int[is_numeric];
        for (int i=non_num, j=0; j<numeric_list.length;i++, j++) {
            numeric_list[j] = Integer.parseInt(lines[i]);
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


    public static int countDigits(int num) {
        int digits = 1;
        if (num < 10) {
            digits = 1;
        }
        else {
            while (num >= 10) {
                num = num / 10;
                digits = digits + 1;
            }
        }

        return digits;
    }


    public static int nthDigitBack(int n, int num) {
        int digit = 0;
        int digits = countDigits(num);
        String number = Integer.toString(num);
        if (n >= digits) {
            return digit;
        } else {
            int position = digits - n - 1;
            digit = Character.getNumericValue(number.charAt(position));
        }
        return digit;
    }


    public static int nthDigit(int n, int num) {
        int digit = 0;
        int digits = countDigits(num);
        String number = Integer.toString(num);
        if (n >= digits) {
            return digit;
        } else {
            digit = Character.getNumericValue(number.charAt(n));
        }
        return digit;
    }


    public static int[] updateTally(int n, int num, int[] tally) {
        int digit = nthDigit(n, num);
        tally[digit] ++;
        return tally;
    }


    public static int[] nthDigitTally(int n, int[] numbers) {
        int[] tally = new int[10];
        for(int x=0; x<numbers.length; x++) {
            int number = numbers[x];
            tally = updateTally(n, number, tally);
        }
        return tally;
    }

    public static void main(String[] args) {


//        int digits = countDigits(1005009);
//        int digit = nthDigit(0, 5679487);
//        System.out.println(digit);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = Integer.parseInt(scanner.nextLine());

        int[] numbers = readMysteriousNumbers();

        int[] tally = nthDigitTally(n, numbers);
        System.out.println("0s: " + tally[0] + "\n" +"1s: " + tally[1] + "\n" +"2s: " + tally[2] + "\n" +
                "3s: " + tally[3] + "\n" +"4s: " + tally[4] + "\n" +"5s: " + tally[5] + "\n" +
                "6s: " + tally[6] + "\n" +"7s: " + tally[7] + "\n" +"8s: " + tally[8] + "\n" +"9s: " + tally[9]);

    }

}

