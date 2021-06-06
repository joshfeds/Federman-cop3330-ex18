package oop.exercise;
import java.math.RoundingMode;
import java.util.Scanner;
import java.math.BigDecimal;
/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Joshua Federman
 */

public class Exercise18
{
    static Scanner input = new Scanner(System.in);
    public static String choice(){
        System.out.print("Press C to convert from Fahrenheit to Celsius.\n" +
                "Press F to convert from Celsius to Fahrenheit.\n" +
                "Your choice: ");
        String choice = input.nextLine();
        while(!choice.equalsIgnoreCase("C") && !choice.equalsIgnoreCase("f"))
        {
            System.out.print("Press C to convert from Fahrenheit to Celsius.\n" +
                    "Press F to convert from Celsius to Fahrenheit.\n" +
                    "Your choice: ");
            choice = input.nextLine();
        }
            return choice;

    }
    public static String temperature(String choice){
        if(choice.equalsIgnoreCase("C"))
            System.out.print("Please enter the temperature in Fahrenheit: ");

        if(choice.equalsIgnoreCase("f"))
            System.out.print("Please enter the temperature in Celsius: ");

        return input.nextLine();

    }
    public static float doConversion(String choice, String t){
        float temperature = Float.parseFloat(t);
        float conversion = 0;
        if(choice.equalsIgnoreCase("C"))
            conversion = (temperature - 32) * 5 / 9;

        if(choice.equalsIgnoreCase("f"))
            conversion = (temperature * 9 / 5) + 32;
        return conversion;
    }
    public static void convResult(float conv, String choice){
        BigDecimal rConv = new BigDecimal(conv);
        rConv = rConv.setScale(0, RoundingMode.CEILING);

        String result = choice.equalsIgnoreCase("C") ?
                "The temperature in Celsius is " + rConv + ".":
                "The temperature in Fahrenheit is " + rConv + ".";

        System.out.print(result);
    }
    public static void main( String[] args ) {
        String choice = choice();
        String temperature = temperature(choice);
        float conversion = doConversion(choice, temperature);
        convResult(conversion, choice);
    }
}
