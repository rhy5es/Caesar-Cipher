/*
 a simple program that creates and/or decodes a caesar cipher
*/

import java.util.*;

public class Caesar_Cipher {

    static ArrayList Caesar_Decoder(String string_to_decode, int offset){
        ArrayList<Integer> int_string_list = new ArrayList<Integer>();
        //from string to chars to ArrayList containing ascii values
        for (int i = 0; i < string_to_decode.length(); i++){
            int character = (int) string_to_decode.charAt(i) - offset; //subtract offset automatically
            if (character + offset == 32){ //ensures spaces aren't shifted or skipped
                int_string_list.add(character + offset);
            }
            else if (character < 97){ //if ascii value over 97 ('a'), add 25
                character += 25;
                int_string_list.add(character);
            } else{int_string_list.add(character);}
        }
        return int_string_list;
    }

    static ArrayList Caesar_Encoder(String string_to_encode, int offset){
        ArrayList<Integer> int_string_list = new ArrayList<Integer>();
        //from string to chars to ArrayList containing ascii values
        for (int i = 0; i < string_to_encode.length(); i++){
            int character = (int) string_to_encode.charAt(i) + offset; //add offset automatically
            if (character - offset == 32){ //ensures spaces aren't shifted or skipped
                int_string_list.add(character - offset);
            }
            else if (character > 122){ //if ascii value over 122 ('z'), subtract 25
                character -= 25;
                int_string_list.add(character);
            } else{int_string_list.add(character);}
        }
        return int_string_list;
    }

    public static void main(String[] args) {
        int offset; //the shift number
        String og_string; //string with original user input
        StringBuilder new_string = new StringBuilder(""); //string to be returned to the user
        ArrayList<Integer> og_string_array_num; //ArrayList with the ascii values //no need to instantiate bc Caesar_Encoder and Caesar_Decoder do that
        ArrayList<Character> og_string_array_char = new ArrayList<Character>(); //ArrayList where the chars of the shifted ascii values go
        Scanner scnr = new Scanner(System.in); 

        System.out.println("Would you like to encode or decode a caesar cipher? (Enter 'e' or 'd')"); //Edit to include 'E' or 'D'
        char type = scnr.next().charAt(0);

        if (type == 'e' || type == 'E'){
            System.out.println("Enter the offset for your caesar cipher: ");
            offset = scnr.nextInt();
            scnr.nextLine(); //need this line bc the scanner gets confused and mistakes the newline for a nextLine input
            System.out.println("Enter your word or phrase: ");
            og_string = scnr.nextLine();

            og_string_array_num = Caesar_Encoder(og_string, offset);

            //turns the ascii numbers into chars and adds them to the char ArrayList
            for (int i = 0; i < og_string.length(); i++){ 
                int temp = og_string_array_num.get(i);
                char ch = (char) temp;
                og_string_array_char.add(ch);}
        
            //converting char ArrayList to string
            for (int i = 0; i < og_string.length(); i++){
                new_string.append(og_string_array_char.get(i));}
        
            System.out.println(new_string);
        } 
        else if (type == 'd' || type == 'D'){
            System.out.println("Enter the offset for your caesar cipher: ");
            offset = scnr.nextInt();
            scnr.nextLine(); //need this line bc the scanner gets confused and mistakes the newline for a nextLine input
            System.out.println("Enter your word or phrase: ");
            og_string = scnr.nextLine();

            og_string_array_num = Caesar_Decoder(og_string, offset);

            //turns the ascii numbers into chars and adds them to the char ArrayList
            for (int i = 0; i < og_string.length(); i++){
                int temp = og_string_array_num.get(i);
                char ch = (char) temp;
                og_string_array_char.add(ch);}
        
            //converting char ArrayList to string
            for (int i = 0; i < og_string.length(); i++){
                new_string.append(og_string_array_char.get(i));}
    
            System.out.println(new_string);
        } 
        else {System.out.println("Please enter a valid input.");
        }
        scnr.close();
    }
}
