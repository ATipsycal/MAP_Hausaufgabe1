import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Book> bookList = new ArrayList<>();
    public void neuesBuch(String title, String autor, float price, int numberOfPages)
    {
        bookList.add(new Book(title, autor, price, numberOfPages));
    }
}
