package app;

public class LibraryApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final String appName = "Biblioteka v 0.9";
		
		System.out.println(appName);
		LibraryControl libControl = new LibraryControl();
		libControl.controlLoop();
	}

}
