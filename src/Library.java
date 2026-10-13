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

    public float averagePageNuber() throws IOException {

        boolean continueAddingBooks = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List <String> bookTitleList = new ArrayList<>();
        String continueOption;
        int pageSum = 0;

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
}
