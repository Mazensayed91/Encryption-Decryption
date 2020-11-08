/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decrypt;

/**
 *
 * @author Lenovo
 */
import java.util.HashMap; 
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Decrypt {

    
    public static void main(String[] args) {
        
        DataManipulation x = new DataManipulation(args);
        x.parseArgs();
        String data = "";
        int key = x.getKey();
        if(x.file_or_str())
        {
            data = x.readData();
        }
        else if (x.file_or_str() == false)
        {
            data = x.getData();
        }
       
        if(x.isEnc())
        {
         
        Encryption y = new Encryption(data,key);

        String encrypted_data = y.shiftAll().toString();
        
        if(x.toFile())
        {
            x.writeData(encrypted_data);
        }
        else if(x.toFile() == false)
        {
            System.out.println(encrypted_data);
        }
        }
        else
        {
        Decryption z= new Decryption(data,key);

        String decrypted_data = z.shiftAll().toString();
        
        if(x.toFile())
        {
            x.writeData(decrypted_data);
        }
        else if(x.toFile() == false)
        {
            System.out.println(decrypted_data);
        }    
        }
    }

}
