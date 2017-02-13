package app;
 
import utils.DataReader;
import data.Book;
import data.Library;
 
public class LibraryControl {
    // zmienne do kontrolowania programu
    public static final int exit = 0;
    public static final int addBook = 1;
    public static final int printBooks = 2;
 
    // zmienna do komunikacji z u¿ytkownikiem
    private DataReader dataReader;
 
    // "biblioteka" przechowuj¹ca dane
    private Library library;
 
    public LibraryControl() {
        dataReader = new DataReader();
        library = new Library();
    }
 
    /*
     * G³ówna pêtla programu, która pozwala na wybór opcji i interakcjê
     */
    public void controlLoop() {
        int option;
        printOptions();
        while ((option = dataReader.getInt()) != exit) {
            switch (option) {
            case addBook:
                addBook();
                break;
            case printBooks:
                printBooks();
                break;
            default:
                System.out.println("Nie ma takiej opcji, wprowadŸ ponownie: ");
            }
            printOptions();
        }
        // zamykamy strumieñ wejœcia
        dataReader.close();
    }
 
    private void printOptions() {
        System.out.println("Wybierz opcjê: ");
        System.out.println("0 - wyjœcie z programu");
        System.out.println("1 - dodanie nowej ksi¹¿ki");
        System.out.println("2 - wyœwietl dostêpne ksi¹¿ki");
    }
 
    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }
 
    private void printBooks() {
        library.printBooks();
    }
}