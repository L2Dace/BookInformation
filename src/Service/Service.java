/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Connect.book_dao;
import bookinformation.book;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Service {
    private book_dao book;
    
    public Service(){
        book = new book_dao();
    }
    public List<book> getAllBooks(){
        return book.getAllBooks();
    }
    
    public List<book> searchBooks(String title){
        return book.searchBook(title);
    }
    
    public void deleteBook(int id){
        book.deleteBook(id);
    }
    
    public void addBook(book sach){
        book.addBook(sach);
    }
    
}
