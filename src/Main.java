import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public void main() throws IOException {

        String choice;
        List<Book> selectedBooks;
        // Initializing book list
        Library library = new Library();
        library.newBook("Clean Code", "Robert Martin", 45, 464);
        library.newBook("1984", "George Orwell", 18, 328);
        library.newBook("Animal Farm", "George Orwell", 12, 112);
        library.newBook("Java Basics", "Max Müller", 35, 520);
        library.newBook("The Hobbit", "J. R. R. Tolkien", 28, 310);

        System.out.println("Bitte waehlen Sie eine Operation!");
        System.out.println("1. Bücher eines Autors");
        System.out.println("2. Durchschnittliche Seitenanzahl");
        System.out.println("3. Bücher innerhalb eines Preislimits");
        System.out.println("4. Teuerstes Buch");
        System.out.println("5. Bücher mit einer Mindestseitenanzahl");
        System.out.println("6. Zwei Bücher innerhalb eines Budgets");
        System.out.println();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        choice = reader.readLine();

        switch (choice)
        {
            // Aufgabe 1
            case "1":
                System.out.print("Bitte Geben Sie einen Autor ein: ");
                String author = reader.readLine();
                selectedBooks = library.allBooksOfAuthor(author);
                if(!selectedBooks.isEmpty()) {
                    System.out.println("\nAlle Buecher des Autors " + author + ":");
                    for (Book book : selectedBooks) {
                        System.out.println(book.getTitle());
                    }
                }
                else {
                    System.out.println("Es gibt den Autor " + author + " nicht!");
                }
                break;

            // Aufgabe 2
            case "2":
                float numPages = library.averagePageNuber();
                System.out.println("Die durchschnittliche Anzahl der Seiten ist " + numPages);
                break;

            case "3":
                System.out.print("Bitte geben Sie den maximalen Preis fuer einen Buch: ");
                float maxPrice = Float.parseFloat(reader.readLine());
                selectedBooks = library.booksUnderPrice(maxPrice);
                if(!selectedBooks.isEmpty()) {
                    System.out.println("Die Buecher unter " + maxPrice + " sind: ");
                    for (Book book : selectedBooks) {
                        System.out.println(book.getTitle());
                    }
                }
                else {
                    System.out.println("Es gibt keine Buecher unter " + maxPrice + ".");
                }
                break;

            case "4":
               Book mostExpensiveBook = library.mostExpensiveBook();
               if(mostExpensiveBook != null)
               {
                   System.out.println("Das teursten Buch ist: " + mostExpensiveBook.getTitle() + " (" + mostExpensiveBook.getPrice() + " Euro)");
               }
               else {
                   System.out.println("Es gibt kein solches Buch!");
               }
               break;

            case "5":
                System.out.print("Bitte geben sie die Mindestanzahl der Seiten: ");
                int minNumberOfPages = Integer.parseInt(reader.readLine());
                selectedBooks = library.allBooksWithMinimumNumberOfPages(minNumberOfPages);
                if(!selectedBooks.isEmpty()) {
                    System.out.println("Die Buecher mit mindestens " + minNumberOfPages + " Seinten sind: ");
                    for(Book book : selectedBooks) {
                        System.out.println(book.getTitle());
                    }
                }
                else {
                    System.out.println("Es gibt keine solche Buecher!");
                }
                break;

            case "6":
                System.out.print("Bitte geben Sie ein Budget fuer die 2 Buecher: ");
                float maxBudget = Float.parseFloat(reader.readLine());
                selectedBooks = library.mostExpensiveBookCombinationWithinSetPrice(maxBudget);
                if(!selectedBooks.isEmpty()) {
                    System.out.println(selectedBooks.get(0).getTitle() + " + " + selectedBooks.get(1).getTitle() + "\n" + "GesamtPreis: " + (selectedBooks.get(0).getPrice() + selectedBooks.get(1).getPrice()) + " Euro");
                }
                else {
                    System.out.println("Keine solche Kombination!");
                }
                break;

            default:
                System.out.println("Keine gueltige Option!");
                break;
        }
    }
}