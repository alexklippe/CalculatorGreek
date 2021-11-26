package com.lbit.calculator;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.zip.CheckedInputStream;


public class Main {

    public static void main(String[] args) {
        // write your code here
        //hello
        System.out.println("Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами: a + b, a - b, a * b, a / b");
        System.out.println("Калькулятор умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…) числами");
        System.out.println("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.");
        System.out.println("Калькулятор умеет работать только с целыми числами.");
        //read in cicle information
        try {
            String calcResult;

            for (int n = 0; n <= 100; n++) {
                // Reading data using readLine

                System.out.print("Введите a + b: ");
                Scanner scanner = new Scanner(System.in);
                String inputString = scanner.nextLine();

                // одно число
                if (Pattern.matches("^([\\d&&[^0]]|I[XV]|V?I{0,3}|X)$",inputString)) {
                    throw new Exception("//т.к. строка не является математической операцией");
                }
                //  три числа и более
                if ((Pattern.matches("^([\\d&&[^0]]\\s[+\\-*/]\\s){2,}[\\d&&[^0]]$",inputString)) ||
                        Pattern.matches("^((I[XV]|V?I{0,3}|X)\\s[+\\-*/]\\s){2,}(I[XV]|V?I{0,3}|X)$",inputString))   {
                    throw new Exception("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)" );
                }

                //rims only or arabic only (regex)
                if ((Pattern.matches("^[\\d&&[^0]]\\s[+\\-*/]\\s(I[XV]|V?I{0,3}|X)$",inputString)) ||
                (Pattern.matches("^(I[XV]|V?I{0,3}|X)\\s[+\\-*/]\\s[\\d&&[^0]]$",inputString))){
                    throw new Exception("//т.к. используются одновременно разные системы счисления");

                }
                //ошибка в формате или операции
                if ((!Pattern.matches("^[\\d&&[^0]]\\s[+\\-*/]\\s[\\d&&[^0]]$",inputString)) &&
                        (!Pattern.matches("^(I[XV]|V?I{0,3}|X)\\s[+\\-*/]\\s(I[XV]|V?I{0,3}|X)$",inputString)))   {
                    throw new Exception("//т.к. формат математической операции не удовлетворяет заданию" );
                }

                classCalc myCalc = new classCalc();
                //parse string for operations
                String[] splitInput = inputString.split("\s");

                //rims true
                if (Pattern.matches("^(I[XV]|V?I{0,3}|X)\\s[+\\-*/]\\s(I[XV]|V?I{0,3}|X)$",inputString)) {
                    myCalc.rimsDigits = true;
                    myCalc.a = classCalc.romanToArabic(splitInput[0]);
                    myCalc.b = classCalc.romanToArabic(splitInput[2]);
                }
                else if (Pattern.matches("^[\\d&&[^0]]\\s[+\\-*/]\\s[\\d&&[^0]]$",inputString)) //arabic
                {

                    myCalc.rimsDigits = false;
                    myCalc.a = Integer.parseInt(splitInput[0]);
                    myCalc.b = Integer.parseInt(splitInput[2]);
                }
                else
                {
                    throw new Exception("2. //т.к. формат математической операции не удовлетворяет заданию" );
                }

                myCalc.operation = splitInput[1].charAt(0);

                //do operation
                myCalc.main();

                //reverse convert
                if (myCalc.rimsDigits) {
                     calcResult= classCalc.arabicToRoman(myCalc.result);
                } else {
                    //output
                    calcResult= String.valueOf(myCalc.result);
                }
                System.out.println("String read from console is : \n" + calcResult);
            }
        }  //end try
        catch (Exception e ){
            System.out.println("throw exception " + e.getLocalizedMessage());


        }
    } //main


}
