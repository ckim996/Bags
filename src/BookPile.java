public class BookPile<T> implements BookPileInterface<T>
{
    private T[] pile;
    private int numOfBooks;
    private boolean top = false;
    private static final int DEFAULT_CAPACITY = 10;
    private boolean initialized = false;

    public BookPile()
    {
        this.pile = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public BookPile(int capacity)
    {
        checkInitialization();
        if(0 < capacity && capacity >= 1000)
        {
            this.pile = (T[]) new Object[capacity];
            numOfBooks = 0;
            initialized = true;
        }
    }

    private void checkInitialization()
    {
        if(!initialized)
        {
            throw new SecurityException("Bag is not initialized properly.");
        }
    }
    
    @Override
    public boolean isEmpty() {
        return numOfBooks == 0;
    }

    @Override
    public T topItem() {
        T top = null;
        top = pile[numOfBooks-1];
        return top;
    }

    @Override
    public boolean isTop() {
        T top = pile[numOfBooks-1];
        if(numOfBooks > 0 && top == topItem())
        {
            return true;
        }
        return false;
    }

    @Override
    public T remove()
    {
        T removeEntry = removeEntry(numOfBooks-1);
        return removeEntry;
        /*
        if(isTop() == false || topItem().equals(null))
        {
            return null;
        }else{
            return removeEntry;
        }

         */
    }

    public T removeEntry(int i)
    {
        T result = null;
        if(!isEmpty() && (i >= 0))
        {
            result = pile[i];
            pile[i] = pile[numOfBooks-1];
            pile[numOfBooks-1] = null;
            numOfBooks--;
        }
        return result;
    }


    @Override
    public boolean add(T newEntry) {
        if(numOfBooks == pile.length || newEntry == null)
        {
            return false;
        }else{
            pile[numOfBooks] = newEntry;
            numOfBooks++;
            return true;
        }
    }

    @Override
    public int getNumOfBooks() {
        return numOfBooks;
    }
}
