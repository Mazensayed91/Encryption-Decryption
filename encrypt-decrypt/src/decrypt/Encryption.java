/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decrypt;

import java.util.HashMap;

/**
 *
 * @author Lenovo
 */
public class Encryption {
    private String data;
    private String method;
    final static String ALPHABET = "abcdefghigklmnopqrstuvwxyz";
    final static String REV_ALPHABET = "zyxwvutsrqponmlkgihgfedcba";    
    private int key;
    
    public Encryption()
    {
        this.data = "";
        this.key = 0;
        this.method = "caeser";
    }

    public Encryption(String data) {
        this.data = data;
    }

    public Encryption(String data, String method, int key) {
        this.data = data;
        this.method = method;
        this.key = key;
    }

    public Encryption(String data, int key) {
        this.data = data;
        this.key = key;
    }

    public Encryption(String data, String method) {
        this.data = data;
        this.method = method;
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
        for(int i = 0 ; i <data.length();i++)
        {
         if(Character.isLetter(data.charAt(i)))
         {
            flag = (data.substring(i,i+1)).replace(data.charAt(i),alphatoNumbers.get(data.charAt(i)));
            encrypted.append(flag);
         }
         else
         {
             encrypted.append(data.charAt(i));
         }
        }
        return encrypted;
    }
    public StringBuilder shiftAll()
    {
        StringBuilder encrypted = new StringBuilder();
        for(int i = 0 ; i <data.length();i++)
        {
         char shifted = (char)((int)data.charAt(i)+key);
         encrypted.append(shifted);
        }
         return encrypted;
    }
    
    
    public StringBuilder caesar()
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
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
    
}
