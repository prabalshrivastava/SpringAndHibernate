package demo01;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements AutoCloseable {
    private Connection con;

    public void open() throws Exception {
        con = DriverManager.getConnection(DBUtil.DB_URL, DBUtil.DB_USER, DBUtil.DB_PASSWORD);
    }

    @Override
    public void close() {
        try {
            if (con != null)
                con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Book> findAllBooks() throws Exception {
        List<Book> list = new ArrayList<Book>();
        String sql = "SELECT id, name, author, subject, price FROM books";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String author = rs.getString("author");
                    String subject = rs.getString("subject");
                    double price = rs.getDouble("price");
                    Book b = new Book(id, name, author, subject, price);
                    list.add(b);
                }
            }
        }
        return list;
    }

    public int addBook(Book b) throws Exception {
        int cnt = -1;
        String sql = "INSERT INTO books(id, name, author, subject, price) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, b.getId());
            stmt.setString(2, b.getName());
            stmt.setString(3, b.getAuthor());
            stmt.setString(4, b.getSubject());
            stmt.setDouble(5, b.getPrice());
            cnt = stmt.executeUpdate();
        }
        return cnt;
    }

    @SneakyThrows
    public int updateBook(Book b) {
        int cnt = -1;
        String sql = "Update books set id=?, name=?, author=?, subject=?, price=? where id=?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, b.getId());
            stmt.setString(2, b.getName());
            stmt.setString(3, b.getAuthor());
            stmt.setString(4, b.getSubject());
            stmt.setDouble(5, b.getPrice());
            stmt.setInt(6, b.getId());
            cnt = stmt.executeUpdate();
        }
        return cnt;
    }


    @SneakyThrows
    public int deleteBook(int bookId) {
        int cnt = -1;
        String sql = "DELETE from books where id=?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, bookId);
            cnt = stmt.executeUpdate();
        }
        return cnt;
    }

//     @SneakyThrows
//     Book findById(int bookId){
//        String sql = "SELECT id, name, author, subject, price FROM books where id=?";
//         try (PreparedStatement stmt = con.prepareStatement(sql)) {
//             stmt.setInt(1, bookId);
//             ResultSet resultSet = stmt.executeQuery();
//         }
//     }
    // List<Book> findBySubject(subject)
    // List<String> findSubjects()
}
