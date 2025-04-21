/*
* BookApp.java
* @author JiaLiu
* 07/01/2025
*/

import java.util.Scanner;

public class BookApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask the user how many books they want to categorize
        System.out.print("Enter the number of books you want to categorize: ");
        int bookCount = input.nextInt();
        input.nextLine(); // Clear the newline character

        // Array to store validation results
        String[] validationResults = new String[bookCount];

        // Loop to read book information
        for (int i = 0; i < bookCount; i++) {
            System.out.println("Enter book details (format: Title, Author, Year): ");
            String bookInfo = input.nextLine();

            // Manually split the input string
            String title = "";
            String author = "";
            String year = "";
            int commaCount = 0;
            for (int j = 0; j < bookInfo.length(); j++) {
                char c = bookInfo.charAt(j);
                if (c == ',') {
                    commaCount++;
                } else {
                    if (commaCount == 0) {
                        title += c;
                    } else if (commaCount == 1) {
                        author += c;
                    } else if (commaCount == 2) {
                        year += c;
                    }
                }
            }

            // Remove extra spaces from the title, author, and year
            title = removeExtraSpaces(title);
            author = removeExtraSpaces(author);
            year = removeExtraSpaces(year);

            // Create a Book object
            Book book = new Book(title, author, year);

            // Categorize the book
            book.computeCategory();
            String category = book.getCategory();

            // Validate the book title
            boolean isValid = book.validateTitle();

           // Display the results for the current book
		   System.out.println("Book Category: " + category);

		   // Use if-else instead of a ternary operator for title validation display
		   if (isValid) {
		       System.out.println("Title Validation: Valid");
		   } else {
		       System.out.println("Title Validation: Invalid");
		   }


              // Store validation result in the array using if-else
			    if (isValid) {
			        validationResults[i] = "Title: \"" + title + "\", Validation: Valid";
			    } else {
			        validationResults[i] = "Title: \"" + title + "\", Validation: Invalid";
			    }
			}

input.close();

        // Display all validation results at the end
        System.out.println("\nSummary of Title Validations:");
        for (int i = 0; i < validationResults.length; i++) {
            System.out.println(validationResults[i]);
        }
    }

    // Method to remove extra spaces from a string (manually implemented)
    public static String removeExtraSpaces(String str) {
        int start = 0;
        int end = str.length() - 1;

        // Find the first non-space character from the left
        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }
        // Find the first non-space character from the right
        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }

        // Extract the trimmed part of the string
        String result = "";
        for (int i = start; i <= end; i++) {
            result += str.charAt(i);
        }

        return result;
    }
}
