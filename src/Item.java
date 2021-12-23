public class Item<T>
{
    private T[] items;
    private String itemDescription;
    private int price;

    public Item()
    {
        this.items = (T[]) new Object[10];
    }

    public Item(String itemDescription,int price)
    {
        this.itemDescription = itemDescription;
        this.price = price;
    }

    public String getDescription()
    {
        return this.itemDescription;
    }

    public int getPrice()
    {
        return this.price;
    }

    public String toString()
    {
        return itemDescription + "\t\t$" + price/100 + "." + price%100;
    }
}
