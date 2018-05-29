/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.wsd.soap.client;

import java.util.List;
import java.util.Scanner;

/**
 * This file will act as a client run by the system to simulate SOAP web service
 * @author Anh Minh Tran
 */
public class TextboookSOAPClient {

    private static Boolean loggedin;

    public static void main(String[] args) throws Throwable {
        Scanner scanner = new Scanner(System.in);
        loggedin = false;
        while (true) {
            printOptions();
            String input = scanner.nextLine();

            if (input == null) {
                break;
            }

            switch (input.toLowerCase().charAt(0)) {
                case '1':
                    Login();
                    break;
                case '2':
                    loggedin = false;
                    break;
                case '3':
                    DisplayBook();
                    break;
                case '4':
                    FindBookID();
                    break;
                case '5':
                    AddBook();
                    break;
                default:
                    System.out.println("Sorry, didn't understand your input.");
                    break;
            }

        }

    }
    // Display all book curently in the XML file
    private static void DisplayBook() {
        TextbookSOAP_Service locator = new TextbookSOAP_Service();
        TextbookSOAP BookSOAP = locator.getTextbookSOAPPort();
        List<Textbook> books = BookSOAP.fetchBook();
        if (books != null) {
            books.forEach(book -> System.out.println("Found book: " + book.getTitle()));
        } else {
            System.out.println("Book not found");
        }
    }
    // Find book in the system by filtering book ID
    private static void FindBookID() {
        TextbookSOAP_Service locator = new TextbookSOAP_Service();
        TextbookSOAP BookSOAP = locator.getTextbookSOAPPort();
        System.out.println("Enter search parameter");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int ID = scanner.nextInt();
            List<Textbook> books = BookSOAP.fetchBookID(ID);
            if (books != null) {
                books.forEach(book -> System.out.println("Found book: " + book.getTitle()));
            } else {
                System.out.println("Book not found");
                break;
            }

        }
    }
    // Login using the data in User XML
    private static void Login() {
        UserSOAP_Service locator = new UserSOAP_Service();
        UserSOAP userSOAP = locator.getUserSOAPPort();
        String email, pass;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter email: ");
        email = scanner.nextLine();
        System.out.println("Enter password: ");
        pass = scanner.nextLine();
        User user = userSOAP.getUsersDetail(email, pass);
        if (user != null) {
            System.out.println("You have been logged in");
            loggedin = true;
        } else {
            System.out.println("Input information is wrong. Please try again");
        }
    }
    // List all available option for user 
    private static void printOptions() {
        String[] options = {
            "1 --> Login",
            "2 --> Log out",
            "3 --> Show all books",
            "4 --> Find book by ID",
            "5 --> Add a book"

        };

        for (String option : options) {
            System.out.println(option);
        }
    }
    // Add book in the database
    private static void AddBook() throws Exception_Exception {
        String title, author, ISBN, publisher, abstracts, category, reservation, lister, condition;
        int bookID;
        Scanner scanner = new Scanner(System.in);
        TextbookSOAP_Service locator = new TextbookSOAP_Service();
        TextbookSOAP BookSOAP = locator.getTextbookSOAPPort();

        System.out.println("Enter title:");
        title = scanner.nextLine();
        System.out.println("Enter author: ");
        author = scanner.nextLine();
        System.out.println("Enter ISBN:");
        ISBN = scanner.nextLine();
        System.out.println("Enter publisher:");
        publisher = scanner.nextLine();
        System.out.println("Enter abstracts:");
        abstracts = scanner.nextLine();
        System.out.println("Enter category:");
        category = scanner.nextLine();
        System.out.println("Enter reservation:");
        reservation = scanner.nextLine();
        System.out.println("Enter bookID:");
        bookID = scanner.nextInt();
        System.out.println("Enter lister:");
        lister = scanner.nextLine();
        System.out.println("Enter condition:");
        condition = scanner.nextLine();
        BookSOAP.addBook(title, author, ISBN, publisher, abstracts, category, reservation, bookID, lister, condition);
    }
}
