import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//Welcome! This program can decrypt your messages using a simplified version of the solitaire encryption algorithm
//It needs CircularLinkedList.java to run
//The deck to be used to begin can be changed by changing the "deck" array.
//This program can encrypt messages too!
// However, if you have used it to encrypt a message, it can't decrypt on that run since the deck has changed.
// Rerun the program and this time, comment out the encryption and just decrypt your message.
//It can decrypt multiple messages but beware, the deck changes after every decryption
// and the new message will be decrypted from the deck as it exists after the previous decryption.
//author: Tanaya Jadhav


public class SolitaireAssignment {

    public static int getKeystreamVal(CircularLinkedList deck){
        deck.swapWithNext(deck.getIndex(27));
        deck.insert2Downstream(deck.getIndex(28));
        deck.tripleCut(deck.getIndex(27), deck.getIndex(28));
        deck.bottomCut();
        int val = deck.finalItem();
        return val;
    }

    public static List<Integer> stringToIntegers(String message){
        String[] arr = message.split("\\s+");
        List<String> word_list = new ArrayList<>();
        for (String word : arr) {
            String newWord = word.replaceAll("\\p{Punct}","");
            word_list.add(newWord);
        }
        String joined = String.join("",word_list).toUpperCase();
//        System.out.println(joined);
        char[] char_arr = joined.toCharArray();
        List<Integer> int_list = new ArrayList<>();
        for (char c: char_arr){
            int position = c - 'A' + 1;
            int_list.add(position);
        }
        if (int_list.size()%5 != 0) {
            int padding = 5 - (int_list.size() % 5);
            for (int i = 0; i < padding; i++) {
                int_list.add(24);
            }
        }
        return int_list;
    }

    public static String intsToString(List<Integer> val_list){
        List<String> encrypted_message = new ArrayList<>();
        for (int val: val_list){
            int pos = 'A' + val -1;
            encrypted_message.add(Character.toString((char)pos));
        }
        String mess = String.join("",encrypted_message);
        return mess;
    }

    public static void encryptMessage(String message, CircularLinkedList deck){
        List<Integer> int_list = stringToIntegers(message);
//        System.out.println(int_list);
        List<Integer> keystream_list = new ArrayList<>();
        for (int i = 0; i < int_list.size(); i++) {
            keystream_list.add(getKeystreamVal(deck));
        }
//        System.out.println(keystream_list);
        List<Integer> encryption_vals = new ArrayList<>();
        for (int i = 0; i < int_list.size(); i++) {
            int val = int_list.get(i) + keystream_list.get(i);
//            System.out.println(val);
            if (val > 26) {
                val = val - 26;
            }
            encryption_vals.add(val);
        }
//        System.out.println(encryption_vals);

        //get the final encryted message
        String mess = intsToString(encryption_vals);
        System.out.println(mess);
    }

    public static CircularLinkedList decryptMessage(String to_decrypt, CircularLinkedList deck){
        //decrypting
        List<Integer> int_list = stringToIntegers(to_decrypt);
        List<Integer> keystream_list = new ArrayList<>();
        for (int i = 0; i < int_list.size(); i++) {
            keystream_list.add(getKeystreamVal(deck));
        }
        CircularLinkedList deck_after = deck;
        List<Integer> decryption_vals = new ArrayList<>();
        for (int i = 0; i < int_list.size(); i++) {
            int val = 0;
            if (int_list.get(i) < keystream_list.get(i)){
                val = int_list.get(i) + 26 - keystream_list.get(i);
            }
            else {
                val = int_list.get(i) - keystream_list.get(i);
            }
//            System.out.println(val);
            decryption_vals.add(val);
        }

        String decrypted_mess = intsToString(decryption_vals);
        System.out.println(decrypted_mess);
        return deck;
    }

    public static boolean more_messages(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to decrypt a message? type y for yes and n for no:");
        String response = scanner.nextLine();
        if (response.equals("y")){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //Change this array if you want to change the state of the deck
        int[] deckArray = {1, 4, 13, 10, 7, 16, 19, 22, 25, 28, 3, 6, 9, 12, 15, 18, 21,
        24, 23, 2, 5, 8, 11, 14, 17, 20, 27, 26};
        CircularLinkedList deck = new CircularLinkedList();
        for (Integer i: deckArray) {
            deck.add(i);
        }
//        System.out.println(deck);

//Change this if you want to encrypt a message.
//        String message = "Thank you, next";
//        encryptMessage(message, deck);

        while (more_messages()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please type the message you would like to decrypt." + "\n" +
                    "Use all uppercase letters and no spaces");
            String input_message = scanner.nextLine();

            //decrypts message and returns a deck as it is after decryption
            deck = decryptMessage(input_message, deck);
        }



    }

}
