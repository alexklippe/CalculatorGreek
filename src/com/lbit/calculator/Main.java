package com.lbit.calculator;
import java.io.IOException;
import java.util.Scanner;
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
            for (int n = 0; n <= 100; n++) {
                // Reading data using readLine

                System.out.print("Введите a + b: ");
                Scanner scanner = new Scanner(System.in);
                String inputString = scanner.nextLine();
                classCalc myCalc = new classCalc();
                String splitInput[] = inputString.split("\s");
                //rims only or arabic only (regex)

                //chek operations ( + - * / )

                //check maximum (1 to 10)  regexp


//rims to arabic


                myCalc.a = Integer.parseInt(splitInput[0]);
                myCalc.b = Integer.parseInt(splitInput[2]);


                myCalc.operation = splitInput[1].charAt(0);
                myCalc.main();
                System.out.println("String read from console is : \n" + myCalc.result);

            }
        }  //end try
        catch (Exception e ){
            System.out.println("Ошибка 1" + e.getLocalizedMessage());


        }
    } //main


}
