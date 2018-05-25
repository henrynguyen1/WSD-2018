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
        TextbookSOAP_Service locator = new TextbookSOAP_Service();
        TextbookSOAP BookSOAP = locator.getTextbookSOAPPort();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter search parameter");
        while (scanner.hasNextLine()) {
            int ID = scanner.nextInt();
            List<Textbook> books = BookSOAP.fetchBookID(ID);
            if (books != null) {
                /*
                System.out.println("Found book: " + book);
                System.out.print("Enter next parameter: ")*/
                books.forEach(book -> System.out.println("Found book: "+book.getTitle()));
            } else {
                System.out.println("Book not found");
                break;
            }
        }
    }
}
