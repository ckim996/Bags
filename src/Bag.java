import java.util.Arrays;

public class Bag<T> implements BagInterface
{
    private T[] arr;
    private int numInBag;
    private static final int DEFAULT_CAPACITY = 10;

    public Bag()
    {
        this.arr = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public Bag(int capacity)
    {
        if(0 < capacity && capacity >= 10000)
        {
            this.arr = (T[]) new Object[capacity];
            numInBag = 0;
        }
    }

    @Override
    public int getCurrentSize() {
        return numInBag;
    }

    @Override
    public boolean isEmpty() {
        return numInBag == 0;
    }

    @Override
    public boolean add(Object newEntry) {
        if(numInBag == arr.length || newEntry == null)
        {
            return false;
        }else{
            arr[numInBag] = (T) newEntry;
            ++numInBag;
            return true;
        }
    }

    @Override
    public Object remove() {
        T result = removeEntry(numInBag-1);
        return result;
    }

    @Override
    public boolean remove(Object anEntry) {

        int i = getIndexOf((T) anEntry);
        T result = removeEntry(i);
        return anEntry.equals(result);
    }

    /**
     * Removes and returns the entry at a given array index within the array bag
     * If no such entry exists, returns null
     * @param givenIndex
     */
    public T removeEntry(int givenIndex)
    {
        T result = null;
        if(!isEmpty() && (givenIndex >= 0))
        {
            result = arr[givenIndex];           // entry to remove
            arr[givenIndex] = arr[numInBag-1];  // Replace entry with last entry
            arr[numInBag-1] = null;             // remove last entry
            numInBag--;
        }
        return result;
    }

    /**
     * USED FOR REMOVING SPECIFIC ITEM IN THE BAG 'public boolean remove(Object anEntry)
     * Locates a given entry within the array bag
     * Returns the index of the entry, if located, or -1 otherwise
     * @param anEntry
     */
    private int getIndexOf(T anEntry)
    {
        int where = -1;
        boolean stillLooking = true;
        int i = 0;
        while(stillLooking && (i < numInBag))
        {
            if(anEntry.equals(arr[i]))
            {
                stillLooking = false;
                where = i;
            }
            i++;
        }
        return where;
    }

    @Override
    public void clear() {
        for(int i = 0; i < numInBag; i++)
        {
            arr[i] = null;
        }
        numInBag = 0;
    }

    @Override
    public int getFrequencyOf(Object anEntry) {
        int count = 0;
        for(int i = 0;i < numInBag; i++)
        {
            if(arr[i].equals(anEntry))
            {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean contains(Object anEntry) {
        for(int i = 0; i < numInBag; i++)
        {
            if(arr[i].equals(anEntry))
            {
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(arr,numInBag);
    }
}
