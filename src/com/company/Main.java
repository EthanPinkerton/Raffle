package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> raffle = new HashMap<String, Integer>();
        Random random = new Random();
        int[] primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        char option;
        String name;
        boolean run = true;
        boolean win = false;

        while(run) {
            System.out.print("Enter:\nA - check a raffle ticket\nB - purchase a raffle ticket\nC - quit the program\n>");
            option = br.readLine().charAt(0);
            switch(Character.toLowerCase(option)){

                case 'a':
                    System.out.print("Enter your name\n>");
                    name = br.readLine();
                    for (int primeNumber : primeNumbers) {
                        try {
                            if (raffle.get(name) == primeNumber) {
                                System.out.println("You win a prize");
                                win = true;
                                raffle.remove(name);
                                break;
                            }
                        }catch (NullPointerException e){
                            System.out.println("Invalid name");
                            break;
                        }
                    }
                    if(!win){
                        System.out.println("You didn't win anything");
                    }
                    break;

                case 'b':
                    System.out.print("Enter your name\n>");
                    name = br.readLine();
                    raffle.put(name,random.nextInt(100));
                    System.out.println("Your number is " + raffle.get(name) + " check the ticket to see if you win");
                    break;

                case 'c':
                    run = false;
                    break;
                default:
                    System.out.print("Invalid input");
            }
        }
    }
}
