public class Books<T>
{
    private T[] books;
    private String title;
    private int numInPile;

    public Books()
    {
        this.books = (T[]) new Object[10];
    }

    public Books(String title, int numInPile)
    {
        this.title = title;
        this.numInPile = numInPile;
    }

    public String getTitle()
    {
        return this.title;
    }

    public int getNumInPile() {
        return numInPile;
    }
}
