public interface GameInterface<T>
{
    /**
     * Gets the number of integers user needs to guess
     * @return number of integers user needs to guess
     */
    public int getNumOfGuess();

    /**
     * Adds the randomly generated number from 1-10 into 1-3 game
     * @param newEntry
     * @return randomlmy generated number from 1-10 into 1-3 game
     */
    public boolean add(T newEntry);

    /**
     * Checks if the game contains a certain number
     * @param anEntry
     * @return True if the number in the randomly generated 1-10 is correct by user
     */
    public boolean contain(T anEntry);

    public T[] toArray();

    public void replace(T[] arr);
}
