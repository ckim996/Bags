public interface BagInterface<T>
{
    /**
     * Reports the # of objects in the bag
     * @return The # of objects in the bag
     */
    public int getCurrentSize();

    /**
     * Checks if the bag is empty
     * @return True if bag isEmpty(), False if bag is not empty
     */
    public boolean isEmpty();

    /**
     * Adds object to bag
     * @param newEntry
     * @return True if add is successful, false if not
     */
    public boolean add(T newEntry);

    /**
     * Removes an unspecified object from the bag
     * @return Either removed entry or null (if removal is unsuccessful)
     */
    public T remove();

    /**
     * Removes a particular object from the bag
     * @param anEntry
     * @return True if removal is successful, false if not
     */
    public boolean remove(T anEntry);

    /**
     * Removes all objects from the bag
     */
    public void clear();

    /**
     * Checks the # of times an objects appears in the bag
     * @param anEntry
     * @return The # of times anEntry appears in the bag
     */
    public int getFrequencyOf(T anEntry);

    /**
     * Checks if back contains anEntry
     * @param anEntry
     * @return Returns true if anEntry is in the bag, False if not
     */
    public boolean contains(T anEntry);

    /**
     * Retrieves all entries in the bag
     * @return A newly allocated array of all the entries in the bag
     * Note: If bag is empty, the returned array is empty
     */
    public T[] toArray();
}
