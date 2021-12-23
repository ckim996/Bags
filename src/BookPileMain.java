public class BookPileMain
{
    public static void main(String[] args) {
        Books[] b = {
                new Books("Harry Potter", 1),
                new Books("Hunger Games", 2),
                new Books("Introduction to Java", 3),
                new Books("Steve Jobs", 4)
        };

        BookPileInterface<Books> pile = new BookPile<>();
        Books book = null;
        String pileFormat = "%-20s%20s%n";

        System.out.println("BookPile program:" +
                "\n Book is piled from 1...n numbers of books" +
                "\n 1 being the first in the stack or top" +
                "\n n being the top");

        System.out.println();

        String books = "Books";
        String pilePos = "Pile Position";
        System.out.printf(pileFormat,books,pilePos);
        System.out.println("------------------------------------------------");

        for(int i = 0; i < b.length; i++)
        {
            book = b[i];
            pile.add(book);
            String bookTitle = book.getTitle();
            String pos = Integer.toString(book.getNumInPile());

            System.out.printf(pileFormat,bookTitle,pos);
        }
        System.out.println("Total number of books: " + pile.getNumOfBooks());

        System.out.println("\nBook in top of the file: " + pile.topItem().getTitle());

        System.out.println("\nRemoving stack in order from top to bottom: ");

        while(!pile.isEmpty())
        {
            System.out.println(pile.remove().getTitle());
        }
    }
}
