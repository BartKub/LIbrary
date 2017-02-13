package app;
 
import utils.DataReader;
import data.Book;
import data.Library;
import data.Magazine;
 
public class LibraryControl {
    // zmienne do kontrolowania programu
	 	public static final int EXIT = 0;
	    public static final int ADD_BOOK = 1;
	    public static final int ADD_MAGAZINE = 2;
	    public static final int PRINT_BOOKS = 3;
	    public static final int PRINT_MAGAZINES = 4;
 
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
        while ((option = dataReader.getInt()) != EXIT) {
            switch (option) {
            case ADD_BOOK:
                addBook();
                break;
            case ADD_MAGAZINE:
                addMagazine();
                break;
            case PRINT_BOOKS:
                printBooks();
                break;
            case PRINT_MAGAZINES:
                printMagazines();
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
        System.out.println(EXIT + " - wyjœcie z programu");
        System.out.println(ADD_BOOK + " - dodanie nowej ksi¹¿ki");
        System.out.println(ADD_MAGAZINE + " - dodanie nowego magazynu");
        System.out.println(PRINT_BOOKS + " - wyœwietl dostêpne ksi¹¿ki");
        System.out.println(PRINT_MAGAZINES + " - wyœwietl dostêpne magazyny");
    }
 
    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }
 
    private void printBooks() {
        library.printBooks();
    }
     
    private void addMagazine() {
        Magazine magazine = dataReader.readAndCreateMagazine();
        library.addMagazine(magazine);
    }
 
    private void printMagazines() {
        library.printMagazines();
    }
}