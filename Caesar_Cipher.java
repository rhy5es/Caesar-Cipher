/*
 a simple program that creates and/or decodes a caesar cipher
 */

import java.util.*;

public class Caesar_Cipher {
    
    static ArrayList Caesar_Decoder(String string_to_decode, int offset){
        ArrayList<Integer> int_string_list = new ArrayList<Integer>();

        for (int i = 0; i < string_to_decode.length(); i++){
            int character = (int) string_to_decode.charAt(i) - offset;
            if (character < 97){
                character += 25;
                int_string_list.add(character);
            } else{int_string_list.add(character);}
        }
        return int_string_list;
    }

    static ArrayList Caesar_Encoder(String string_to_encode, int offset){
        ArrayList<Integer> int_string_list = new ArrayList<Integer>();

        for (int i = 0; i < string_to_encode.length(); i++){
            int character = (int) string_to_encode.charAt(i) + offset;
            if (character > 122){
                character -= 25;
                int_string_list.add(character);
            } else{int_string_list.add(character);}
        }
        return int_string_list;
    }

    public static void main(String[] args) {
        int offset;
        String og_string;
        StringBuilder new_string = new StringBuilder("");
        ArrayList<Integer> og_string_array_num;
        ArrayList<Character> og_string_array_char = new ArrayList<Character>();
        Scanner scnr = new Scanner(System.in);

        System.out.println("Would you like to encode or decode a caesar cipher? (Enter 'e' or 'd')");
        char type = scnr.next().charAt(0);
        System.out.println("Enter the offset for your caesar cipher: ");
        offset = scnr.nextInt();
        scnr.nextLine();
        System.out.println("Enter your word or phrase: ");
        og_string = scnr.nextLine();

        if (type == 'e'){
                og_string_array_num = Caesar_Encoder(og_string, offset);
                for (int i = 0; i < og_string.length(); i++){
                    int temp = og_string_array_num.get(i);
                    char ch = (char) temp;
                    og_string_array_char.add(ch);}
        
                //converting char ArrayList to string
                for (int i = 0; i < og_string.length(); i++){
                    new_string.append(og_string_array_char.get(i));}
        
                System.out.println(new_string);
        } 
        else if (type == 'd'){
                og_string_array_num = Caesar_Decoder(og_string, offset);
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