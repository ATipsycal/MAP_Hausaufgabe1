import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {
    List<Book> bookList = new ArrayList<>();
    public void newBook(String title, String author, float price, int numberOfPages)
    {
        bookList.add(new Book(title, author, price, numberOfPages));
    }

    public List<Book> allBooksOfAuthor(String author)
    {
        List<Book> booksFromAuthor = new ArrayList<>();
        for (Book book : bookList)
        {
            if(Objects.equals(book.getAuthor(), author))
            {
                booksFromAuthor.add(book);
            }
        }
        return booksFromAuthor;
    }

    public ArrayList<String> readBookTitleInputs() throws IOException {
        boolean continueAddingBooks = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> bookTitleList = new ArrayList<>();
        String continueOption;

        while(continueAddingBooks)
        {
            System.out.println("Gibt ein Buchtitel ein: ");
            bookTitleList.add(reader.readLine());

            System.out.println("Moechten Sie ein anderes Buch eingeben? (y/n)");
            continueOption = reader.readLine();

            switch (continueOption)
            {
                case "y":
                case "Y":
                    break;

                case "n":
                case "N":
                    continueAddingBooks = false;
                    break;

                default:
                    System.out.println("Keine gueltige Option!");
                    continueAddingBooks = false;
                    break;
            }
        }
        return bookTitleList;
    }

    public float averagePageNuber() throws IOException {

        List<String> bookTitleList = readBookTitleInputs();
        int pageSum = 0;

        for (String bookTitle: bookTitleList)
        {
            for(Book book : bookList)
            {
                if(Objects.equals(book.getTitle(), bookTitle))
                {
                    pageSum+= book.getNumberOfPages();
                }
            }
        }
        return (float) pageSum / bookTitleList.size();
    }

    public List<Book> booksUnderPrice(float price)
    {
        List<Book> booksUnderPriceList = new ArrayList<>();
        for(Book book : bookList)
        {
            if(book.getPrice() <= price)
            {
                booksUnderPriceList.add(book);
            }
        }
        return booksUnderPriceList;
    }

    public Book mostExpensiveBook() throws IOException {
        Book mostExpensiveBook = null;
        List<String> bookTitleList = readBookTitleInputs();
        float maxPrice = bookList.getFirst().getPrice();
        for(Book book : bookList)
        {
            for(String title : bookTitleList)
            {
                if (Objects.equals(book.getTitle(), title) && book.getPrice() > maxPrice) {
                    mostExpensiveBook = book;
                    break;
                }
            }
        }
        return mostExpensiveBook;
    }

    public List<Book> allBooksWithMinimumNumberOfPages(int numberOfPages)
    {
        List<Book> selectedBooks = new ArrayList<>();
        for(Book book : bookList)
        {
            if(book.getNumberOfPages() >= numberOfPages)
                selectedBooks.add(book);
        }
        return selectedBooks;
    }

    public List<Book> mostExpensiveBookCombinationWithinSetPrice(float budget)
    {
        List<Book> selectedBookPair = new ArrayList<>();
        float maxPrice = bookList.get(0).getPrice() + bookList.get(1).getPrice();
        for(Book book1 : bookList)
        {
            for(Book book2 : bookList)
            {
                if(!Objects.equals(book1, book2) && book1.getPrice() + book2.getPrice() <= budget && book1.getPrice() + book2.getPrice() > maxPrice)
                {
                    selectedBookPair.set(0, book1);
                    selectedBookPair.set(1, book2);
                    maxPrice = book1.getPrice() + book2.getPrice();
                }
            }
        }
        return selectedBookPair;
    }
}
