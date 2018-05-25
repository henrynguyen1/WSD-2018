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

    public static void main(String[] args) throws Throwable {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            printOptions();

            String input = scanner.nextLine();

            if (input == null) {
                break;
            }

            switch (input.toLowerCase().charAt(0)) {
                case 'a':
                    //BookSOAP.addUser();
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
