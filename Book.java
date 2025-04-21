/*
* BookApp.java
* @author JiaLiu
* 07/01/2025
*/

public class Book {
    private String title;   // Book title
    private String author;  // Author name
    private String year;    // Year of publication (stored as a string)
    private String category; // Book category (e.g., Classic, Modern, Contemporary)

    // Constructor
    public Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Method to compute the book category
    public void computeCategory() {
        int yearInt = Integer.parseInt(this.year); // Convert year string to integer
        if (yearInt < 2000) {
            this.category = "Classic";
        } else if (yearInt <= 2015) {
            this.category = "Modern";
        } else {
            this.category = "Contemporary";
        }
    }

    // Method to get the book category
    public String getCategory() {
        return this.category;
    }

    // Method to validate the book title
	public boolean validateTitle() {
	    // Convert the title to lowercase
	    String lowerCaseTitle = this.title.toLowerCase();

	    // Check if the title starts with a punctuation character
	    char firstChar = lowerCaseTitle.charAt(0);
	    if (firstChar == '.' || firstChar == '?' || firstChar == '!') {
	        return false;
	    }

	    // Count the number of words in the title
	    int wordCount = 0;
	    for (int i = 0; i < lowerCaseTitle.length(); i++) {
	        if (lowerCaseTitle.charAt(i) == ' ') {
	            wordCount++;
	        }
	    }
	    // If there are at least two spaces, there are three or more words
	    return wordCount >= 2;

    }
}
