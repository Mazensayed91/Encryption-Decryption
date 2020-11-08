package decrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class DataManipulation {
   
    private String[] args;
    private String data;
    private String input_path;
    private String output_path;
    private String mode;
    private int key;
    private boolean file_or_not;
    
    
    public DataManipulation()
    {
        this.data = "";
        this.input_path = "";
        this.output_path = "";
        this.mode = "enc";
    };
    public DataManipulation(String[] arr)
    {
        this.args = arr;
        this.data = "";
        this.input_path = "";
        this.output_path = "";
        this.mode = "enc";
    }

    public DataManipulation(String data, String output_path) {

        this.data = data;
        this.output_path = output_path;
        this.mode = "enc";
    }
    public boolean toFile()
    {
        return !(output_path.length() == 0);
    }
    public boolean isEnc()
    {
        return (mode.equals("enc"));
    }
    public boolean file_or_str()
    {
        if(data.length() == 0)
        {
            return true;
        }
        else if(input_path.length() == 0)
        {
            return false;
        }
        return true;
    }
    
    // Extract the paremters from the array 
    public void parseArgs()
    {
        for(int i =0; i <args.length;i++)
        {
            if(args[i].equals("-data"))
            {
                this.data = args[i+1];
            }
            
            else if(args[i].equals("-in"))
            {
                this.input_path = args[i+1];
            }
            else if(args[i].equals("-out"))
            {
                this.output_path = args[i+1];
            }
            else if(args[i].equals("-mode"))
            {
                this.mode = args[i+1];
            }
            else if(args[i].equals("-key"))
            {
                this.key = Integer.parseInt(args[i+1]);
            }
        }
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
    //Writing data to text file (Encrypted or decrypted data)
    public void writeData(String data)
    {
        try {
        File file = new File(output_path);
        FileWriter writer = new FileWriter(file); // appends text to the file
        writer.write(data);
        writer.close();
        }catch(IOException e)
        {
            System.out.println("The error is : " + e.getMessage());
        }
    }
    //Reading the data we want to encrypt or decrypt from a text file
    public String readData()
    {
        File file = new File(input_path);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                data = scanner.nextLine() ;
                }
        } catch (Exception e) {
            System.out.println("No file found: " );
            }
        return data;
    }
    
    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getInput_path() {
        return input_path;
    }

    public void setInput_path(String input_path) {
        this.input_path = input_path;
    }

    public String getOutput_path() {
        return output_path;
    }

    public void setOutput_path(String output_path) {
        this.output_path = output_path;
    }
    
}
