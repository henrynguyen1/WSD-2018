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
        Boolean loggedin;
    public static void main(String[] args) throws Throwable {
        Scanner scanner = new Scanner(System.in);
        Boolean loggedin;

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
                case 'd':
                    //BookSOAP.deleteUser();
                    break;
                case 'c':
                    DisplayBook();
                    break;
                default:
                    System.out.println("Sorry, didn't understand your input.");
                    break;
            }

        }

    }
    
    private static void DisplayBook()
    {
        TextbookSOAP_Service locator = new TextbookSOAP_Service();
        TextbookSOAP BookSOAP = locator.getTextbookSOAPPort();
        List<Textbook> books = BookSOAP.fetchBook();
        if (books !=null)
        {
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
    
    private static void Login(){
        UserSOAP_Service locator = new UserSOAP_Service();
        UserSOAP userSOAP = locator.getUserSOAPPort();
        String email, pass;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter email: ");
        email = scanner.nextLine();
        System.out.println("Enter password: ");
        pass = scanner.nextLine();
        User user = userSOAP.getUsersDetail(email, pass);
        if (user != null)
        {
            System.out.println("Working");
        }
        else
        {
            System.out.println("Nope");
        }
    }

    private static void printOptions() {
        String[] options = {
            "A --> Add user",
            "D --> Delete user",
            "C --> Show all books"
        };

        for (String option : options) {
            System.out.println(option);
        }
    }
}
