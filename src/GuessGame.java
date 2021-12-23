import java.util.Arrays;

public class GuessGame<T> implements GameInterface<T>
{
    private T[] guessBag;
    private int numOfGuess;
    private static final int DEFAULT_NUM = 10;

    public GuessGame()
    {
        this.guessBag = (T[]) new Object[DEFAULT_NUM];
    }

    public GuessGame(int num)
    {
        if( 0 < num && num >= 4)
        {
            this.guessBag = (T[]) new Object[num];
            numOfGuess = 0;
        }
    }

    @Override
    public int getNumOfGuess()
    {
        return this.numOfGuess;
    }

    @Override
    public boolean add(T newEntry) {
        if(newEntry == null || numOfGuess == guessBag.length)
        {
            return false;
        }else{
            guessBag[numOfGuess] = newEntry;
            numOfGuess++;
            return true;
        }
    }

    @Override
    public boolean contain(T anEntry)
    {
        for(int i = 0; i < guessBag.length; i++)
        {
            if(guessBag[i].equals(anEntry))
            {
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    @Override
    public T[] toArray() {
        return Arrays.copyOf(guessBag,numOfGuess);
        /*
        T[] result = (T[]) new Object[DEFAULT_NUM];
        for(int i = 0 ; i < guessBag.length; i++)
        {
            result[i] = guessBag[i];
        }

        return result;

         */
    }

    @Override
    public void replace(T[] arr) {
        for(int i = 0; i < arr.length; i++)
        {
            guessBag[i] = arr[i];
        }
    }


}
