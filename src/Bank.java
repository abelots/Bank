import java.util.HashMap;
import java.util.Map;



public class Bank {

    private Map users = new HashMap< String, User>();

    public Bank() {
    }

    public Map getUsers() {
        return users;
    }


    public BankError addUser(User user){
        if (users.get(user.getLogin())==null) {
            users.put(user.getLogin(), user);
            return BankError.OK;
        } else {
            return BankError.LOGIN_ERROR;
        }
    }

    public User getUser(String login ){
        return (User)users.get(login);
    }
}

