package data;



public class Library {

	    public static final int MAX_BOOKS= 1000;
	    public static final int MAX_MAGAZINES =1000;
	    private Book[] books;
	    private Magazine [] magazines;
	    private int booksNumber;
	    private int magazineNumber;
	     
	    public int getBooksNumber() {
	        return booksNumber;
	    }	 
	  
		public Book[] getBooks() {
	        return books;
	    }
		public int getMagazineNumber() {
			return magazineNumber;
		}

		public void setMagazineNumber(int magazineNumber) {
			this.magazineNumber = magazineNumber;
		}	 
		
	    public Magazine[] getMagazines() {
			return magazines;
		}

		public void setMagazines(Magazine[] magazines) {
			this.magazines = magazines;
		}

		public Library() {
	        books = new Book[MAX_BOOKS];
	        magazines = new Magazine[MAX_MAGAZINES];
	    }
	     
	    public void addBook(Book book) {
	        if(booksNumber < MAX_BOOKS) {
	            books[booksNumber] = book;
	            booksNumber++;
	        } else {
	            System.out.println("Maxymalna liczba ksi¹¿ek zosta³a osi¹gniêta");
	        }
	    }
	    
	        public void addMagazine(Magazine magazine) {
	            if(magazineNumber < MAX_MAGAZINES) {
	                magazines[magazineNumber] = magazine;
	                magazineNumber++;
	            } else {
	                System.out.println("Maxymalna liczba magazynów zosta³a osi¹gniêta");
	            }
	              
	        }
	     
	    public void printBooks() {
	        if(booksNumber == 0) {
	            System.out.println("Brak ksi¹¿ek w bibliotece");
	        }
	        for(int i=0; i<booksNumber; i++) {
	        	System.out.println(books[i]);
	        }
	    }
	    
	    public void printMagazines(){
	    	if(magazineNumber==0){
	    		System.out.println("Brak magazynow w bibliotece");
	    	}
	    	for (int i=0;i<magazineNumber;i++){
	    		System.out.println(magazines[i]);
	    		
	    	}
	    }
	}