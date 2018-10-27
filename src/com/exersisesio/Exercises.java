package com.exersisesio;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Exercises {

    private Scanner inputReader;

    // initialize the inputReader

    public Exercises () {
        inputReader = new Scanner(System.in);
    }

    public void exerciseOneAndTwo() {
        //with class Scanner you can read the keyboard
        String input = "";

        // here is how you take the input from keyboard
        input = inputReader.nextLine();
        // this is how you had written to console
        System.out.println("You entered :" + input);

        File file = new File("src/com/resources/exOneAndTwo.txt");
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(input);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void exerciseThree() {
        File file = new File("src/com/resources/exThree.txt");
        try {
            PrintWriter printWriter = new PrintWriter(file);
            String total = "";
            int i = 0;
            while (inputReader.hasNextLine()) {
                String line = inputReader.nextLine();
                total += line + "\n";
                i++;
                if (i == 3) {
                    break;
                }
            }
            printWriter.write(total);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void closeScanner(){
        inputReader.close();
    }

    public void exerciseFour(){

            Path path =  Paths.get("src/com/resources/exThree.txt");
            boolean exists = Files.exists(path);

            System.out.println("File exists : " + exists);
    }
    public void exerciseFive() {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream("src/com/resources/exThree.txt");
            os = new FileOutputStream("src/com/resources/exThreeCopy.txt");
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void exerciseSix(){
        Path source = Paths.get("src/com/resources/exThree.txt");
        Path nwdir = Paths.get("src/com/resources/exSixCopy.txt");

        try{
            Files.copy(source, nwdir);
        }catch (IOException e){
            System.out.println("Unsucessful. What a surprise!");
        }
    }


}

