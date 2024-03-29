package com.company;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int number = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your number :");
        try{
            number = scanner.nextInt();   
        }catch (InputMismatchException ex){
            System.out.println("Input is not a number!");
        }

        if (number == 0){
            System.out.println("Zero");
        }else if (number <= 20){
            System.out.println(OneToTwenty(number));
        }else if (number <= 99 ){
            System.out.println(TwentyOneToNinetyNine(number));;
        }else if (number <= 999){
            System.out.println(OneHundredToNineHundred(number));
        }else if (number <= 20000){
            System.out.println(OneThousandToTwentyThousand(number));
        }else if (number <= 99999){
            System.out.println(TwentyThousandToNinetyThousand(number));
        }
    }

    public static String OneToTwenty(int number){
        String[] words = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                          "Eleven", "Twelve", "Thirteen", "Fourteen", "fifteen", "Sixteen", "Seventeen", "Eighteen",
                          "Nineteen", "Twenty"};
        return words[number];
    }

    public static String TwentyOneToNinetyNine(int number){
        String[] words = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String word = words[(number/10)-2] + " " + OneToTwenty(number%10);
        return word;
    }

    public static String OneHundredToNineHundred(int number){
        String word;
        if (number % 100 == 0){
            word = OneToTwenty(number/100) + " hundred";
        }else{
            word = OneToTwenty(number/100) + " hundred " + "and " +TwentyOneToNinetyNine(number%100);
        }
        return word;
    }

    public static String OneThousandToTwentyThousand(int number){
        String word;
        if (number % 1000 == 0){
            word = OneToTwenty(number/1000) + " thousand";
        }else{
            word = OneToTwenty(number/1000) +  " thousand " + OneHundredToNineHundred(number%1000);
        }
        return word;
    }

    public static String TwentyThousandToNinetyThousand(int number){
        String word;
        if (number % 1000 == 0){
            word = TwentyOneToNinetyNine(number/1000) + " thousand";
        }else{
            word = TwentyOneToNinetyNine(number/1000) + " thousand " + OneHundredToNineHundred(number%1000);
        }
        return word;
    }
}
