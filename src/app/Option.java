package app;

import java.util.NoSuchElementException;

public enum Option {
	
	EXIT(0, "Wyjscie z programu"),
	ADD_BOOK(1, "Dodanie ksiazki"),
	ADD_MAGAZINE(2, "Dodanie magazynu/gazety"),
	PRINT_BOOKS(3, "Wyswietlenie dostepnych ksiazek"),
	PRINT_MAGAZINES(4,"Wyswietlenie dostepnych magazymow");

	private int value;
	private String description;
	
	private Option(int value, String description) {
		this.value = value;
		this.description = description;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public
	String toString(){
		return value + " - "+ description;
	}
	
	public static Option createFromInt(int option){
		Option result = null;
		try{
			result = Option.values()[option];
		}catch (ArrayIndexOutOfBoundsException e){
			throw new NoSuchElementException("Brak elementu o wskazanym ID");
		}
		
		return result;
	}
}
