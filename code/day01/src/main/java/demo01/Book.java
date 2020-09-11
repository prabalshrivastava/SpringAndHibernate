package demo01;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
public class Book {
    private int id;
    private String name;
    private String author;
    private String subject;
    private double price;
}
