public class Book {
    private final String title, author;
    private final float price;
    private final int numberOfPages;
    public Book(String title, String author, float price, int numberOfPages) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public float getPrice() {
        return price;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}
