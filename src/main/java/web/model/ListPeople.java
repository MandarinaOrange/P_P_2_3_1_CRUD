package web.model;

import java.util.ArrayList;
import java.util.List;

public class ListPeople {
    public static List<User> USERS = new ArrayList<>();

    static {
        USERS.add(new User(1, "Marina", 20));
        USERS.add(new User(2, "Takano", 24));
        USERS.add(new User(2, "Gokudera", 23));
        USERS.add(new User(2, "Yamamoto", 29));

    }
}
