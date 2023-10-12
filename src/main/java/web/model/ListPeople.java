package web.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListPeople {
    public static List<User> USERS = new ArrayList<>();

    static {
        USERS.add(new User(1, "Marina", 20));
        USERS.add(new User(2, "Takano", 24));
        USERS.add(new User(3, "Gokudera", 23));
        USERS.add(new User(4, "Yamamoto", 29));

    }

    public static HashMap<Integer, User> USSERS = new HashMap<>();
    static {
        USSERS.put(1, new User(1, "Marina", 20));
        USSERS.put(2, new User(2, "Takano", 24));
        USSERS.put(3, new User(2, "Gokudera", 23));
        USSERS.put(4, new User(2, "Yamamoto", 29));

    }

}
