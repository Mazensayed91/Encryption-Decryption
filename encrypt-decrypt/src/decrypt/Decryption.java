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
public class Decryption {
    private String data;
    private String method;   
    private int key;
    
    public Decryption()
    {
        this.data = "";
        this.key = 0;
        this.method = "caeser";
    }

    public Decryption(String data) {
        this.data = data;
    }

    public Decryption(String data, String method, int key) {
        this.data = data;
        this.method = method;
        this.key = key;
    }

    public Decryption(String data, int key) {
        this.data = data;
        this.key = key;
    }

    public Decryption(String data, String method) {
        this.data = data;
        this.method = method;
    }
    public StringBuilder shiftAll()
    {
        StringBuilder decrypted = new StringBuilder();
        for(int i = 0 ; i <data.length();i++)
        {
         char shifted = (char)((int)data.charAt(i)-key);
         decrypted.append(shifted);
        }
         return decrypted;
    }
    public StringBuilder decryptCaesar()
    {
        StringBuilder decrypted = new StringBuilder();
        
        for(int i = 0 ; i <data.length();i++)
        {
         if(Character.isLetter(data.charAt(i)))
         {
            char shifted = (char)((int)data.charAt(i)-key);
            if(Character.isLetter(shifted))
                decrypted.append(shifted);
            else
            {
             shifted = (char)((int)data.charAt(i)-key+26); 
             decrypted.append(shifted);

            }
         }
         else
         {
             decrypted.append(data.charAt(i));
         }
        }
        return decrypted;
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
