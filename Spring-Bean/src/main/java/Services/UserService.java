package Services;

import Entity.User;
import org.apache.catalina.core.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    public static List<User> userList = new ArrayList<>();

    static {
        User user = new User("Razib",23);
        userList.add(user);
        user = new User("Samiha", 20);
        userList.add(user);
    }

    public List getList(){
        return  userList;
    }
}
