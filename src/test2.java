import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class test2
{
    public static void main(String[] args)
    {
        Random r = new Random();
        int randomNum = r.nextInt(5)+1;
        Scanner sc = new Scanner(System.in);
        int TOTAL_TRIES = 3;
        int turn = 0;

        System.out.println("Guessing Game! You get three tries for 1-5");
        do{
            TOTAL_TRIES--;
            System.out.print("Your Guess " + (turn+1) + ": ");
            int n = sc.nextInt();
            if(n < 1 || n > 5)
            {
                System.out.println("Please input guess between 1 - 5. [PENALTY: LOSE ONE TURN]");
                continue;
            }

            if(n == randomNum)
            {
                System.out.println("You got it right! The answer is " + n);
                break;
            }else{
                System.out.println("You did not get it right, you have " + TOTAL_TRIES + " tries");
            }
        }while(TOTAL_TRIES > 0);
    }
}
