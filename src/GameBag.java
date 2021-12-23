import java.util.Random;

public class GameBag<T>
{
    private T[] bag;
    private int numToGuess;
    private int ranOneToTen;

    public GameBag()
    {
        Random r = new Random();
        int n = r.nextInt(4) + 1;
        this.bag = (T[]) new Object[n];
    }

    public GameBag(int numToGuess, int ranOneToTen)
    {
        this.numToGuess = numToGuess;
        this.ranOneToTen = ranOneToTen;
    }

    public int getNumToGuess()
    {
        return numToGuess;
    }

    public int getRanOneToTen()
    {
        return this.ranOneToTen;
    }
}
