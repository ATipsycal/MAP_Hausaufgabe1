public class Book {
    private final String title, autor;
    private final float price;
    private final int numberOfPages;
    public Book(String title, String autor, float price, int numberOfPages) {
        this.title = title;
        this.autor = autor;
        this.price = price;
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public String getAutor() {
        return autor;
    }

    public float getPrice() {
        return price;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}
