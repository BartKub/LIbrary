package data;



public class Library {

	  public static final int MAX_PUBLICATIONS = 2000;
	    private Publication[] publications;
	    private int publicationsNumber;
	     
	    public int getPublicationsNumber() {
	        return publicationsNumber;
	    }
	     
	    public Publication[] getPublications() {
	        return publications;
	    }
	 
	    public void setPublicaitons(Publication[] publications) {
	        this.publications = publications;
	    }
	 
	    public Library() {
	        setPublicaitons(new Publication[MAX_PUBLICATIONS]);
	    }
	     
	    public void addBook(Book book) {
	        addPublication(book);
	    }
	     
	    public void addMagazine(Magazine magazine) {
	        addPublication(magazine);
	    }
	     
	    private void addPublication(Publication pub) throws ArrayIndexOutOfBoundsException {
	        if(publicationsNumber == MAX_PUBLICATIONS) {
	        	throw new ArrayIndexOutOfBoundsException("MAX_PUBLICATIONS " + MAX_PUBLICATIONS);
	        }
	            publications[publicationsNumber] = pub;
	            publicationsNumber++;
	    
	    }
	     

	}