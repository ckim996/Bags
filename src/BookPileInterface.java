public interface BookPileInterface<T>
{
    public boolean isEmpty();

    public boolean isTop();

    public T remove();

    public T topItem();

    public boolean add(T newEntry);

    public int getNumOfBooks();
}
