package web.model;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users", schema = "mvc-users")
@Component
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    @NotNull
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "email")
    private String email;



    public User(String name, int age) {
        //this.id = ListPeople.userCount;
        this.name = name;
        this.age = age;
    };

    public User(){};
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return this.name + " " + this.age + " " + this.id;
    }

    public static void printUsers(List<User> users) {
        if (users == null) {
            System.out.println("No any users");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

}
