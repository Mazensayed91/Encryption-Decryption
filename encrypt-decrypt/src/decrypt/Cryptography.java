/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decrypt;
import java.util.HashMap; 
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 *
 * @author Lenovo
 */
public class Cryptography {
    final static String ALPHABET = "abcdefghigklmnopqrstuvwxyz";
    final static String REV_ALPHABET = "zyxwvutsrqponmlkgihgfedcba"; 
    private HashMap<String, String> cmd_args = new HashMap<>();
    private String mode = "enc";
    private String path_inp  = "";
    private String path_out = "";
    private int key = 0;
    private String data = "";
    private StringBuilder raw_string = new StringBuilder();
    public Cryptography(){}
    public Cryptography(StringBuilder user_string)
    {
        this.raw_string = user_string;
    }
    public void writeFile(String data)
    {
        try {
        File file = new File(path_out);
        FileWriter writer = new FileWriter(file); // appends text to the file
        writer.write(data);
        writer.close();
        }catch(IOException e)
        {
            System.out.println("The error is : " + e.getMessage());
        }
    }
    public String readFile()
    {
        File file = new File(path_inp);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                data = scanner.nextLine() ;
                }
        } catch (Exception e) {
            System.out.println("No file found: " );
            }
        return data;
    }
    public void extractCmdParams(String[] args)
    {
        for(int i =0; i <args.length;i++)
        {
            if(args[i].equals("-mode"))
            {
                mode = args[i+1];
            }
            else if(args[i].equals("-data"))
            {
                this.data = args[i+1];
            }
            else if(args[i].equals("-key"))
            {
                this.key = Integer.parseInt(args[i+1]);
            }
            else if(args[i].equals("-in"))
            {
                this.path_inp = args[i+1];
            }
            else if(args[i].equals("-out"))
            {
                this.path_out = args[i+1];
            }
        }
    }
    public StringBuilder replaceLetters()
    {
        StringBuilder encrypted = new StringBuilder();
        HashMap<Character, Character> alphatoNumbers = new HashMap<Character, Character>();
        for(int i =0 ; i < REV_ALPHABET.length();i++)   
        {
         alphatoNumbers.put(ALPHABET.charAt(i),REV_ALPHABET.charAt(i));   
        }
        String flag="";
        for(int i = 0 ; i <raw_string.length();i++)
        {
         if(Character.isLetter(raw_string.charAt(i)))
         {
            flag = (raw_string.substring(i,i+1)).replace(raw_string.charAt(i),alphatoNumbers.get(raw_string.charAt(i)));
            encrypted.append(flag);
         }
         else
         {
             encrypted.append(raw_string.charAt(i));
         }
        }
        return encrypted;
    }
    public StringBuilder caesar(int key)
    {
        StringBuilder encrypted = new StringBuilder();

        for(int i = 0 ; i <data.length();i++)
        {
         if(Character.isLetter(data.charAt(i)))
         {
            char shifted = (char)((int)data.charAt(i)+key);
            if(Character.isLetter(shifted))
                encrypted.append(shifted);
            else
            {
             shifted = (char)((int)data.charAt(i)+key-26); 
             encrypted.append(shifted);

            }
         }
         else
         {
             encrypted.append(data.charAt(i));
         }
        }
        return encrypted;
    }
    public StringBuilder decryptCaesar(int key)
    {
        StringBuilder decrypted = new StringBuilder();
        
        for(int i = 0 ; i <raw_string.length();i++)
        {
         if(Character.isLetter(raw_string.charAt(i)))
         {
            char shifted = (char)((int)raw_string.charAt(i)-key);
            if(Character.isLetter(shifted))
                decrypted.append(shifted);
            else
            {
             shifted = (char)((int)raw_string.charAt(i)-key+26); 
             decrypted.append(shifted);

            }
         }
         else
         {
             decrypted.append(raw_string.charAt(i));
         }
        }
        return decrypted;
    }
}
    

