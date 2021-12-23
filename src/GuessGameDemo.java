/**
 * Guessing Game
 * Description: Game gives you four tries to guess the correct numbers from 1-10
 * Skills used: Bags ADT, sorting algorithm, random, comparing two arrays by incrementing matching values
 * Date: 12/22/2021
 */

import java.util.Random;
import java.util.Scanner;

public class GuessGameDemo
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("From 1-4, how many numbers would you like to guess: ");
        int n = sc.nextInt();
        int randomNum;
        GameInterface<Integer> gameNumBag = new GuessGame<>();
        GameInterface<Integer> userNumBag = new GuessGame<>();
        Integer[] arr = new Integer[n];
        Integer[] userGuess = new Integer[n];
        int TOTAL_NUM_OF_TRIES = 4;
        boolean firstTime = true;

        for(int i = 0; i < arr.length; i++)
        {
            randomNum = randomNumGenerator();
            arr[i] = randomNum;
            gameNumBag.add(arr[i]);
        }
        sort(gameNumBag);
        displayGuess(gameNumBag);

        do{
            System.out.println("\nEnter your guesses for the " + n + " integers in the range from 1 to 10: ");
            if(TOTAL_NUM_OF_TRIES == 4)
            {
                for(int i = 0; i < userGuess.length; i++)
                {
                    System.out.print("Guess " + (i+1) + ": ");
                    int guess = sc.nextInt();
                    userGuess[i] = guess;
                    userNumBag.add(userGuess[i]);
                }
                sort(userNumBag);
                displayGuess(gameNumBag);
                System.out.println();
                displayUserGuess(userNumBag);
            }else{
                for(int i = 0; i < userGuess.length; i++)
                {
                    System.out.print("Guess " + (i+1) + ": ");
                    int guess = sc.nextInt();
                    userGuess[i] = guess;
                    userNumBag.replace(userGuess);
                }
                sort(userNumBag);
                displayGuess(gameNumBag);
                System.out.println();
                displayUserGuess(userNumBag);
            }

            TOTAL_NUM_OF_TRIES--;

            int num = compareCounter(gameNumBag,userNumBag);
            if(n==num)
            {
                System.out.println("You are correct!");
                break;
            }
            System.out.println(num + " of your guesses are correct");
        }while(TOTAL_NUM_OF_TRIES > 0);
    }

    public static int randomNumGenerator()
    {
        Random r = new Random();
        int n = r.nextInt(10) + 1;
        return n;
    }

    public static void displayGuess(GameInterface<Integer> gb)
    {
        System.out.print("Randomly Generated Guesses: ");
        Object[] g = gb.toArray();
        for(int i = 0; i < g.length; i++)
        {
            System.out.print(g[i] + " ");
        }
    }

    public static void displayUserGuess(GameInterface<Integer> gb)
    {
        System.out.print("User Guess: ");
        Object[] g = gb.toArray();
        for(int i = 0; i < g.length; i++)
        {
            System.out.print(g[i] + " ");
        }
        System.out.println();
    }

    public static void sort(GameInterface<Integer> gb)
    {
        Object[] objArr = gb.toArray();
        Integer[] intArr = new Integer[objArr.length];

        for(int i = 0; i < objArr.length;i ++)
        {
            intArr[i] = (Integer) objArr[i];
        }

        int temp = 0;
        for(int i = 0; i < intArr.length; i++)
        {
            for(int j = i+1; j < intArr.length; j++)
            {
                if(intArr[i] > intArr[j])
                {
                    temp = intArr[i];
                    intArr[i] = intArr[j];
                    intArr[j] = temp;
                }
            }
        }
        gb.replace(intArr);
    }

    public static int compareCounter(GameInterface<Integer> first, GameInterface<Integer> second)
    {
        Object[] firstObj = first.toArray();
        Object[] secondObj = second.toArray();
        Integer[] firstArr = new Integer[firstObj.length];
        Integer[] secondArr = new Integer[secondObj.length];
        Integer[] tempArr = new Integer[11];
        int counter = 0;

        for(int i = 0; i < firstArr.length; i++)
        {
            firstArr[i] = (Integer) firstObj[i];
            secondArr[i] = (Integer) secondObj[i];
        }

        for(int i = 0; i < tempArr.length; i++)
        {
            tempArr[i] = 0;
        }

        for(int i = 0; i < firstArr.length; i++)
        {
            for(int j = 0; j < secondArr.length; j++)
            {
                if(firstArr[i].equals(secondArr[j]))
                {
                    tempArr[firstArr[i]]++;
                }
            }
        }

        for(int i = 0; i < tempArr.length; i++)
        {
            if(tempArr[i] == 1)
            {
                counter += 1;
            }else if(tempArr[i] > 1)
            {
                int tempNum = tempArr[i]/2;
                counter += tempNum;
            }
        }

        return counter;
    }

}
