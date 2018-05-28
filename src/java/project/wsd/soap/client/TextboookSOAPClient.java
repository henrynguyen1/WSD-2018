/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.wsd.soap.client;

import java.util.List;
import java.util.Scanner;

/**
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
                case 'a':
                    Login();
                    break;
                case 'b':
                    loggedin = false;
                    break;
                case 'c':
                    DisplayBook();
                    break;
                case 'd':
                    AddBook();

                default:
                    System.out.println("Sorry, didn't understand your input.");
                    break;
            }

        }

    }

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
            System.out.println("Working");
            loggedin = true;
        } else {
            System.out.println("Nope");
        }
    }

    private static void printOptions() {
        String[] options = {
            "A --> Login",
            "B --> Log out",
            "C --> Show all books",
            "D --> Add a book"

        };

        for (String option : options) {
            System.out.println(option);
        }
    }

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
        System.out.println("Run");
    }
}
