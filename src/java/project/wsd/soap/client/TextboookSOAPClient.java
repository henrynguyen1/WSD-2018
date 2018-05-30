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
 *
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
                    if (loggedin == false) {
                        Login();
                        loggedin = true;
                        break;
                    } else {
                        System.out.println("You are already logged in");
                        break;
                    }
                case '2':
                    if (loggedin == true) {
                        loggedin = false;
                        break;
                    } else {
                        System.out.println("You are already logged out");
                        break;
                    }
                case '3':
                    DisplayBook();
                    break;
                case '4':
                    FindBookID();
                    break;
                case '5':
                    if (loggedin == true) {
                        AddBook();
                        break;
                    } else {
                        System.out.println("You have to log in first");
                        break;
                    }
                case '6':
                    if (loggedin == true) {
                        RemoveBook();
                        break;
                    } else {
                        System.out.println("You have to log in first");
                        break;
                    }
                case '7':
                    if (loggedin == true) {
                        Reserve();
                        break;
                    } else {
                        System.out.println("You have to log in first");
                        break;
                    }

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
            "5 --> List a book",
            "6 --> Delete a book",
            "7 --> Reserve a book"

        };

        for (String option : options) {
            System.out.println(option);
        }
    }

    // Add book in the database
    private static void AddBook() throws Exception_Exception {
        String title, author, date, ISBN, publisher, abstracts, category, reservation, lister, condition;
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
        System.out.println("Enter date:");
        date = scanner.nextLine();
        System.out.println("Enter abstracts:");
        abstracts = scanner.nextLine();
        System.out.println("Enter category:");
        category = scanner.nextLine();
        reservation = "no";
        System.out.println("Enter bookID:");
        bookID = scanner.nextInt();
        System.out.println("Enter lister:");
        lister = scanner.nextLine();
        System.out.println("Enter condition:");
        condition = scanner.nextLine();
        BookSOAP.addBook(title, author, ISBN, publisher, date, abstracts, category, reservation, bookID, lister, condition);
        System.out.println("Your book has been added");
    }

    private static void RemoveBook() throws Exception_Exception {
        Scanner scanner = new Scanner(System.in);
        TextbookSOAP_Service locator = new TextbookSOAP_Service();
        TextbookSOAP BookSOAP = locator.getTextbookSOAPPort();
        String title;
        System.out.println("Enter title:");
        title = scanner.nextLine();
        if (title != null) {
            BookSOAP.removeBook(title);
            System.out.println(title + " has been removed");
        }
    }

    private static void Reserve() throws Exception_Exception {
        Scanner scanner = new Scanner(System.in);
        TextbookSOAP_Service locator = new TextbookSOAP_Service();
        TextbookSOAP BookSOAP = locator.getTextbookSOAPPort();
        String title;
        System.out.println("Enter title:");
        title = scanner.nextLine();
        if (title != null) {
            int result = BookSOAP.reserve(title);
            if (result == 1) {
                System.out.println(title + " has been reserved");
            } else if (result ==0)  {
                System.out.println("Cant");
            }
        }
    }
}
