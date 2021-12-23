public class OnlineShopper
{
    public static void main(String[] args)
    {
        Item[] items = {
                new Item("Bird feeder", 2050),
                new Item("Squirrel Guard", 1547),
                new Item("Bird Bath", 4499),
                new Item("Sunflower seeds", 1295)
        };

        BagInterface<Item> shoppingCart = new Bag<>();
        int totalCost = 0;
        Item nextItem = null;
        String bagFormat = "%-50s%15s%n";

        for(int i = 0; i < items.length; i++)
        {
            nextItem = items[i];
            shoppingCart.add(nextItem);

            String description = nextItem.getDescription() + " inserted to the cart";
            String size = "(BAG SIZE): " + shoppingCart.getCurrentSize();
            System.out.printf(bagFormat,description,size);

            totalCost = totalCost + nextItem.getPrice();
        }

        System.out.println("\n#s of items in shopping bag: " + shoppingCart.getCurrentSize());

        displayBag(shoppingCart);
        System.out.println("\nCheckout items. Removing...");
        // Simulate checkout
        while(!shoppingCart.isEmpty())
        {
            System.out.println(shoppingCart.remove());
            //System.out.println(shoppingCart.getCurrentSize());
        }
        System.out.println("Total cost: " + "\t$" + totalCost/100 + "." + totalCost%100);
        displayBag(shoppingCart);
    }

    public static void displayBag(BagInterface<Item> b)
    {
        System.out.println("Current bag contents: ");
        Object[] bagArr = b.toArray();
        for(int i = 0; i < bagArr.length; i++)
        {
            System.out.print(bagArr[i] + "|\t");
        }
        System.out.println();
    }
}
