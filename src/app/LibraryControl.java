package app;
 
import utils.DataReader;
import utils.LibraryUtils;

import java.util.NoSuchElementException;

import data.Book;
import data.Library;
import data.Magazine;
 
public class LibraryControl {
   
    // zmienna do komunikacji z u�ytkownikiem
    private DataReader dataReader;
 
    // "biblioteka" przechowuj�ca dane
    private Library library;
 
    public LibraryControl() {
        dataReader = new DataReader();
        library = new Library();
    }
 
    /*
     * G��wna p�tla programu, kt�ra pozwala na wyb�r opcji i interakcj�
     */
    public void controlLoop() {
        Option  option;
        printOptions();
        while ((option = Option.createFromInt(dataReader.getInt())) != Option.EXIT) {
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
                System.out.println("Nie ma takiej opcji, wprowad� ponownie: ");
            }
            printOptions();
        }
        // zamykamy strumie� wej�cia
        dataReader.close();
    }
 
    private void printOptions() {
        System.out.println("Wybierz opcj�: ");
       for (Option o: Option.values()){
    	   System.out.println(o);
       }
    }
 
    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }
 
    private void printBooks() {
        LibraryUtils.printBooks(library);
    }
     
    private void addMagazine() {
        Magazine magazine = dataReader.readAndCreateMagazine();
        library.addMagazine(magazine);
    }
 
    private void printMagazines() {
        LibraryUtils.printMagazines(library);
    }
    private enum Option {
        EXIT(0, "Wyjście z programu"),
        ADD_BOOK(1, "Dodanie książki"),
        ADD_MAGAZINE(2,"Dodanie magazynu/gazety"),
        PRINT_BOOKS(3, "Wyświetlenie dostępnych książek"),
        PRINT_MAGAZINES(4, "Wyświetlenie dostępnych magazynów/gazet");
      
        private int value;
        private String description;
      
        Option(int value, String desc) {
            this.value = value;
            this.description = desc;
        }
          
        @Override
        public String toString() {
            return value + " - " + description;
        }
          
        public static Option createFromInt(int option) throws NoSuchElementException {
            Option result = null;
            try {
                result = Option.values()[option];
            } catch(ArrayIndexOutOfBoundsException e) {
                throw new NoSuchElementException("Brak elementu o wskazanym ID");
            }
              
            return result;
        }
    }

}