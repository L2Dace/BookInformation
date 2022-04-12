/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect;

import bookinformation.book;
import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class book_dao {
    
    public List<book> getAllBooks(){
        List<book> books = new ArrayList<book>();
        java.sql.Connection connection = SQLConnection.getConnection();
        
        String sql = "SELECT * FROM Sach";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while( rs.next()) {
                book Book = new book();
                
                Book.setiD(rs.getInt("id"));
                Book.setTittle(rs.getString("title"));
                Book.setPrice(rs.getDouble("price"));
                
                books.add(Book);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return books;
    }
    
    public void addBook(book book){
        java.sql.Connection connection = SQLConnection.getConnection();
            
            String sql = "INSERT INTO Sach (title, price) "
                    + "values (?,?) "
                    ;
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, book.getTittle());
                preparedStatement.setDouble(2, book.getPrice());                
//                int rs = preparedStatement.executeUpdate();
//                System.out.println(rs);
                preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
    
    public List<book> searchBook(String title){
        
        List<book> list = new ArrayList<>();
        java.sql.Connection connection = SQLConnection.getConnection();
        try{
            String sql = "SELECT * FROM Sach where title like N'%"+ title +"%'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while( rs.next()){
                book Book = new book();
                
                Book.setiD(rs.getInt("id"));
                Book.setTittle(rs.getString("title"));
                Book.setPrice(rs.getDouble("price"));
                
                list.add(Book);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
        
    }
    
    public void deleteBook(int id){
        java.sql.Connection connection = SQLConnection.getConnection();
        
        String sql = "delete from Sach where id = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            
            int rs = preparedStatement.executeUpdate();
                System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
