import java.util.ArrayList;
import java.util.List;

public class test
{
    public static void main(String[] args)
    {
        int[] guessBag = {4,6,1,6};
        int[] userBag = {1,4,6,6};
        int[] randomBag = {1,4,6,6};

        int[] newGuessBag = simplifyArr(guessBag);
        displayArr(newGuessBag);
        int[] newUserBag = simplifyArr(userBag);
        displayArr(newUserBag);
        int[] newRandomBag = simplifyArr(randomBag);
        displayArr(newRandomBag);

        int counter = 0;
        for(int i = 0 ; i < newGuessBag.length; i++)
        {
            for(int j = 0; j < newUserBag.length; j++)
            {
                if(guessBag[i] == userBag[j])
                {
                    counter++;
                }
            }
        }
        System.out.println();
        System.out.println(counter + " of your guesses are correct");

    }

    public static int[] simplifyArr(int[] arr)
    {
        List<Integer> tempArrList = new ArrayList<>();
        int temp;

        for(int i = 0; i < arr.length; i++)
        {
            tempArrList.add(arr[i]);
        }

        for(int i = 0; i < tempArrList.size(); i++)
        {
            temp = tempArrList.get(i);
            for(int j = i+1; j < tempArrList.size(); j++)
            {
                if(temp == tempArrList.get(j))
                {
                    tempArrList.remove(j);
                }
            }
        }

        int[] tempArr = new int[tempArrList.size()];
        for(int i = 0; i < tempArrList.size(); i++)
        {
            tempArr[i] = tempArrList.get(i);
        }

        return tempArr;
    }

    public static void displayArr(int[] arr)
    {
        for(int i = 0 ; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
