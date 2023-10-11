package web.config;

import web.model.User;

public class AppNotWeb {
    public static void main(String[] args) {


        User user = new User();
        user.setName("Marina");
        user.setAge(20);
        user.setId(1);

        System.out.println(user);




    }
}
