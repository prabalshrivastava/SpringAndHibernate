package sh08;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int custId;
    private String name;
    private String password;
    private String mobile;
    private String address;
    private String email;
    private Date birth;
//    private int age;
}
