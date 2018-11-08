public class User {
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
    boolean checkPassword(String password){
        return this.password.compareTo(password)==0;
    }

}
